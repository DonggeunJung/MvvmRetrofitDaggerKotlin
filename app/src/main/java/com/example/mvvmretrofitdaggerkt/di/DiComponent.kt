package com.example.mvvmretrofitdaggerkt.di

import com.example.mvvmretrofitdaggerkt.model.BookApi
import com.example.mvvmretrofitdaggerkt.model.BookRepository
import com.example.mvvmretrofitdaggerkt.viewmodel.BookViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DiModule::class])
interface DiComponent {
    fun provideBookApi(): BookApi
    fun provideBookRepository(): BookRepository

    fun inject(repository: BookRepository)
    fun inject(bookViewModel: BookViewModel)
}