package com.example.bookshelf.network

import retrofit2.http.GET

interface BooksApi{
    @GET
    fun getData():
}