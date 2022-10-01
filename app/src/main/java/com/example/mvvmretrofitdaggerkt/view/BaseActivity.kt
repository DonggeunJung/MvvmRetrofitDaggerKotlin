package com.example.mvvmretrofitdaggerkt.view

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmretrofitdaggerkt.di.DaggerDiComponent
import com.example.mvvmretrofitdaggerkt.viewmodel.BookViewModel

open class BaseActivity : AppCompatActivity() {

    protected val viewModel: BookViewModel by viewModels {
        DaggerDiComponent.builder().build().viewModelFactory()
    }

}
