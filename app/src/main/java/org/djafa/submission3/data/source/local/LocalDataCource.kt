package org.djafa.submission3.data.source.local

import androidx.lifecycle.LiveData
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.data.source.local.room.MovieDao

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {
    fun getAllMovies(): LiveData<List<MoviesEntity>> = mMovieDao.getMovies()
    fun getAllTvs(): LiveData<List<MoviesEntity>> = mMovieDao.getTvs()
    fun getMovie(movieId: String): LiveData<MoviesEntity> = mMovieDao.getMovie(movieId)
    fun getFavoriteMovie(): LiveData<List<MoviesEntity>> = mMovieDao.getFavoriteMovie()
    fun getFavoriteTv(): LiveData<List<MoviesEntity>> = mMovieDao.getFavoriteTv()

    fun insertMovies(movies: List<MoviesEntity>) = mMovieDao.insertMovie(movies)

    fun setFavorite(movie: MoviesEntity, newState: Boolean) {
        movie.isFavorite = newState
        mMovieDao.updateMovie(movie)
    }

    fun updateMovie(movie: MoviesEntity) = mMovieDao.updateMovie(movie)

    fun updateTv(tv: MoviesEntity) = mMovieDao.updateMovie(tv)

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }
}