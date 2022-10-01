package com.example.mvvmretrofitdaggerkt.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmretrofitdaggerkt.di.DaggerDiComponent
import com.example.mvvmretrofitdaggerkt.viewmodel.BookViewModel
import com.example.mvvmretrofitdaggerkt.viewmodel.ViewModelFactory
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    protected lateinit var viewModel : BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerDiComponent.builder().build().inject(this)
        viewModel = viewModelFactory.create(BookViewModel::class.java)
    }
}
