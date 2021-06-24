package org.djafa.submission3.data.source

import androidx.lifecycle.LiveData
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.vo.Resource

interface TvDataSource {
    fun getAllTv(): LiveData<Resource<List<MoviesEntity>>>
    fun getTv(movieId: String): LiveData<Resource<MoviesEntity>>
    fun setFavoriteTV(movie: MoviesEntity, state: Boolean)

}