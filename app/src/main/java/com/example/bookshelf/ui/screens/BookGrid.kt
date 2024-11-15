package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bookshelf.ui.AppStatus
import com.example.bookshelf.ui.BooksViewModel

@Composable
fun BookGrid(
    viewModel: BooksViewModel,
    navController: NavController,
    modifier: Modifier
) {
    val appStatus = viewModel.appStatus

    when (appStatus) {
        is AppStatus.NothingFound -> {
            NothingFoundScreen()
        }

        is AppStatus.Welcome -> {
            WelcomeScreen()
        }

        is AppStatus.Loading -> {
            LoadingScreen()
        }

        is AppStatus.Success -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = modifier
                    .fillMaxSize()
            ) {
                items(appStatus.booksDataList) { book ->
                    BookCard(
                        navController = navController,
                        bookTitle = book.volumeInfo.title,
                        bookImgUrl = book.volumeInfo.imageLinks.thumbnail,
                        viewModel = viewModel,

                        //For a book description
                        bookId = book.id,
                        modifier = Modifier
                    )
                }
            }
        }

        else -> {
            ErrorScreen()
        }
    }
}

//@Preview
//@Composable
//fun BookGridPreview(){
//    BookShelfTheme {
//        BookGrid(
//            modifier = Modifier
//        )
//    }
//}