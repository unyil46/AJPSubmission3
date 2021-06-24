package org.djafa.submission3.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import org.djafa.submission3.data.source.local.entity.MoviesEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movieentities WHERE isMovie = 1")
    fun getMovies(): LiveData<List<MoviesEntity>>

    @Query("SELECT * FROM movieentities WHERE isMovie = 0")
    fun getTvs(): LiveData<List<MoviesEntity>>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE isFavorite = 1")
    fun getFavoriteMovie(): LiveData<List<MoviesEntity>>


    @Query("SELECT * FROM movieentities WHERE isFavorite = 1 ")
    fun getFavoriteTv(): LiveData<List<MoviesEntity>>

    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getMovie(movieId: String): LiveData<MoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movies: List<MoviesEntity>)

    @Update
    fun updateMovie(movie: MoviesEntity)

}
