package com.example.bookshelf.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookshelf.R
import com.example.bookshelf.ui.theme.BookShelfTheme

@Composable
fun ErrorScreen(
    modifier : Modifier = Modifier
){
    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.error),
                contentDescription = "Error occurred",
                modifier = modifier
                    .fillMaxWidth(0.7f)
            )
            Text(
                text = "An error occurred, check your internet connection and try again later"
            )
            Button(
                onClick = { }
            ) {
                Text(
                    "Try again"
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview(){
    BookShelfTheme {
        ErrorScreen()
    }
}