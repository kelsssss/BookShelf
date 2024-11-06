package com.example.bookshelf.ui

import androidx.compose.runtime.MutableState
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

    private lateinit var _books: MutableState<BooksData>
//            MutableList<BookData> = mutableListOf()
    var booksRecievedData = _books.value.items

    fun fetchBooks(){
        viewModelScope.launch {
            try{
                val books = repository.getJazzData()
                _books.value = books
            } catch (e: Exception){
                //TODO("Обработать ошибку получения данных")
            }
        }
    }


//    init {
//        fetchBooks()
//    }


}