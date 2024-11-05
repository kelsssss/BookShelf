package com.example.bookshelf.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    val BASE_URL = "https://www.googleapis.com/books/v1"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val booksApiService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }
}
