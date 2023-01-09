package com.wa7a.kotlinchallenge1.ui.adpters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wa7a.kotlinchallenge1.R
import com.wa7a.kotlinchallenge1.data.Data
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter(var data: List<Data>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentData = data[position]
        holder.apply {
            titleTextView.text = currentData.title
            labelTextView.text = currentData.label
            val childLayoutManager =
                GridLayoutManager(childRecyclerView.context,2)
            childLayoutManager.initialPrefetchItemCount = currentData.records.size
            childRecyclerView.apply {
                layoutManager = childLayoutManager
                adapter = MedalAdapter(currentData.records)
//                setRecycledViewPool(RecyclerView.RecycledViewPool())
            }

        }
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val childRecyclerView : RecyclerView = itemView.recycler_view_child
        val titleTextView: TextView = itemView.text_view_title
        val labelTextView: TextView = itemView.text_view_label
    }


}
