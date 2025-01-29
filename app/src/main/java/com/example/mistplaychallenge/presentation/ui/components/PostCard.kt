package com.example.mistplaychallenge.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.mistplaychallenge.presentation.ui.Dimensions
import com.example.mistplaychallenge.presentation.ui.model.PostUI
import com.example.mistplaychallenge.presentation.ui.theme.MistPlayChallengeTheme

@Composable
fun PostCard(postUI: PostUI, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        PostDetails(
            postUI, modifier = Modifier
                .padding(Dimensions.medium)
        )
        Spacer(modifier = Modifier.size(Dimensions.medium))
        Row {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "By ${postUI.userName}",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Composable
private fun PostDetails(postUI: PostUI, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = postUI.title,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.size(Dimensions.medium))
        Text(
            text = postUI.body,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PostCardPreview() {
    MistPlayChallengeTheme {
        PostCard(
            PostUI(
                id = 1,
                userId = 1,
                userName = "Test",
                title = "userTest",
                body = "Body"
            )
        )
    }
}