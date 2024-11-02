package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookshelf.ui.theme.BookShelfTheme

@Composable
fun BookGrid(
    modifier: Modifier
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxSize()
//        contentPadding = PaddingValues(20.dp)

    ) {
        items(30){
            BookCard(
                modifier = Modifier
//                    .fillMaxSize()
//                    .fillMaxWidth(0.9f)
            )
        }
    }
}

@Preview
@Composable
fun BookGridPreview(){
    BookShelfTheme {
        BookGrid(
            modifier = Modifier
        )
    }
}