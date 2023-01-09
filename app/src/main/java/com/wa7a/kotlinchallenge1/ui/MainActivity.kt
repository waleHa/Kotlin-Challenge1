package com.wa7a.kotlinchallenge1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wa7a.kotlinchallenge1.R
import com.wa7a.kotlinchallenge1.data.Data
import com.wa7a.kotlinchallenge1.ui.adpters.MainAdapter
import com.wa7a.kotlinchallenge1.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //    private val TAG: String = "MainActivity Report"
    lateinit var viewModel: MainViewModel
    lateinit var mainAdapter: MainAdapter
    lateinit var recyclerView: RecyclerView

//    private val data = mutableListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setupRecyclerView(viewModel.medalsData)

    }

    private fun setupRecyclerView(data: List<Data>) {
        viewModel.getMedals()
        recyclerView = recycler_view_parent

        mainAdapter = MainAdapter(data)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity
            )
            adapter = mainAdapter

        }
    }
}