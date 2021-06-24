package org.djafa.submission3.data.source

import androidx.lifecycle.LiveData
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.vo.Resource

interface MovieDataSource {
    fun getAllMovies(): LiveData<Resource<List<MoviesEntity>>>
    fun getMovie(movieId: String): LiveData<Resource<MoviesEntity>>
    fun setFavorite(movie: MoviesEntity, state: Boolean)

}