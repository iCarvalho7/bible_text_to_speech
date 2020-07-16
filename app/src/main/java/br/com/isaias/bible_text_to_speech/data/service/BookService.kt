package br.com.isaias.bible_text_to_speech.data.service

import br.com.isaias.bible_text_to_speech.data.model.Books
import br.com.isaias.bible_text_to_speech.data.model.Versions
import retrofit2.Response
import retrofit2.http.GET

interface BookService {
    @GET("api/books")
    suspend fun fetchBibleBooks() : Response<List<Books>>
    @GET("api/versions")
    suspend fun fetchVersions(): Response<List<Versions>>
}