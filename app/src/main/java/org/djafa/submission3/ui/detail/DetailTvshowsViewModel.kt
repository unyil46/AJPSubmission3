package org.djafa.submission3.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import org.djafa.submission3.data.DataRepository
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.vo.Resource

class DetailTvshowsViewModel(private val tvRepository: DataRepository) : ViewModel() {
    val tvId= MutableLiveData<String>()

    fun setSelectedMovie(tvId: String) {
        this.tvId.value = tvId
    }

    var selectedTv: LiveData<Resource<MoviesEntity>> = Transformations.switchMap(tvId) { mTvId ->
        tvRepository.getDetail(mTvId )
    }

    fun setFavorite() {
        val tvResource = selectedTv.value
        if (tvResource != null) {
            val tvEntity = tvResource.data
            if (tvEntity != null) {
                val newState = !tvEntity.isFavorite
                tvRepository.setFavorite(tvEntity, newState)
            }
        }
    }
}