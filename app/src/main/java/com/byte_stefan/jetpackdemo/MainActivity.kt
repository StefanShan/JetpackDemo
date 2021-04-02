package com.byte_stefan.jetpackdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.byte_stefan.jetpackdemo.viewModel.BaseActivity
import com.byte_stefan.jetpackdemo.viewModel.ViewModelManager

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelManager(this).getViewModel(MainViewModel::class.java)

        val textView = findViewById<TextView>(R.id.tv)

        textView.setOnClickListener {
            startActivity(Intent(this@MainActivity, BActivity::class.java))
        }

        viewModel?.list?.forEach {
            textView.append("$it \n")
        }
    }
}