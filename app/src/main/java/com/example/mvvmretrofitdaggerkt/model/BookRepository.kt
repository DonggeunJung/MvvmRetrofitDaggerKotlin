package com.example.mvvmretrofitdaggerkt.model

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class BookRepository(var api: BookApi) {

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
