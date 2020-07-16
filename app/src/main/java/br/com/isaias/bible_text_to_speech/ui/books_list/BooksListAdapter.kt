package br.com.isaias.bible_text_to_speech.ui.books_list


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.isaias.bible_text_to_speech.data.model.Books
import br.com.isaias.bible_text_to_speech.databinding.BookItemBinding

class BooksListAdapter(private val viewModel: BooksListViewModel) :
    ListAdapter<Books, BooksListAdapter.ViewHolder>(BookDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(viewModel, item)
    }

    class ViewHolder private constructor(val binding: BookItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: BooksListViewModel, item: Books?) {
            binding.viewModel = viewModel
            binding.book = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = BookItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class BookDiffCallback : DiffUtil.ItemCallback<Books>() {
    override fun areItemsTheSame(oldItem: Books, newItem: Books): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Books, newItem: Books): Boolean {
        return oldItem == newItem
    }
}
