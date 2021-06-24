package org.djafa.submission3.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.djafa.submission3.R
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.databinding.ItemsMoviesBinding
import org.djafa.submission3.ui.detail.DetailMoviesActivity

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private var listMovies = ArrayList<MoviesEntity>()
    fun setMovies(movies: List<MoviesEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemsMoviesBinding =
            ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    class MoviesViewHolder(private val binding: ItemsMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MoviesEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemRate.text = movie.voteAverage
                tvItemOver.text = movie.overview?.take(100)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMoviesActivity::class.java)
                    intent.putExtra(DetailMoviesActivity.EXTRA_MOVIE, movie.movieId)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(movie.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_launcher_background)
                            .error(R.drawable.ic_launcher_foreground)
                    )
                    .into(imgPath)
            }
        }
    }
}