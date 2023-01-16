package com.wa7a.kotlinchallenge1.ui.adpters

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wa7a.kotlinchallenge1.data.Data
import com.wa7a.kotlinchallenge1.data.Record


val TAG: String = "BindingAdapter"

@BindingAdapter("loadImageFromUrl")
fun ImageView.loadImageFromUrl(image: String?) {
    Log.d(TAG, image ?: "null2")
    this.load(image)
}


@BindingAdapter("setRecord")
fun RecyclerView.setRecords(records: List<Record>?) {
    if (records != null) {
        val recordAdapter = RecordAdapter()
        recordAdapter.setContentList(records.toMutableList())
        adapter = recordAdapter
    }
}

@BindingAdapter("setData")
fun RecyclerView.setData(data: List<Data>?) {
    if (data != null) {
        val dataAdapter = DataAdapter()
        dataAdapter.setContentList(data.toMutableList())
        adapter = dataAdapter
    }
}