package ru.netology

class Audio(
        val id: Int,
        val ownerId: Int,
        val artist: String,
        val title: String,
        val duration: Int,
        val url: String,
        val lyricsId: Int,
        val albumId: Int,
        val genreIs: Int,
        val date: Int,
        val noSearch: Boolean,
        val isHq: Boolean
)