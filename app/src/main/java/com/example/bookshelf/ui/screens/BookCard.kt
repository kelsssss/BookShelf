package com.example.bookshelf.ui.screens

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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.bookshelf.ui.BooksViewModel
import kotlinx.coroutines.launch

@Composable
fun BookCard(
    modifier: Modifier,
    viewModel: BooksViewModel,
    navController: NavController,
    bookTitle: String,
    bookImgUrl: String,
    bookId: String,
) {

    Card(modifier = modifier
        .height(300.dp)
        .padding(10.dp)
        .clickable(
            onClick = {
                viewModel.bookId = bookId
                navController.navigate("BookDescription")
            }
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize(),
        ) {

            AsyncImage(
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