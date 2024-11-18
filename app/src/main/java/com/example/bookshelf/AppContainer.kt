package com.example.bookshelf

import com.example.bookshelf.network.BooksApiService
import com.example.bookshelf.network.BooksRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val booksRepository : BooksRepository
}


class DefaultAppContainer : AppContainer {

        val BASE_URL = "https://www.googleapis.com/books/v1/"

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private val booksApiService: BooksApiService by lazy {
            retrofit.create(BooksApiService::class.java)
        }

        override val booksRepository: BooksRepository = BooksRepository(booksApiService)




}