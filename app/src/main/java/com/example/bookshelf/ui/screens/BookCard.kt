package com.example.bookshelf.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.bookshelf.R

@Composable
fun BookCard(
    modifier: Modifier,
    navController: NavController,
    canNavigateBack:  MutableState<Boolean>,
    bookTitle: String,
    bookImgUrl: String,
    bookId: String,
){
    Card(modifier = modifier
        .height(300.dp)
        .padding(10.dp)
        .clickable(
            onClick = {

                navController.navigate("BookDescription")
                canNavigateBack.value = true
            }
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize(),
        ) {
//            Image(
//                painter = painterResource(R.drawable.test_book_picture),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = modifier
//                    .fillMaxSize()
//                    .weight(8f),
//
//            )

            AsyncImage(
//                model = "https://books.google.com/books/content?id=1LY4AQAAIAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api",
                model = bookImgUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxSize()
                    .weight(8f),
            )


            Text(
                text = bookTitle
            )

        }
    }
}


//@Preview
//@Composable
//fun BookCardPreview(){
//    BookShelfTheme {
//        BookCard(
//            modifier = Modifier
//        )
//    }
//}