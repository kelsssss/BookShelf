package com.example.bookshelf.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil3.network.HttpException
import com.example.bookshelf.model.BookData
import com.example.bookshelf.network.BooksRepository
import kotlinx.coroutines.launch
import okio.IOException


sealed interface AppStatus {
    data class Success(val booksDataList: List<BookData>) : AppStatus
    object Loading : AppStatus
    object Error : AppStatus
    object Welcome : AppStatus
    object NothingFound : AppStatus
}


class BooksViewModel() : ViewModel() {

    private val repository = BooksRepository()

    var appStatus: AppStatus by mutableStateOf(AppStatus.Welcome)
        private set


    fun fetchSearchBooks(
        enteredQuery: String
    ) {
        viewModelScope.launch {
            appStatus = AppStatus.Loading
            appStatus = try {
                AppStatus.Success(booksDataList = repository.getSearchBookData(query = enteredQuery).items)
            } catch (_: RuntimeException) {
                AppStatus.NothingFound
            } catch (_: IOException) {
                AppStatus.Error
            } catch (_: HttpException) {
                AppStatus.Error
            } catch (_: Exception) {
                AppStatus.Error
            }

        }
    }

    fun closeSearchBar() {
        appStatus = AppStatus.Welcome
    }

}