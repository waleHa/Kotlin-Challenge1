package com.wa7a.kotlinchallenge1.ui.adpters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wa7a.kotlinchallenge1.data.Data
import com.wa7a.kotlinchallenge1.data.Record
import com.wa7a.kotlinchallenge1.databinding.ItemRecordBinding

class RecordAdapter() :
    RecyclerView.Adapter<RecordAdapter.MedalViewHolder>() {

    private var records = mutableListOf <Record>()

    fun setContentList(record:MutableList<Record>){
        this.records = record
        notifyDataSetChanged()
    }

    inner class MedalViewHolder(val binding: ItemRecordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Record) {
            binding.record = item
//            binding.imageView.loadImageFromUrl(item.image_id)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedalViewHolder {
        val view = LayoutInflater.from(parent.context)
        val listItemBinding = ItemRecordBinding.inflate(view, parent, false)
        return MedalViewHolder(listItemBinding)
    }


    override fun getItemCount(): Int {
        return records.map { record -> record.active }.size
    }

    override fun onBindViewHolder(holder: MedalViewHolder, position: Int) {
//                val currentRecord = records[position]
        holder.bind(records[position])
    }
}