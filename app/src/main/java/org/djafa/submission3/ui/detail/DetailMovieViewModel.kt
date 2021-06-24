package org.djafa.submission3.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import org.djafa.submission3.data.DataRepository
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.vo.Resource

class DetailMovieViewModel(private val movieRepository: DataRepository) : ViewModel() {
    val movieId= MutableLiveData<String>()

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    var selectedMovie: LiveData<Resource<MoviesEntity>> = Transformations.switchMap(movieId) { mMovieId ->
       movieRepository.getDetail(mMovieId)
    }

   fun setFavorite() {
        val movieResource = selectedMovie.value
        if (movieResource != null) {
            val movieEntity = movieResource.data
            if (movieEntity != null) {
                val newState = !movieEntity.isFavorite
                movieRepository.setFavorite(movieEntity, newState)
            }
        }
    }
}