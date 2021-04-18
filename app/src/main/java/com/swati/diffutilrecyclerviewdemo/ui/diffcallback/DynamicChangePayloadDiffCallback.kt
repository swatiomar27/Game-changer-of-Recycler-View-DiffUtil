package com.swati.diffutilrecyclerviewdemo.ui.diffcallback

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.swati.diffutilrecyclerviewdemo.model.EmployeeDataClass


class DynamicChangePayloadDiffCallback(
    private val oldList: ArrayList<EmployeeDataClass>,
    private val newList: List<EmployeeDataClass>
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

        return oldEmployee.name == newEmployee.name && oldEmployee.role == newEmployee.role
    }

    @Nullable
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        val diff = Bundle()
        if (newItem.name != oldItem.name) {
            diff.putString("name", newItem.name)
        }
        if (newItem.role != oldItem.role) {
            diff.putString("role", newItem.role)
        }
        return if (diff.size() == 0) {
            null
        } else diff
    }
}
