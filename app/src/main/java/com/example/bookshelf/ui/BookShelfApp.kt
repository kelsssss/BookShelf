package com.example.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookshelf.ui.screens.BookGrid
import com.example.bookshelf.ui.screens.DescriptionScreen
import com.example.bookshelf.ui.screens.TopBar
import com.example.bookshelf.ui.theme.BookShelfTheme

@Composable
fun BookShelfApp() {

    val navController = rememberNavController()
    val canNavigateBack = remember { mutableStateOf(navController.previousBackStackEntry != null) }
    val viewModel: BooksViewModel = viewModel(factory = BooksViewModel.factory)


    BookShelfTheme {
        Scaffold(
            topBar = {
                TopBar(
                    navController = navController,
                    canNavigateBack = canNavigateBack.value,
                    viewModel = viewModel
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
                            navController = navController,
                            viewModel = viewModel,
                            modifier = Modifier
                                .padding(innerPadding)
                        )
                    }
                    composable(route = "BookDescription") {
                        DescriptionScreen(
                            viewModel = viewModel,
                            canNavigateBack = canNavigateBack,
                            navController = navController,
                        )
                    }
                }
            }


        }


}

