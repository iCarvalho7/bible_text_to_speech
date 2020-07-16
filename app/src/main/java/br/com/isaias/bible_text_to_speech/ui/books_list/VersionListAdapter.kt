package br.com.isaias.bible_text_to_speech.ui.books_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.isaias.bible_text_to_speech.data.model.Versions
import br.com.isaias.bible_text_to_speech.databinding.BiblesVersionsItemBinding

class VersionListAdapter(private val viewModel: BooksListViewModel) :
    ListAdapter<Versions, VersionListAdapter.ViewHolder>(VersionDiffCallback()){

    class ViewHolder private constructor(val binding: BiblesVersionsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: BooksListViewModel, item: Versions) {
            binding.versions = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = BiblesVersionsItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(viewModel, item)
    }
}

class VersionDiffCallback : DiffUtil.ItemCallback<Versions>() {
    override fun areItemsTheSame(oldItem: Versions, newItem: Versions): Boolean {
        return oldItem.version == newItem.version
    }

    override fun areContentsTheSame(oldItem: Versions, newItem: Versions): Boolean {
        return oldItem == newItem
    }
}

