package com.wa7a.kotlinchallenge1.ui.adpters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wa7a.kotlinchallenge1.data.Data
import com.wa7a.kotlinchallenge1.databinding.ItemDataBinding

class DataAdapter() :
    RecyclerView.Adapter<DataAdapter.MainViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()
    private var data = mutableListOf <Data>()
    lateinit var recyclerView: RecyclerView
    lateinit var medalAdapter: RecordAdapter

    fun setContentList(data:MutableList<Data>){
        this.data = data
        notifyDataSetChanged()
    }

    inner class MainViewHolder(val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Data) {
            binding.data = item

//            binding.data?.records = item.records
//            recyclerView = binding.recyclerViewChild
//            medalAdapter = MedalAdapter(item.records)
//            recyclerView.adapter = medalAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
        val listItemBinding = ItemDataBinding.inflate(view, parent, false)
        return MainViewHolder(listItemBinding)
    }

    override fun getItemCount(): Int {
        return this.data.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentData = this.data[position]
        holder.bind(currentData)
    }
}