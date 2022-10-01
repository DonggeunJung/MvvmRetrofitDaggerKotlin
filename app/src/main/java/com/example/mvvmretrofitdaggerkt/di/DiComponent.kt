package com.example.mvvmretrofitdaggerkt.di

import com.example.mvvmretrofitdaggerkt.model.BookRepository
import com.example.mvvmretrofitdaggerkt.view.BaseActivity
import com.example.mvvmretrofitdaggerkt.viewmodel.BookViewModel
import com.example.mvvmretrofitdaggerkt.viewmodel.ViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DiModule::class])
interface DiComponent {
    fun provideBookRepository(): BookRepository
    fun provideViewModelFactory(): ViewModelFactory

    fun inject(bookViewModel: BookViewModel)
    fun inject(baseActivity: BaseActivity)
}
