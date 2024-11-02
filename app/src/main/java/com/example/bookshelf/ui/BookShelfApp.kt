package com.example.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookshelf.ui.screens.BookGrid
import com.example.bookshelf.ui.screens.TopBar
import com.example.bookshelf.ui.theme.BookShelfTheme

@Composable
fun BookShelfApp(){
    BookShelfTheme {
        Scaffold(
            topBar = { TopBar() },
            modifier = Modifier
                .fillMaxSize()
        ) { innerPadding ->





            BookGrid(
                modifier = Modifier
                    .padding(innerPadding)
            )
        }
    }
}

