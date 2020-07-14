package br.com.isaias.bible_text_to_speech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.isaias.bible_text_to_speech.data.repository.BookRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val repository = BookRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            repository.getAllBooks()
        }
    }
}