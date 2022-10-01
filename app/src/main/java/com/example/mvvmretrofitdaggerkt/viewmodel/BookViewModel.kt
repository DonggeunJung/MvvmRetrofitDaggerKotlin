package com.example.mvvmretrofitdaggerkt.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrofitdaggerkt.model.Book
import com.example.mvvmretrofitdaggerkt.model.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookViewModel(var bookRepository: BookRepository) : ViewModel() {
    val booksLiveData = MutableLiveData<List<Book>>()

    // Request Card data list to Repository
    fun reqBooks() {
        viewModelScope.launch {
            val books = bookRepository.reqBooksFromServer()

            withContext(Dispatchers.Main) {
                books?.let { booksLiveData.postValue(it) }
            }
        }
    }

}
