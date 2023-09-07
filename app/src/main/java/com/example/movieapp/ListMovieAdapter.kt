package com.example.movieapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListMovieAdapter(private val listMovie: ArrayList<Movie>) : RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_movie, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movie = listMovie[position]
        Glide.with(holder.itemView.context)
            .load(movie.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvTitle.text = movie.title
        holder.tvDescription.text = movie.description
        holder.tvRating.text = movie.rating
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_movie", listMovie[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listMovie[holder.adapterPosition].title, Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        var tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        var imgPhoto: ImageView = itemView.findViewById(R.id.imgPhoto)
        var tvRating: TextView = itemView.findViewById(R.id.tvRating)
    }


}