package org.djafa.submission3.data

import androidx.lifecycle.LiveData
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.vo.Resource

interface DataSource {
    fun getAllMovies(): LiveData<Resource<List<MoviesEntity>>>
    fun getDetail(movieId: String): LiveData<Resource<MoviesEntity>>
    fun setFavorite(movie: MoviesEntity, state: Boolean)
    fun getAllTv(): LiveData<Resource<List<MoviesEntity>>>
    //fun getTv(movieId: String): LiveData<Resource<MoviesEntity>>
    //fun setFavoriteTV(movie: MoviesEntity, state: Boolean)
}