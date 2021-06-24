package org.djafa.submission3.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.djafa.submission3.data.DataRepository
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.vo.Resource

class TvShowsViewModel(private val tvRepository: DataRepository) : ViewModel() {
    fun getTvSHows(): LiveData<Resource<List<MoviesEntity>>> = tvRepository.getAllTv()
}