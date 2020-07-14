package br.com.isaias.bible_text_to_speech.data.repository

import br.com.isaias.bible_text_to_speech.data.api.RetrofitStarter

class BookRepository {
    val service = RetrofitStarter().createBookService()
    suspend fun getAllBooks() = service.fetchBibleBooks()
}