package com.example.mvvmretrofitdaggerkt.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BookApi {
    @get:GET("books.json")
    val books: Call<List<Book>>

    companion object {
        private const val BASE_URL = "http://de-coding-test.s3.amazonaws.com/"

        // Create Retrofit object
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
            .build()
    }
}