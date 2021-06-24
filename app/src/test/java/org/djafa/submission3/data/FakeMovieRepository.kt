package org.djafa.submission3.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.djafa.submission3.data.source.MovieDataSource
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.data.source.remote.RemoteDataSource
import org.djafa.submission3.data.source.remote.response.MovieResponse

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {
    override fun getAllMovies(): LiveData<List<MoviesEntity>> {
        val movieResults = MutableLiveData<List<MoviesEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
                val movieList = ArrayList<MoviesEntity>()
                for (response in movieResponses) {
                    val movie = MoviesEntity(
                        response.movieId,
                        response.title,
                        response.overview,
                        response.poster_path,
                        response.voteAverage,
                        )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getMovie(movieId: String): LiveData<MoviesEntity> {
        val movieResult = MutableLiveData<MoviesEntity>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
                lateinit var movie: MoviesEntity
                for (response in movieResponses) {
                    if (response.movieId == movieId) {
                        movie = MoviesEntity(
                            response.movieId,
                            response.title,
                            response.overview,
                            response.poster_path,
                            response.voteAverage,
                        )
                    }
                }
                movieResult.postValue(movie)
            }
        })
        return movieResult
    }
}