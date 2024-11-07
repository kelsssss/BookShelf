package com.example.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookshelf.ui.screens.BookGrid
import com.example.bookshelf.ui.screens.DescriptionScreen
import com.example.bookshelf.ui.screens.TopBar
import com.example.bookshelf.ui.theme.BookShelfTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BookShelfApp(){

    var viewModel: BooksViewModel = viewModel()

//    LaunchedEffect(Unit) {
//        viewModel.fetchBooks()
//    }

    val navController = rememberNavController()

    var canNavigateBack = remember { mutableStateOf(false) }





    BookShelfTheme {

            Scaffold(
                topBar = {
                    TopBar(
                        navController = navController,
                        canNavigateBack = canNavigateBack,
                    )
                },
                modifier = Modifier
                    .fillMaxSize()
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = "BooksGrid"
                ) {
                    composable(route = "BooksGrid") {
                        BookGrid(
                            canNavigateBack = canNavigateBack,
                            navController = navController,
//                            recievedBookDataList = viewModel.
//                            appStatus = viewModel.appStatus,
                            booksViewModel = viewModel,
                            modifier = Modifier
                                .padding(innerPadding)
                        )
                    }
                    composable(route = "BookDescription") {
                        DescriptionScreen()
                    }
                }


            }
//        }
    }
}

