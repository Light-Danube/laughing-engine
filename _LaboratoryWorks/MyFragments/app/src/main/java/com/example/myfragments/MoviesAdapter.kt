package com.example.myfragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MoviesAdapter(
    private val movies: List<Movie>,
    private val onClick: (Movie) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)

        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            onClick(movie)
        }
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val titleTextView = itemView.findViewById<TextView>(R.id.title_text)
        private val descriptionTextView = itemView.findViewById<TextView>(R.id.description_text)
        private val imageView = itemView.findViewById<ImageView>(R.id.poster_image)

        fun bind(movie: Movie) {
            titleTextView.text = movie.title
            descriptionTextView.text = movie.description

            // Load the image using Glide
            Glide.with(itemView)
                .load(movie.posterUrl)
                .override(512, 512) // Set the desired width and height
                .fitCenter() // Fit the image within the specified dimensions
                .into(imageView)
        }

    }
}