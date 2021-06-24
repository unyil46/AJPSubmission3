package org.djafa.submission3.data

import android.util.Log
import androidx.lifecycle.LiveData
import org.djafa.submission3.data.source.local.LocalDataSource
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.data.source.remote.ApiResponse
import org.djafa.submission3.data.source.remote.RemoteDataSource
import org.djafa.submission3.data.source.remote.response.MovieResponse
import org.djafa.submission3.utils.AppExecutors
import org.djafa.submission3.vo.Resource

class DataRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : DataSource {

    companion object {
        @Volatile
        private var instance: DataRepository? = null
        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): DataRepository =
            instance ?: synchronized(this) {
                DataRepository(remoteData, localData, appExecutors).apply {
                    instance = this
                }
            }
    }

    override fun getAllMovies(): LiveData<Resource<List<MoviesEntity>>> {
        return object :
            NetworkBoundResource<List<MoviesEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MoviesEntity>> =
                localDataSource.getAllMovies()

            override fun shouldFetch(data: List<MoviesEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MoviesEntity>()
                for (response in data) {
                    val movie = MoviesEntity(
                        response.movieId!!,
                        response.title,
                        response.overview,
                        response.voteAverage,
                        response.posterPath,
                        false,
                        true
                    )
                    movieList.add(movie)
                }
                //Log.e("Movie DataRepo", "value: " + movieList.toString())
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTv(): LiveData<Resource<List<MoviesEntity>>> {
        return object :
            NetworkBoundResource<List<MoviesEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MoviesEntity>> =
                localDataSource.getAllTvs()

            override fun shouldFetch(data: List<MoviesEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllTv()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val tvList = ArrayList<MoviesEntity>()
                for (response in data) {
                    val movie = MoviesEntity(
                        response.movieId!!,
                        response.title,
                        response.overview,
                        response.voteAverage,
                        response.posterPath,
                        false,
                        false
                    )
                    tvList.add(movie)
                }
                localDataSource.insertMovies(tvList)
            }
        }.asLiveData()
    }

    override fun setFavorite(movie: MoviesEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavorite(movie, state)
        }
    }

    override fun getDetail(movieId: String): LiveData<Resource<MoviesEntity>> {
        return object : NetworkBoundResource<MoviesEntity, MovieResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MoviesEntity> =
                localDataSource.getMovie(movieId)

            override fun shouldFetch(data: MoviesEntity?): Boolean = data == null
            override fun createCall(): LiveData<ApiResponse<MovieResponse>> =
                remoteDataSource.getMovie(movieId)

            override fun saveCallResult(data: MovieResponse) {
                val movie = MoviesEntity(
                    data.movieId!!,
                    data.posterPath,
                    data.title,
                    data.overview,
                    data.voteAverage
                )
                Log.e("Data Repo", "value: " + movie.toString())
                localDataSource.updateMovie(movie)
            }
        }.asLiveData()
    }
}