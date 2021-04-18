package com.swati.diffutilrecyclerviewdemo.ui.activity

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swati.diffutilrecyclerviewdemo.R
import com.swati.diffutilrecyclerviewdemo.model.EmployeeDataClass
import com.swati.diffutilrecyclerviewdemo.ui.adapter.DynamicChangePayloadDataAdapter

class DynamicContentChangePayload : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private var dataList = ArrayList<EmployeeDataClass>()
    private lateinit var rvNews: RecyclerView
    private val recyclerAdapter by lazy {
        DynamicChangePayloadDataAdapter(dataList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        init()
        setupRecyclerView()
        recyclerAdapter.updateList(getEmployees())
    }

    private fun getEmployees(): MutableList<EmployeeDataClass> {
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
        rvNews = findViewById(R.id.rv_items)
        progressBar = findViewById(R.id.progress_bar)
        val tvSortByName = findViewById<TextView>(R.id.tv_sort_title)
        val tvSortByRole = findViewById<TextView>(R.id.tv_sort_published_at)
        tvSortByName.text = getString(R.string.sort_by_name)
        tvSortByRole.text = getString(R.string.sort_by_role)

        findViewById<TextView>(R.id.tv_sort_title).setOnClickListener {
            recyclerAdapter.updateList(getEmployeesDifferValues())

        }
        findViewById<TextView>(R.id.tv_sort_published_at).setOnClickListener {
            recyclerAdapter.updateList(getEmployees())
        }
    }

    private fun getEmployeesDifferValues(): List<EmployeeDataClass> {
        return ArrayList<EmployeeDataClass>().apply {
            add(EmployeeDataClass(1, getString(R.string.employee_j), getString(R.string.role_a)))
            add(EmployeeDataClass(2, getString(R.string.employee_b), getString(R.string.role_b)))
            add(EmployeeDataClass(3, getString(R.string.employee_c), getString(R.string.role_c)))
            add(EmployeeDataClass(4, getString(R.string.employee_d), getString(R.string.role_d)))
            add(EmployeeDataClass(5, getString(R.string.employee_k), getString(R.string.role_e)))
            add(EmployeeDataClass(6, getString(R.string.employee_f), getString(R.string.role_f)))
            add(EmployeeDataClass(7, getString(R.string.employee_g), getString(R.string.role_g)))
            add(EmployeeDataClass(8, getString(R.string.employee_h), getString(R.string.role_h)))
            add(EmployeeDataClass(9, getString(R.string.employee_l), getString(R.string.role_i)))
        }
    }

    private fun setupRecyclerView() {
        rvNews.layoutManager = LinearLayoutManager(this)
        rvNews.adapter = recyclerAdapter
        rvNews.adapter?.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }
}