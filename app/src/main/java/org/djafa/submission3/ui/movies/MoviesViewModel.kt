package org.djafa.submission3.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.djafa.submission3.data.DataRepository
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.vo.Resource

class MoviesViewModel(private val movieRepository: DataRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<List<MoviesEntity>>> = movieRepository.getAllMovies()

}

