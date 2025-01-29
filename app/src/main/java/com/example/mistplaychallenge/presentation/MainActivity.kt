package com.example.mistplaychallenge.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mistplaychallenge.presentation.ui.model.FinalUIState
import com.example.mistplaychallenge.presentation.ui.theme.MistPlayChallengeTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.mistplaychallenge.presentation.ui.components.PostList
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MistPlayChallengeTheme {
                val finalUIState by viewModel.combinedData.collectAsStateWithLifecycle()
                Content(
                    finalUIState = finalUIState,
                    modifier = Modifier
                        .safeDrawingPadding()
                        .fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    finalUIState: FinalUIState
) {
    Timber.d("Content called with $finalUIState")
    PostList(finalUIState, modifier = modifier)
}


@Preview(showBackground = true)
@Composable
private fun ContentLoadingPreview() {
    MistPlayChallengeTheme {
        Content(finalUIState = FinalUIState.Loading)
    }
}