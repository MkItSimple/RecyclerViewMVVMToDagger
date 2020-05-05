package com.example.recyclerviewmvvmtodagger.ui.movies

import android.view.View
import com.example.recyclerviewmvvmtodagger.data.models.Movie

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, movie: Movie)
}