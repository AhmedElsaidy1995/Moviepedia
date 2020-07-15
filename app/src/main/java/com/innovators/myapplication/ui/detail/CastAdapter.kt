package com.innovators.myapplication.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.innovators.myapplication.R
import com.innovators.myapplication.model.cast.CastItem
import com.innovators.myapplication.model.result.ResultsItem
import kotlinx.android.synthetic.main.layout_cast_item.view.*
import kotlinx.android.synthetic.main.layout_movie_item.view.*

class CastAdapter(var data: List<CastItem>) : RecyclerView.Adapter<CastAdapter.CastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        return CastViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_cast_item, parent, false)
        )
    }

    override fun getItemCount() = data.size

    fun swapData(newData :List<CastItem>){
        data = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) =
        holder.bind(data[position])


    class CastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: CastItem) = with(itemView) {

            Glide.with(itemView).load("https://image.tmdb.org/t/p/w600_and_h600_bestv2"+item.profilePath).placeholder(R.color.colorAccent)
                .error(R.color.colorPrimary)
                .into(castImageView)

            castTextView.text = item.name

        }
    }
}