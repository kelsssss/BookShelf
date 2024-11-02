package com.example.bookshelf.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavHostController,
    canNavigateBack: MutableState<Boolean>
){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "BookShelf"
        )
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
        }
    )
}