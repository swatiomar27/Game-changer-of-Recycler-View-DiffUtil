package com.swati.diffutilrecyclerviewdemo.ui.diffcallback

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.swati.diffutilrecyclerviewdemo.model.NewsDataModel

class DynamicDiffCallback(
    private val oldList: ArrayList<NewsDataModel>,
    private val newList: List<NewsDataModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = oldList[oldItemPosition]
        val newEmployee = newList[newItemPosition]

        return oldEmployee.title == newEmployee.title && oldEmployee.publishedAt == newEmployee.publishedAt
    }

    @Nullable
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}
