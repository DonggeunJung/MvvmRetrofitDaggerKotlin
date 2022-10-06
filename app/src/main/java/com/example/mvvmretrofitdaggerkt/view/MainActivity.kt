package com.example.mvvmretrofitdaggerkt.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmretrofitdaggerkt.R
import com.example.mvvmretrofitdaggerkt.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private lateinit var rvAdapter: BookRvAdapter
    private val viewModel : BookViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init RecyclerView & adapter
        initList()
        observeLiveData()
        viewModel.reqBooks()
    }

    // Init RecyclerView & adapter
    private fun initList() {
        rvBook.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        rvBook.addItemDecoration(DividerItemDecoration(this, 1))
        // Init RecyclerView adapter
        rvAdapter = BookRvAdapter(this)
        rvBook.adapter = rvAdapter
    }

    private fun observeLiveData() {
        viewModel.booksLiveData.observe(this) {
            rvAdapter.setBooks(it)
        }
    }
}
