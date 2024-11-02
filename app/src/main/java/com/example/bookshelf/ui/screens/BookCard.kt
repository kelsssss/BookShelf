package com.example.bookshelf.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookshelf.R
import com.example.bookshelf.ui.theme.BookShelfTheme

@Composable
fun BookCard(modifier: Modifier){
    Card(modifier = modifier
//        .width(250.dp)
        .height(300.dp)
        .padding(10.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.test_book_picture),
                contentDescription = null,
                modifier = modifier
                    .fillMaxSize()
                    .weight(8f)
//                    .padding(10.dp)
                ,
                contentScale = ContentScale.Crop
            )
//            Text(
//                text = "Название книги",
//                modifier = Modifier
//                    .weight(1f)
//            )
        }
    }
}


@Preview
@Composable
fun BookCardPreview(){
    BookShelfTheme {
        BookCard(
            modifier = Modifier
        )
    }
}