package br.com.isaias.bible_text_to_speech.data.api

import br.com.isaias.bible_text_to_speech.BuildConfig
import br.com.isaias.bible_text_to_speech.data.service.BookService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitStarter {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request()
            val authRequest = request.newBuilder()
                .header("Authorization"," Bearer " + BuildConfig.API_KEY)
                .build()
            chain.proceed(authRequest)
        }
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun createBookService() = retrofit.create(BookService::class.java)
}