package com.example.recyclerviewmvvmtodagger.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmvvmtodagger.R
import com.example.recyclerviewmvvmtodagger.data.models.Movie
import com.example.recyclerviewmvvmtodagger.databinding.RecyclerviewMovieBinding

class MoviesAdapter (
    private val movies: List<Movie>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){

    inner class MoviesViewHolder(
        val recyclerviewMovieBinding: RecyclerviewMovieBinding
    ) : RecyclerView.ViewHolder(recyclerviewMovieBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_movie,
                parent,
                false
            )
        )

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recyclerviewMovieBinding.movie = movies[position]
        holder.recyclerviewMovieBinding.buttonBook.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewMovieBinding.buttonBook, movies[position])
        }
        holder.recyclerviewMovieBinding.layoutLike.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewMovieBinding.layoutLike, movies[position])
        }
    }
}