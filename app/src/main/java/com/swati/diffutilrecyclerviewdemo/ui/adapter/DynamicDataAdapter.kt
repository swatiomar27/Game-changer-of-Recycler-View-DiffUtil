package com.swati.diffutilrecyclerviewdemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.swati.diffutilrecyclerviewdemo.R
import com.swati.diffutilrecyclerviewdemo.model.NewsDataModel
import com.swati.diffutilrecyclerviewdemo.ui.diffcallback.DynamicDiffCallback

class DynamicDataAdapter(private var dataList: ArrayList<NewsDataModel>) :
    RecyclerView.Adapter<DynamicDataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_home, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList[position]
        holder.titleTextView.text = dataModel.title
        holder.publishedAtTv.text = dataModel.publishedAt
    }

    fun updateList(dataList: List<NewsDataModel>) {
        val diffCallback = DynamicDiffCallback(this.dataList, dataList)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(diffCallback)
        this.dataList.clear()
        dataList.let { this.dataList.addAll(it) }
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var titleTextView: TextView = itemLayoutView.findViewById(R.id.tv_title)
        var publishedAtTv: TextView = itemLayoutView.findViewById(R.id.tv_published_at)
    }
}
