package com.example.bookshelf.network

import com.example.bookshelf.model.BooksData


class BooksRepository
//    var query : String
 {
    private val booksService = RetrofitInstance.booksApiService

    suspend fun getJazzData() : BooksData{
        return booksService.getJazzData()
    }

//    suspend fun getSearchBookData(query : String) : BooksData{
    suspend fun getSearchBookData(query : String) : BooksData{
        return booksService.getSearchBooksData(query = query)
    }

}