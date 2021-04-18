package com.swati.diffutilrecyclerviewdemo.ui.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swati.diffutilrecyclerviewdemo.R
import com.swati.diffutilrecyclerviewdemo.model.EmployeeDataClass
import com.swati.diffutilrecyclerviewdemo.ui.adapter.StaticDataAdapter

class StaticContentActivity : AppCompatActivity() {
    private var dataList = ArrayList<EmployeeDataClass>()
    private lateinit var recyclerView: RecyclerView
    private val recyclerAdapter by lazy {
        StaticDataAdapter(dataList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        init()
        setupRecyclerView()
        recyclerAdapter.updateList(getEmployeesList())
    }

    private fun getEmployeesList(): MutableList<EmployeeDataClass> {
        return ArrayList<EmployeeDataClass>().apply {
            add(EmployeeDataClass(1, getString(R.string.employee_a), getString(R.string.role_a)))
            add(EmployeeDataClass(2, getString(R.string.employee_b), getString(R.string.role_b)))
            add(EmployeeDataClass(3, getString(R.string.employee_c), getString(R.string.role_c)))
            add(EmployeeDataClass(4, getString(R.string.employee_d), getString(R.string.role_d)))
            add(EmployeeDataClass(5, getString(R.string.employee_e), getString(R.string.role_e)))
            add(EmployeeDataClass(6, getString(R.string.employee_f), getString(R.string.role_f)))
            add(EmployeeDataClass(7, getString(R.string.employee_g), getString(R.string.role_g)))
            add(EmployeeDataClass(8, getString(R.string.employee_h), getString(R.string.role_h)))
            add(EmployeeDataClass(9, getString(R.string.employee_i), getString(R.string.role_i)))
        }
    }

    private fun init() {
        recyclerView = findViewById(R.id.rv_items)
        val tvSortByName = findViewById<TextView>(R.id.tv_sort_title)
        val tvSortByRole = findViewById<TextView>(R.id.tv_sort_published_at)
        tvSortByName.text = getString(R.string.sort_by_name)
        tvSortByRole.text = getString(R.string.sort_by_role)

        findViewById<TextView>(R.id.tv_sort_title).setOnClickListener {
            sortByTitle()
        }

        findViewById<TextView>(R.id.tv_sort_published_at).setOnClickListener {
            sortByRole()
        }
    }

    private fun sortByRole() {
        val sortedWithName: List<EmployeeDataClass> =
            getEmployeesList().sortedWith(compareBy { employee -> employee.role })
        recyclerAdapter.updateList(sortedWithName)
    }

    private fun sortByTitle() {
        val sortedWithName: List<EmployeeDataClass> =
            getEmployeesList().sortedWith(compareBy { employee -> employee.name })
        recyclerAdapter.updateList(sortedWithName)
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter
        recyclerView.adapter?.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }
}