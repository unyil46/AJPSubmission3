package org.djafa.submission3.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.databinding.ActivityDetailMoviesBinding
import org.djafa.submission3.databinding.ContentDetailMoviesBinding
import org.djafa.submission3.viewmodel.ViewModelFactory
import org.djafa.submission3.vo.Status

class DetailMoviesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailMovieBinding: ContentDetailMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        detailMovieBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]
        val extras = intent.extras

        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)

            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                viewModel.selectedMovie.observe(this, { movie ->
                    Log.e("DetailMovieAct", "value: " + movie.toString())
                    if (movie != null) {
                        when (movie.status) {
                            Status.LOADING -> activityDetailMovieBinding.progressBar.visibility =  View.VISIBLE
                            Status.SUCCESS -> if (movie.data != null) {
                                activityDetailMovieBinding.progressBar.visibility = View.GONE
                                //cek favorite
                                activityDetailMovieBinding.movie.visibility = View.VISIBLE

                                populateMovie(movie.data)
                            }
                            Status.ERROR -> {
                                activityDetailMovieBinding.progressBar.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }
        }

    }

    private fun populateMovie(movieEntity: MoviesEntity) {
        detailMovieBinding.textTitleMv.text = movieEntity.title
        detailMovieBinding.textRateMv.text = movieEntity.voteAverage
        detailMovieBinding.textOverviewMv.text = movieEntity.overview

        Glide.with(this)
            .load(movieEntity.posterPath)
            .transform(RoundedCorners(20))
            .into(detailMovieBinding.imagePathMv)
    }
}