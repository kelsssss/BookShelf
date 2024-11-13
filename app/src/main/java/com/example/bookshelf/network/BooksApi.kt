package com.example.bookshelf.network

import com.example.bookshelf.model.BooksData
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService{
    @GET("volumes?q=jazz")
    suspend fun getJazzData(): BooksData

    @GET("volumes")
    suspend fun getSearchBooksData(@Query("q") query : String) : BooksData


}