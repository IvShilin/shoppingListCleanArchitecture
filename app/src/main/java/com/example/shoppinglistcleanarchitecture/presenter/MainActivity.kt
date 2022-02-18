package com.example.shoppinglistcleanarchitecture.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistcleanarchitecture.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ShopListAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.rv_shop_list)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        recyclerView.adapter = adapter

        viewModel.shoppingList.observe(this) {
            adapter.list = it
        }
    }


}