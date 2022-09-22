package com.cronocode.moviecatalog

import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cronocode.moviecatalog.models.Movie
import kotlinx.android.synthetic.main.activity_details.view.*
import kotlinx.android.synthetic.main.movie_item.view.*

class DetailsAdapter (
    private val movies : List<Movie>
    ): RecyclerView.Adapter<DetailsAdapter.MovieViewHolder>(){

        class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
            private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
            fun bindMovie(movie : Movie){
                itemView.detail_title.text = movie.title
                itemView.details_release.text = movie.release
                itemView.original_lang.text = movie.overview
                itemView.voteAverage.text = movie.average
                itemView.popularity.text= movie.popularity



                Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.imageView)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            return MovieViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
            )
        }

        override fun getItemCount(): Int = movies.size

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            holder.bindMovie(movies.get(position))
        }
}
