package com.example.mistplaychallenge.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mistplaychallenge.R
import com.example.mistplaychallenge.presentation.ui.Dimensions
import com.example.mistplaychallenge.presentation.ui.model.FinalUIState
import com.example.mistplaychallenge.presentation.ui.model.PostUI
import com.example.mistplaychallenge.presentation.ui.theme.MistPlayChallengeTheme
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostList(finalUIState: FinalUIState, modifier: Modifier = Modifier) {
    Timber.d("PostList UI State: $finalUIState")
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(stringResource(R.string.lbl_screen_title))
                }
            )
        },
        modifier = modifier
    ) { paddingValues ->
        when (finalUIState) {
            FinalUIState.Loading -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(stringResource(R.string.lbl_loading_state))
                }
            }

            is FinalUIState.Error -> {
                ErrorContent(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )
            }

            is FinalUIState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    itemsIndexed(finalUIState.data) { index, item ->
                        PostCard(
                            item, modifier = Modifier
                                .fillMaxWidth()
                                .padding(Dimensions.medium)
                        )
                        if (index < finalUIState.data.size - 1)
                            HorizontalDivider()
                    }
                }

            }
        }
    }

}

@Preview
@Composable
private fun PreviewPostListErrorState() {
    MistPlayChallengeTheme {
        PostList(FinalUIState.Error("Sorry something went wrong!"))
    }
}

@Preview
@Composable
private fun PreviewPostListLoadingState() {
    MistPlayChallengeTheme {
        PostList(FinalUIState.Loading)
    }
}

@Preview
@Composable
private fun PreviewPostListSuccessState() {
    MistPlayChallengeTheme {
        PostList(
            FinalUIState.Success(
                listOf(
                    PostUI(
                        userId = 1,
                        id = 1,
                        title = "Title",
                        body = "Body",
                        userName = "User Name"
                    )
                )
            )
        )
    }
}