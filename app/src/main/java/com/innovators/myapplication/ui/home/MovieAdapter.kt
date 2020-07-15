package com.innovators.myapplication.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.innovators.myapplication.R
import com.innovators.myapplication.model.result.ResultsItem
import kotlinx.android.synthetic.main.layout_movie_item.view.*

class MovieAdapter(var data: List<ResultsItem>, var itemClick: (ResultsItem) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_movie_item, parent, false),itemClick
        )
    }

    override fun getItemCount() = data.size

    fun swapData(newData :List<ResultsItem>){
        data = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(data[position])


    class MovieViewHolder(itemView: View,var itemClick: (ResultsItem) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ResultsItem) = with(itemView) {



            Glide.with(itemView).load("https://image.tmdb.org/t/p/w600_and_h900_bestv2"+item.posterPath).placeholder(R.color.colorAccent)
                .error(R.color.colorPrimary)
                .into(movieImageView)

            setOnClickListener {
                itemClick(item)
            }

            movieTextView.text = item.title


        }
    }
}