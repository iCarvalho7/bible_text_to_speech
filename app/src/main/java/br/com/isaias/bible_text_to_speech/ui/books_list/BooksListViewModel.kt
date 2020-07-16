package br.com.isaias.bible_text_to_speech.ui.books_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.isaias.bible_text_to_speech.data.model.Books
import br.com.isaias.bible_text_to_speech.data.model.Versions
import br.com.isaias.bible_text_to_speech.data.repository.BookRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class BooksListViewModel : ViewModel() {

    private val _booksList = MutableLiveData<List<Books>>()
    val booksList : LiveData<List<Books>> = _booksList

    private val _versions = MutableLiveData<List<Versions>>()
    val versions : LiveData<List<Versions>> = _versions

    fun getAllBibliesBooks(){
        viewModelScope.launch {
            val repository = BookRepository()
            val res = repository.getAllBooks()
            try {
                if (res.isSuccessful){
                    _booksList.value = res.body()
                }else{
                    when(res.code()){
                        500 -> Log.d("BooksListViewModel", "500")
                        401 -> Log.d("BooksListViewModel", "Token Error")
                    }
                }
            }catch (e : Exception){

            }
        }
    }

    fun getBibliesVersions() {
        viewModelScope.launch {
            val repository = BookRepository()
            val res = repository.getBiblesVersion()
            try {
                if (res.isSuccessful){
                    _versions.value = res.body()
                }else{
                    when(res.code()){
                        500 -> Log.d("BooksListViewModel", "500")
                        401 -> Log.d("BooksListViewModel", "Token Error")
                    }
                }
            }catch (e : Exception){

            }
        }
    }
}