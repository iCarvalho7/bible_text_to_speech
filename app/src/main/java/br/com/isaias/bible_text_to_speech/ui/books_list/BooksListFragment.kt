package br.com.isaias.bible_text_to_speech.ui.books_list

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.isaias.bible_text_to_speech.data.model.Books
import br.com.isaias.bible_text_to_speech.databinding.BooksListFragmentBinding

class BooksListFragment : Fragment() {

    private lateinit var booksListViewModel: BooksListViewModel
    private lateinit var binding: BooksListFragmentBinding
    private lateinit var booksListAdapter: BooksListAdapter
    private lateinit var versionListAdapter: VersionListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        booksListViewModel = ViewModelProvider(this).get(BooksListViewModel::class.java)


        binding = BooksListFragmentBinding.inflate(inflater, container, false).apply {
            booksListViewModel.getBibliesVersions()
            booksListViewModel.getAllBibliesBooks()
            viewModel = booksListViewModel
        }
        setUpObserve()
        setUpListener()
        return binding.root
    }

    private fun setUpListener() {
        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterBooks(s.toString().trim().toLowerCase())
            }
        })
    }

    private fun filterBooks(text: String) {
        val newList = mutableListOf<Books>()
        for(book in booksListViewModel.booksList.value!!) {
            if (book.name?.toLowerCase()?.contains(text)!!){
                newList.add(book)
            }
            booksListAdapter.submitList(newList)
        }
    }

    fun setUpObserve() {
        booksListViewModel.booksList.observe(viewLifecycleOwner, Observer {
            booksListAdapter = BooksListAdapter(booksListViewModel)
            booksListAdapter.submitList(it.toMutableList())
            binding.bookListBooksRecyclerView.adapter = booksListAdapter
        })

//        booksListViewModel.versions.observe(viewLifecycleOwner, Observer {
//            versionListAdapter = VersionListAdapter(booksListViewModel)
//            versionListAdapter.submitList(it)
//            binding.bookListVersionsRecyclerView.adapter = versionListAdapter
//        })
    }
}