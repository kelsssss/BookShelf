package com.example.bookshelf.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
){
    var inputFieldText by remember {mutableStateOf("")}
    val expanded by remember{ mutableStateOf(false)}

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
//

        SearchBar(
            inputField = {
                SearchBarDefaults.InputField(
                    query = inputFieldText,
                    expanded = expanded,
                    onSearch = {
                        inputFieldText = it,
                        expanded = false,
                    },
                    onQueryChange = {

                    },
                    onExpandedChange =
                )
            }
        ) { }
    }
}