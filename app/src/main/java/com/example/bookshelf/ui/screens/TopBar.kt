package com.example.bookshelf.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import com.example.bookshelf.ui.BooksViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavHostController,
    canNavigateBack: MutableState<Boolean>,
    viewModel: BooksViewModel,
){
    val isSearching = remember { mutableStateOf(false) }

    CenterAlignedTopAppBar(
        title = {
        when(isSearching.value){
          true -> {
              SearchField(
                  viewModel = viewModel
              )
          }
            false -> {
                Text(
                text = "BookShelf"
            )
            }
        }

        },
        navigationIcon = {
            if(canNavigateBack.value) {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                            canNavigateBack.value = false

                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Return to menu"
                        )
                    }
            }
        },
        actions = {
            when (isSearching.value) {
                false -> {
                    IconButton(
                        onClick = {
                            isSearching.value = !isSearching.value
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Search button"
                        )
                    }
                }
                true -> {
                    IconButton(
                        onClick = {

                            isSearching.value = !isSearching.value

                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = "Close button"
                        )
                    }
                }

            }
        }
    )
}