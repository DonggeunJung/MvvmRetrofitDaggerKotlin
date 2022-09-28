package com.example.mvvmretrofitdaggerkt.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofitdaggerkt.R
import com.example.mvvmretrofitdaggerkt.databinding.BookListItemBinding
import com.example.mvvmretrofitdaggerkt.model.Book

class BookRvAdapter(private val parent: AppCompatActivity) :
    RecyclerView.Adapter<BookRvAdapter.BookViewHolder>() {
    private var books = listOf<Book>()

    fun setBooks(list: List<Book>) {
        books = list
        this.notifyDataSetChanged()
    }

    // Return list items count
    override fun getItemCount(): Int {
        return books.size
    }

    // Make ViewHolder & View binding object
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BookViewHolder {
        // Get the view binding object of custom list item layout
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = BookListItemBinding.inflate(inflater, viewGroup, false)
        // Set the Lifecycle Owner of View binding to fragment
        binding.lifecycleOwner = parent

        // Make ViewHolder object
        return BookViewHolder(binding)
    }

    // When ViewHolder is binded set data to binding object
    override fun onBindViewHolder(viewHolder: BookViewHolder, position: Int) {
        // Set item index number to binding object
        viewHolder.bind(books[position])
    }

    // Reusable view
    class BookViewHolder(private val binding: BookListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            binding.book = book
        }
    }

}
