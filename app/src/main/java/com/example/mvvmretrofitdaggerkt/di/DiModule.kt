package com.example.mvvmretrofitdaggerkt.di

import com.example.mvvmretrofitdaggerkt.model.BookApi
import com.example.mvvmretrofitdaggerkt.model.BookRepository
import com.example.mvvmretrofitdaggerkt.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DiModule {
    @Provides
    @Singleton
    fun provideBookApi(): BookApi {
        // Create Retrofit API object & return
        return BookApi.retrofit.create(BookApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBookRepository(api: BookApi): BookRepository {
        return BookRepository(api)
    }

    @Provides
    @Singleton
    fun provideViewModelFactory(bookRepository: BookRepository): ViewModelFactory {
        return ViewModelFactory(bookRepository)
    }

}
