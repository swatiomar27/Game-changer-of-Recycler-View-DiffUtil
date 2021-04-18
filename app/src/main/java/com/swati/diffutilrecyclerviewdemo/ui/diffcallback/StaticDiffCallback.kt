package com.swati.diffutilrecyclerviewdemo.ui.diffcallback

import androidx.recyclerview.widget.DiffUtil
import com.swati.diffutilrecyclerviewdemo.model.EmployeeDataClass

class StaticDiffCallback(
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
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee: EmployeeDataClass = oldList[oldItemPosition]
        val newEmployee: EmployeeDataClass = newList[newItemPosition]

        return oldEmployee.name == newEmployee.name && oldEmployee.role == newEmployee.role
    }
}
