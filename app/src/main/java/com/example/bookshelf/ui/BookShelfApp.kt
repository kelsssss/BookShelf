package com.example.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BookShelfApp(){
    BookShelfTheme {
        val navController = rememberNavController()

        var canNavigateBack = remember { mutableStateOf(false) }


        Scaffold(
            topBar = { TopBar(
                navController = navController,
                canNavigateBack = canNavigateBack,
                ) },
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
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
                composable(route = "BookDescription") {
                    DescriptionScreen()
                }
            }


        }
    }
}

