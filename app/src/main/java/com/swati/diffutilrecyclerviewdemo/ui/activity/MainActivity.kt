package com.swati.diffutilrecyclerviewdemo.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.swati.diffutilrecyclerviewdemo.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tv_static_content).setOnClickListener {
            val intent = Intent(this, StaticContentActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.tv_dynamic_content).setOnClickListener {
            val intent = Intent(this, DynamicContentActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.tv_dynamic_content_with_change_payload).setOnClickListener {
            val intent = Intent(this, DynamicContentChangePayload::class.java)
            startActivity(intent)
        }
    }
}