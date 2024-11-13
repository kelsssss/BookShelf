package com.example.bookshelf.model

data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    val imageLinks: ImageLinks,
)
