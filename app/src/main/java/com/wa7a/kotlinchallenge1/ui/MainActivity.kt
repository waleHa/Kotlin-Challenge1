package com.wa7a.kotlinchallenge1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.wa7a.kotlinchallenge1.data.Data
import com.wa7a.kotlinchallenge1.data.Medal
import com.wa7a.kotlinchallenge1.ui.adpters.DataAdapter
import com.wa7a.kotlinchallenge1.ui.viewmodel.MainViewModel
import com.wa7a.kotlinchallenge1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity Report"
    lateinit var viewModel: MainViewModel
    lateinit var mainAdapter: DataAdapter
    lateinit var recyclerView: RecyclerView

//    private val dataX = Medal()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO:CHANGE
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getMedals()

        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        recyclerView = binding.recyclerViewParent
        mainAdapter = DataAdapter()
        recyclerView.adapter = mainAdapter

        viewModel.medalsData.observe(this, Observer { medal ->
            binding.medal = medal
        })
    }
}
