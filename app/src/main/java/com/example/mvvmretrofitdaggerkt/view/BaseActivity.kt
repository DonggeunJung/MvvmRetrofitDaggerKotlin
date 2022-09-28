package com.example.mvvmretrofitdaggerkt.view

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmretrofitdaggerkt.viewmodel.BookViewModel
import com.example.mvvmretrofitdaggerkt.viewmodel.ViewModelFactory

open class BaseActivity : AppCompatActivity() {
    protected val viewModel by this.viewModels <BookViewModel> { ViewModelFactory() }

}