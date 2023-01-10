package com.wa7a.kotlinchallenge1.ui.adpters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wa7a.kotlinchallenge1.R
import com.wa7a.kotlinchallenge1.data.Record
import kotlinx.android.synthetic.main.item_medal.view.*

class MedalAdapter(var records: List<Record>) :
    RecyclerView.Adapter<MedalAdapter.MedalViewHolder>() {
    inner class MedalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_medal, parent, false)
        return MedalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return records.map { record -> record.active }.size
    }

    override fun onBindViewHolder(holder: MedalViewHolder, position: Int) {
        holder.itemView.apply {

            if (records[position].active) {
                Glide.with(this)
                    .load(records[position].image)
                    .into(image_view)

                record_title.text = records[position].title
                record_label.text = records[position].label
            }
        }
    }
}