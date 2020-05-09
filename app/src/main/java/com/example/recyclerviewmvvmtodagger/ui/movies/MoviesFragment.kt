package com.example.recyclerviewmvvmtodagger.ui.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.recyclerviewmvvmtodagger.BaseApplication
import com.example.recyclerviewmvvmtodagger.R
import com.example.recyclerviewmvvmtodagger.data.models.Movie
import com.example.recyclerviewmvvmtodagger.viewmodel.ViewModelFactory
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.movies_fragment.*
import kotlinx.android.synthetic.main.recyclerview_movie.view.*
import javax.inject.Inject

// RecyclerViewClickListener
class MoviesFragment : Fragment(R.layout.movies_fragment) {

    companion object {
        val TAG = "MoviesFragment"
        fun newInstance() = MoviesFragment()
    }

    private lateinit var viewModel: MoviesViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        ( activity?.applicationContext as BaseApplication).appComponent
            .newMoviesFragmentComponent().inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MoviesViewModel::class.java)

        val adapter = GroupAdapter<ViewHolder>()

        // Get and Put Movies on RecyclerView
        viewModel.getMovies()

        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->

            for (movie in movies!!){
                adapter.add(MovieItem(movie))
            }

            adapter.setOnItemClickListener { item, view ->
                val movieItem = item as MovieItem
                val mId = movieItem.movie.id
                val mTitle = movieItem.movie.title
                val mImage = movieItem.movie.image
                 Log.d(TAG, "Item id: ${mId.toInt()}")
            }

            recycler_view_movies.adapter = adapter
            Log.d(TAG, "List of movies: " + movies)
        })
    }
}

class MovieItem(val movie: Movie): Item<ViewHolder>() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.textViewTitle.text = movie.title
        viewHolder.itemView.textViewLanguage.text = movie.language

        // Glide with Groupie https://stackoverflow.com/questions/55202976/what-to-input-into-the-glides-with-when-using-together-with-groupie
        Glide.with(viewHolder.root.context).load(movie.image).into(viewHolder.itemView.imageView)
    }

    override fun getLayout(): Int {
        return R.layout.recyclerview_movie
    }
}
