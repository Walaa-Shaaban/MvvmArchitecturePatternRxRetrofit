package com.walaa.shaaban.mvvmarchitecturepattern.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.walaa.shaaban.mvvmarchitecturepattern.R
import com.walaa.shaaban.mvvmarchitecturepattern.presentation.adapter.FlowerAdapter
import com.walaa.shaaban.mvvmarchitecturepattern.presentation.viewmodel.FlowerResponseViweMOdel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    lateinit var viewModel: FlowerResponseViweMOdel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recycler_flower.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProviders.of(this).get(FlowerResponseViweMOdel::class.java)
        viewModel.getAllFlower.observe(this, Observer {
            recycler_flower.adapter = FlowerAdapter(this, it)
        })


    }
}
