package org.djafa.submission3.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.djafa.submission3.data.source.TvDataSource
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.data.source.remote.RemoteDataSourceTv
import org.djafa.submission3.data.source.remote.response.MovieResponse

class FakeTvRepository(private val remoteDataSourceTv: RemoteDataSourceTv) :
    TvDataSource {

    override fun getAllTv(): LiveData<List<MoviesEntity>> {
        val tvResults = MutableLiveData<List<MoviesEntity>>()
        remoteDataSourceTv.getAllTv(object : RemoteDataSourceTv.LoadTvCallback {
            override fun onAllTvReceived(movieResponses: List<MovieResponse>) {
                val tvList = ArrayList<MoviesEntity>()
                for (response in movieResponses) {
                    val movie = MoviesEntity(
                        response.movieId,
                        response.title,
                        response.overview,
                        response.poster_path,
                        response.voteAverage
                    )
                    tvList.add(movie)
                }
                tvResults.postValue(tvList)
            }
        })
        return tvResults
    }

    override fun getTv(movieId: String): LiveData<MoviesEntity> {
        val tvResult = MutableLiveData<MoviesEntity>()
        remoteDataSourceTv.getAllTv(object : RemoteDataSourceTv.LoadTvCallback {
            override fun onAllTvReceived(movieResponses: List<MovieResponse>) {
                lateinit var movie: MoviesEntity
                for (response in movieResponses) {
                    if (response.movieId == movieId) {
                        movie = MoviesEntity(
                            response.movieId,
                            response.title,
                            response.overview,
                            response.poster_path,
                            response.voteAverage
                        )
                    }
                }
                tvResult.postValue(movie)
            }
        })
        return tvResult
    }
}