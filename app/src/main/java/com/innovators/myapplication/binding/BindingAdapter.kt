package com.innovators.myapplication.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.innovators.myapplication.R

@BindingAdapter("poster")
fun loadPoster(view: ImageView, imageUrl: String?) {
    Glide.with(view.getContext())
        .load("https://image.tmdb.org/t/p/w600_and_h900_bestv2"+imageUrl).placeholder(R.color.colorAccent)
        .error(R.color.colorPrimary)
            .into(view)
}

@BindingAdapter("cover")
fun loadCOverPoster(view: ImageView, imageUrl: String?) {
    Glide.with(view.getContext())
        .load("https://image.tmdb.org/t/p/w1280_and_h720_bestv2"+imageUrl).placeholder(R.color.colorAccent)
        .error(R.color.colorPrimary)
        .into(view)
}

