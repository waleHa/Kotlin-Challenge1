package com.wa7a.kotlinchallenge1.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wa7a.kotlinchallenge1.R
import com.wa7a.kotlinchallenge1.data.Data
import com.wa7a.kotlinchallenge1.ui.adpters.MainAdapter
import com.wa7a.kotlinchallenge1.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

        private val TAG: String = "MainActivity Report"
    lateinit var viewModel: MainViewModel
    lateinit var mainAdapter: MainAdapter
    lateinit var recyclerView: RecyclerView

    private val dataX = mutableListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getMedals()

        viewModel.medalsData.observe(this, Observer { data ->
            dataX.addAll(data)
            mainAdapter.notifyDataSetChanged()
        })

        setupRecyclerView(dataX)
    }

    private fun setupRecyclerView(data: List<Data>) {
        recyclerView = recycler_view_parent

        mainAdapter = MainAdapter(data)
        recyclerView.apply {

            adapter = mainAdapter

        }
    }
}