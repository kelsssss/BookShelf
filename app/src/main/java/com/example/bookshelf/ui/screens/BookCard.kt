package com.example.bookshelf.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import com.example.bookshelf.R
import com.example.bookshelf.ui.theme.BookShelfTheme

@Composable
fun BookCard(
    modifier: Modifier,
    navController: NavController
){
    Card(modifier = modifier
        .height(300.dp)
        .padding(10.dp)
        .clickable(
            onClick = { navController.navigate("BookDescription")}
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize(),
        ) {
            Image(
                painter = painterResource(R.drawable.test_book_picture),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxSize()
                    .weight(8f),

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