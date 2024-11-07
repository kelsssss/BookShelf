package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.bookshelf.model.BookData
import com.example.bookshelf.ui.AppStatus
import com.example.bookshelf.ui.BooksViewModel
import com.example.bookshelf.ui.theme.BookShelfTheme

@Composable
fun BookGrid(
    booksViewModel: BooksViewModel,
//    appStatus: AppStatus,
//    recievedBookDataList: List<BookData>,
    canNavigateBack: MutableState<Boolean>,
    navController: NavController,
    modifier: Modifier
){
    val appStatus = booksViewModel.appStatus

    when(appStatus) {
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
                        canNavigateBack = canNavigateBack,
                        bookTitle = book.volumeInfo.title,
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