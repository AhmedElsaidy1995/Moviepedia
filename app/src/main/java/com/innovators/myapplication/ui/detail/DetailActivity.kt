package com.innovators.myapplication.ui.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.innovators.myapplication.BR
import com.innovators.myapplication.R
import com.innovators.myapplication.databinding.ActivityDetailBinding
import com.innovators.myapplication.model.cast.CastItem
import com.innovators.myapplication.model.result.ResultsItem
import com.innovators.myapplication.model.trailer.TrailerItem
import com.innovators.myapplication.ui.base.BaseActivity
import com.innovators.myapplication.ui.home.MovieAdapter
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_movie_item.view.*
import org.koin.android.viewmodel.ext.android.getViewModel

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {

    private lateinit var castAdapter: CastAdapter
    private lateinit var trailerAdapter: TrailerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.castLiveData.observe(this, androidx.lifecycle.Observer{
            setupCastAdapter(it)
        })

        viewModel.trailerLiveData.observe(this, androidx.lifecycle.Observer{
            setupTrailerAdapter(it)
        })


        movieInfo()
    }

    private fun setupTrailerAdapter(data: List<TrailerItem>) {
        trailerAdapter = TrailerAdapter(data){
            val intent = Intent(
                Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+it.key))
                    startActivity(intent)

        }

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL // set Horizontal Orientation
        trailerRecyclerView.adapter = trailerAdapter
        trailerRecyclerView.layoutManager = linearLayoutManager
    }

    private fun setupCastAdapter(data: List<CastItem>) {
        castAdapter = CastAdapter(data)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL // set Horizontal Orientation
        castRecyclerView.adapter = castAdapter
        castRecyclerView.layoutManager = linearLayoutManager




    }


    private fun movieInfo() {
        val gson = Gson()
        val strObj = intent.getStringExtra("obj")
        val obj = gson.fromJson(strObj, ResultsItem::class.java)
        dataBinding.movie = obj

        viewModel.getMoviesCast(obj.id.toString())
        viewModel.getMoviesTrailer(obj.id.toString())


    }

    override fun getMyViewModel(): DetailViewModel {
        return  getViewModel()
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
    return R.layout.activity_detail
    }
}