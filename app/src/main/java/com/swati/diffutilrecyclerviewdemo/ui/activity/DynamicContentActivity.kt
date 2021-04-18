package com.swati.diffutilrecyclerviewdemo.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swati.diffutilrecyclerviewdemo.R
import com.swati.diffutilrecyclerviewdemo.model.NewsDataModel
import com.swati.diffutilrecyclerviewdemo.ui.adapter.DynamicDataAdapter
import com.swati.recyclerviewrestorationpolicydemo.api.ApiClient
import com.swati.recyclerviewrestorationpolicydemo.model.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class DynamicContentActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private var dataList = ArrayList<NewsDataModel>()
    private lateinit var rvNews: RecyclerView
    private val recyclerAdapter by lazy {
        DynamicDataAdapter(dataList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        init()
        showProgressBar()
        setupRecyclerView()
        getData()
    }


    private fun init() {
        rvNews = findViewById(R.id.rv_items)
        progressBar = findViewById(R.id.progress_bar)
        val tvSortByName = findViewById<TextView>(R.id.tv_sort_title)
        val tvSortByRole = findViewById<TextView>(R.id.tv_sort_published_at)
        tvSortByName.text = getString(R.string.sort_by_title)
        tvSortByRole.text = getString(R.string.sort_by_publishedat)

        findViewById<TextView>(R.id.tv_sort_title).setOnClickListener {
            val sortedWithName: List<NewsDataModel> = dataList.sortedWith(compareBy { it.title })
            recyclerAdapter.updateList(sortedWithName)
        }
        findViewById<TextView>(R.id.tv_sort_published_at).setOnClickListener {
            val sortedWithName: List<NewsDataModel> = dataList.sortedWith(compareBy { it.publishedAt })
            recyclerAdapter.updateList(sortedWithName)
        }
    }

    private fun setupRecyclerView() {
        rvNews.layoutManager = LinearLayoutManager(this)
        rvNews.adapter = recyclerAdapter
        rvNews.adapter?.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    private fun getData() {
        val call: Call<DataModel> = ApiClient.getClient.getTopHeadlines()
        call.enqueue(object : Callback<DataModel> {

            override fun onResponse(
                call: Call<DataModel>?,
                response: Response<DataModel>?
            ) {
                hideProgressBar()
                response?.body()?.let {
                    recyclerAdapter.updateList(it.articles as List<NewsDataModel>)
                }
            }

            override fun onFailure(call: Call<DataModel>?, t: Throwable?) {
                hideProgressBar()
            }
        })
    }
}