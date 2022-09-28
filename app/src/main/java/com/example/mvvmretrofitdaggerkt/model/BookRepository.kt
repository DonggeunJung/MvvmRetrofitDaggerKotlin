package com.example.mvvmretrofitdaggerkt.model

import com.example.mvvmretrofitdaggerkt.di.DaggerDiComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class BookRepository {
    @Inject
    lateinit var api: BookApi

    init {
        DaggerDiComponent.builder().build().inject(this)
    }

    suspend fun reqBooksFromServer(): List<Book>? {
        val call: Call<List<Book>> = api.books
        return suspendCoroutine { continuation ->
            call.enqueue(object : Callback<List<Book>> {
                override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                    continuation.resume(response.body())
                }

                override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                    continuation.resume(null)
                }
            })
        }
    }

}