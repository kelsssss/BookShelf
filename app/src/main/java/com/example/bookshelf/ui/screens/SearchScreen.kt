package com.example.bookshelf.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookshelf.ui.theme.BookShelfTheme
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
) {
    val searchText = remember { mutableStateOf("") }
    val expanded = remember { mutableStateOf(false) }

    //Для проверки используется список и для истории и для тестовых результатов
    val mainList = remember { mutableStateOf(Utils.testBookNames) }


    Surface {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Enter your query below:",
                fontSize = 30.sp
            )
            Spacer(
                modifier = modifier
                    .height(10.dp)
            )
            SearchBar(
                inputField = {
                    SearchBarDefaults.InputField(
                        query = searchText.value,
                        onQueryChange = { text ->
                                searchText.value = text
                                mainList.value = Utils.search(text)
                        },
                        onSearch = { text ->
                            mainList.value = Utils.search(text)
                            expanded.value = false

                        },
                        expanded = expanded.value,
                        onExpandedChange = {
                            expanded.value = it
                        },
                        placeholder = {
                            Text(text = "Search book...")
                        }
                    )
                },
                expanded = expanded.value,
                onExpandedChange = {
                    expanded.value = it
                },
                modifier = modifier
                    .fillMaxWidth()
            ) {
//                Text(text = "Hello")
                LazyColumn(
                    modifier = modifier
                        .fillMaxWidth()
                ) {
                    items(mainList.value){ item ->
                        Box(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                                .clickable {
                                    mainList.value = Utils.search(item)
                                    expanded.value = false
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = item)
                        }
                    }
                }
            }
            LazyColumn {
                items(mainList.value){ item ->
                    Text(text = item)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview(){
    BookShelfTheme() {
        SearchScreen()
    }
}

object Utils{
    fun search(text: String) : List<String> {
        return testBookNames.filter {
            it.startsWith(text, ignoreCase = true)
        }

    }
















    val testBookNames = listOf(
        "Fight Club",
        "Kolobok",
        "Maths",
        "Grokaem algoritmy",
        "Johny got his rifle"
    )



}