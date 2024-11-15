package com.example.bookshelf.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil3.network.HttpException
import com.example.bookshelf.model.BookData
import com.example.bookshelf.model.VolumeInfo
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

sealed interface DescriptionStatus {
    data class Success(val receivedBookData : VolumeInfo) : DescriptionStatus
    object Loading : DescriptionStatus
    object Error : DescriptionStatus
}


class BooksViewModel() : ViewModel() {

    private val repository = BooksRepository()

    var appStatus: AppStatus by mutableStateOf(AppStatus.Welcome)
        private set

    var bookId : String by mutableStateOf("")

    var descriptionStatus: DescriptionStatus by mutableStateOf(DescriptionStatus.Loading)

    fun fetchSearchBooks(
        enteredQuery: String
    ) {
        viewModelScope.launch {
            appStatus = AppStatus.Loading
            appStatus = try {
                AppStatus.Success(booksDataList = repository.getSearchBookData(query = enteredQuery).items)
            } catch (e: RuntimeException) {
                AppStatus.NothingFound
            } catch (e: IOException) {
                AppStatus.Error
            } catch (e: HttpException) {
                AppStatus.Error
            } catch (e: Exception) {
                AppStatus.Error
            }
        }
    }

    fun closeSearchBar() {
        appStatus = AppStatus.Welcome
    }

    fun fetchBookById(
        id : String
    ) {
        viewModelScope.launch{
            descriptionStatus = DescriptionStatus.Loading
            descriptionStatus = try {
                DescriptionStatus.Success(receivedBookData = repository.getDescriptionById(id = id).volumeInfo)
            } catch (e: RuntimeException) {
                DescriptionStatus.Error
            } catch (e: IOException) {
                DescriptionStatus.Error
            } catch (e: HttpException) {
                DescriptionStatus.Error
            } catch (e: Exception) {
                DescriptionStatus.Error
            }
        }
    }

}