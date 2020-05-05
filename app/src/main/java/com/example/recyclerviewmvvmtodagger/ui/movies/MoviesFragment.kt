package com.example.recyclerviewmvvmtodagger.ui.movies

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewmvvmtodagger.BaseApplication
import com.example.recyclerviewmvvmtodagger.R
import com.example.recyclerviewmvvmtodagger.data.models.Movie
import com.example.recyclerviewmvvmtodagger.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.movies_fragment.*
import javax.inject.Inject

class MoviesFragment : Fragment(R.layout.movies_fragment), RecyclerViewClickListener {

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

        viewModel.getMovies()

        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
                recycler_view_movies.also {
                    it.layoutManager = LinearLayoutManager(requireContext())
                    it.setHasFixedSize(true)
                    it.adapter = MoviesAdapter(movies, this)
                }
                Log.d(TAG, "Movies: " + movies)
            })
    }

    override fun onRecyclerViewItemClick(view: View, movie: Movie) {
        when(view.id){
            R.id.button_book -> {
                Toast.makeText(requireContext(), "Book Button Clicked",Toast.LENGTH_LONG).show()
            }
            R.id.layout_like ->{
                Toast.makeText(requireContext(), "Like Layout Clicked",Toast.LENGTH_LONG).show()
            }
        }
    }

}
