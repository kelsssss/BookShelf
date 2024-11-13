package com.example.bookshelf.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.bookshelf.ui.BooksViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    viewModel: BooksViewModel
) {
    val searchText = remember { mutableStateOf("") }
    val expanded = remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()

    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = searchText.value,
                onQueryChange = { enteredText ->
                    searchText.value = enteredText
                },
                onSearch = {
                    coroutineScope.launch {
                        viewModel.fetchSearchBooks(enteredQuery = it)
                    }
                    expanded.value = false
                },
                expanded = expanded.value,
                onExpandedChange = { newExpandedValue ->
                    expanded.value = newExpandedValue
                },
                placeholder = {
                    Text(
                        text = "Search books..."
                    )
                }
            )
        },
        expanded = expanded.value,
        onExpandedChange = { newExpandedValue ->
            expanded.value = newExpandedValue
        },
        modifier = modifier,
    ) {

    }
}