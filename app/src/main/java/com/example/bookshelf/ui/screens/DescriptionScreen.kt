package com.example.bookshelf.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookshelf.R
import com.example.bookshelf.ui.theme.BookShelfTheme

@Composable
fun DescriptionScreen(modifier: Modifier = Modifier){
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
                painterResource(R.drawable.test_book_picture),
                contentDescription = null,
                modifier = modifier
                    .height(400.dp)
                    .fillMaxSize()
            )
            Text(
                text = "Title:"
            )
            Text(
                text = "Test Title"
            )
            Text(
                text = "Authors:"
            )
            Text(
                text = "Text Author1, Text Author2"
            )
        }
    }
}

@Preview
@Composable
fun DescriptionScreenPreview(){
    BookShelfTheme {
        DescriptionScreen()
    }
}