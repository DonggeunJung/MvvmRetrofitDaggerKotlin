package com.example.mvvmretrofitdaggerkt.view

import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmretrofitdaggerkt.di.DaggerDiComponent

open class BaseActivity : AppCompatActivity() {

    protected val viewModelFactory = DaggerDiComponent.builder().build().viewModelFactory()

}
