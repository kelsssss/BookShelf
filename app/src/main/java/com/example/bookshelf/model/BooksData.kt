package com.example.bookshelf.model

data class BooksData(
    val kind: String,
    val totalItems: Int,
    val items: List<BookData>,
)