package org.djafa.submission3.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.djafa.submission3.data.DataRepository
import org.djafa.submission3.di.Injection
import org.djafa.submission3.ui.detail.DetailTvshowsViewModel
import org.djafa.submission3.ui.tvshows.TvShowsViewModel

class TvViewModelFactory private constructor(private val dataRepository: DataRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: TvViewModelFactory? = null

        fun getInstance(context: Context): TvViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: TvViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {

            modelClass.isAssignableFrom(TvShowsViewModel::class.java) -> {
                return TvShowsViewModel(dataRepository) as T
            }

            modelClass.isAssignableFrom(DetailTvshowsViewModel::class.java) -> {
                return DetailTvshowsViewModel(dataRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}