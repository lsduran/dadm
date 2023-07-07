package com.dualser.dadm.modulo4.proyecto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.dualser.dadm.R
import com.dualser.dadm.modulo4.proyecto.models.Movie
import com.squareup.picasso.Picasso

class MovieAdapter (private var moviesList : List<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {

    var onItemSelected : ((Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.render(moviesList[position], onItemSelected)
    }


}

class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    private val tvGenre = view.findViewById<TextView>(R.id.tvGenre)
    private val ivCover = view.findViewById<ImageView>(R.id.imgCover)
    private val root = view.findViewById<ConstraintLayout>(R.id.layoutMovie)


    fun render (movie : Movie, onItemSelected: ((Movie) -> Unit)?) {
        tvTitle.text = movie.title
        tvGenre.text = movie.genre
        root.setOnClickListener {
            onItemSelected?.invoke(movie)
        }

        Picasso.get().load(movie.imageUrl)
            .error(R.drawable.ic_movie_80)
            .placeholder(R.drawable.img_placeholder)
            .into(ivCover)
    }
}