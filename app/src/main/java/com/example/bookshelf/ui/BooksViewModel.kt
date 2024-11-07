package com.example.bookshelf.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.model.BookData
import com.example.bookshelf.model.BooksData
import com.example.bookshelf.network.BooksRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException


sealed interface AppStatus{
    object Loading : AppStatus
    object Error : AppStatus
    class Success(books: List<BookData>) : AppStatus
}






class BooksViewModel(appStatus: AppStatus): ViewModel() {

    private val repository = BooksRepository()

    private lateinit var _books: MutableState<BooksData>
//            MutableList<BookData> = mutableListOf()
    var booksRecievedData = _books.value.items

    var appStatus: AppStatus by mutableStateOf(AppStatus.Loading)
        private set


    fun fetchBooks(){
        viewModelScope.launch {
            try{
                val books = repository.getJazzData()
                _books.value = books
                appStatus = AppStatus.Success(_books.value.items)
            } catch (e: Exception){
                //TODO("Обработать ошибку получения данных")
                appStatus = AppStatus.Error
            }
        }
    }


    init {
        fetchBooks()
    }


}