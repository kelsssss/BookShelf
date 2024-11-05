package com.example.bookshelf

data class BooksData(
    val kind: String,
    val totalItems: Int,
    val items: List<BookData>,
)