package com.example.bookshelf.network

import com.example.bookshelf.model.BookData
import com.example.bookshelf.model.BooksData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApiService {
    @GET("volumes")
    suspend fun getSearchBooksData(@Query("q") query: String): BooksData

    @GET("volumes/{id}")
    suspend fun getDescriptionById(@Path("id") id: String) : BookData
}