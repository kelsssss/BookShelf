package com.example.bookshelf.ui

//import android.net.http.HttpException
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil3.network.HttpException
import com.example.bookshelf.model.BookData
import com.example.bookshelf.model.BooksData
import com.example.bookshelf.network.BooksRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException


sealed interface AppStatus{
    data class Success(val booksDataList: List<BookData>) : AppStatus
    object Loading : AppStatus
    object Error : AppStatus
}


class BooksViewModel(): ViewModel() {

    private val repository = BooksRepository()

//    private lateinit var _books: MutableState<BooksData>
//            MutableList<BookData> = mutableListOf()


    var appStatus: AppStatus by mutableStateOf(AppStatus.Loading)
        private set


    fun fetchBooks(){
        viewModelScope.launch {
            appStatus = try{
//                val books = repository.getJazzData().items
                AppStatus.Success(booksDataList = repository.getJazzData().items)
            } catch (e: RuntimeException){
                AppStatus.Error
            } catch (e: IOException) {
           AppStatus.Error
        } catch (e: HttpException){
            AppStatus.Error
        }

        }
    }


//    companion object {
//        val Factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
//                val amphibiansRepository = application.container.amphibiansRepository
//                AmphibianViewModel(amphibiansRepository = amphibiansRepository)
//            }
//        }
//    }


    init {
        fetchBooks()
    }


}