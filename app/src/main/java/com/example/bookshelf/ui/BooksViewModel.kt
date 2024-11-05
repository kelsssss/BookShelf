package com.example.bookshelf.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.model.BookData
import com.example.bookshelf.model.BooksData
import com.example.bookshelf.network.BooksRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException

class BooksViewModel: ViewModel() {

    private val repository = BooksRepository()

    private var _books = mutableStateOf<BooksData>()
//            MutableList<BookData> = mutableListOf()

    fun fetchBooks(){
        viewModelScope.launch {
            try{
                val books = repository.getJazzData()

            } catch (e: Exception){

            }
        }
    }


    init {
        fetchBooks()
    }


}