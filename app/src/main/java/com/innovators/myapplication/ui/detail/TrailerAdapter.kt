package com.innovators.myapplication.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.innovators.myapplication.R
import com.innovators.myapplication.model.result.ResultsItem
import com.innovators.myapplication.model.trailer.TrailerItem
import kotlinx.android.synthetic.main.layout_movie_item.view.*
import kotlinx.android.synthetic.main.layout_trailer_item.view.*

class TrailerAdapter(var data: List<TrailerItem>,var itemClick: (TrailerItem) -> Unit) : RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerViewHolder {
        return TrailerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_trailer_item, parent, false),itemClick
        )
    }

    override fun getItemCount() = data.size

    fun swapData(newData: List<TrailerItem>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TrailerViewHolder, position: Int) =
        holder.bind(data[position])


    class TrailerViewHolder(itemView: View,var itemClick: (TrailerItem) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: TrailerItem) = with(itemView) {


            Glide.with(itemView).load("https://img.youtube.com/vi/"+item.key+"/0.jpg").placeholder(R.color.colorAccent)
                .error(R.color.colorPrimary)
                .into(trailerImageView)

            setOnClickListener {
                itemClick(item)
            }

            trailerTextView.text = item.name


        }
    }
}