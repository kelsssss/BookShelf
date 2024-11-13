package com.example.bookshelf.network

import com.example.bookshelf.model.BooksData


class BooksRepository {
    private val booksService = RetrofitInstance.booksApiService


    suspend fun getSearchBookData(query: String): BooksData {
        return booksService.getSearchBooksData(query = query)
    }

}