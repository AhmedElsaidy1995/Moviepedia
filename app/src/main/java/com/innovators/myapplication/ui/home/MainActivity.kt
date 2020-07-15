package com.innovators.myapplication.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.innovators.myapplication.R
import com.innovators.myapplication.model.result.ResultsItem
import com.innovators.myapplication.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.popualarMoviesLiveData.observe(this, androidx.lifecycle.Observer{
            setupAdapter(it)
        })




    }
    private fun setupAdapter(data: List<ResultsItem>) {
        movieAdapter = MovieAdapter(data){

            val intent = Intent(this,DetailActivity::class.java)
            val gson = Gson()
            intent.putExtra("obj", gson.toJson(it))
            startActivity(intent)


        }
        val gridLayoutManager = GridLayoutManager(this, 3)
        gridLayoutManager.orientation = LinearLayoutManager.VERTICAL // set Horizontal Orientation
        moviesRecyclerView.adapter = movieAdapter
        moviesRecyclerView.layoutManager = gridLayoutManager

    }


}