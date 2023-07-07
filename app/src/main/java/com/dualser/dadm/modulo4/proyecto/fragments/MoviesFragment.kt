package com.dualser.dadm.modulo4.proyecto.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dualser.dadm.R
import com.dualser.dadm.databinding.FragmentMoviesBinding
import com.dualser.dadm.modulo4.proyecto.adapters.MovieAdapter
import com.dualser.dadm.modulo4.proyecto.models.Movie

class MoviesFragment : Fragment(R.layout.fragment_movies) {

    private lateinit var binding : FragmentMoviesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMoviesBinding.bind(view)
        val movieAdapter = MovieAdapter(arrayListOf(
            Movie(title = "Movie 1", genre = "Action"),
            Movie(title = "Movie 2", genre = "Action"),
            Movie(title = "Movie 3", genre = "Action"),
            Movie(title = "Movie 4", genre = "Action"),
            Movie(title = "Movie 5", genre = "Action"),
            Movie(title = "Movie 6", genre = "Action"),
            Movie(title = "Movie 7", genre = "Action"),
            Movie(title = "Movie 8", genre = "Action"),
            Movie(title = "Movie 9", genre = "Action"),
            Movie(title = "Movie 10", genre = "Action"),
        ))

        binding.rvMovieList.adapter = movieAdapter
        binding.rvMovieList.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MoviesFragment()
    }
}