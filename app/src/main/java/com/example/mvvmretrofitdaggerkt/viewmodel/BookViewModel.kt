package com.example.mvvmretrofitdaggerkt.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrofitdaggerkt.di.DaggerDiComponent
import com.example.mvvmretrofitdaggerkt.model.Book
import com.example.mvvmretrofitdaggerkt.model.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BookViewModel : ViewModel() {
    @Inject
    lateinit var bookRepository: BookRepository
    val booksLiveData = MutableLiveData<List<Book>>()

    init {
        DaggerDiComponent.builder().build().inject(this)
    }

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