package com.example.bookshelf.network

import com.example.bookshelf.model.BooksData
import retrofit2.http.GET

interface BooksApiService{
    @GET("volumes?q=jazz")
    suspend fun getJazzData(): BooksData


}