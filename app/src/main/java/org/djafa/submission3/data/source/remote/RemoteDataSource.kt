package org.djafa.submission3.data.source.remote

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.djafa.submission3.data.source.remote.response.MovieResponse
import org.djafa.submission3.utils.EspressoIdlingResource
import org.djafa.submission3.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
    private val handler = Handler(Looper.getMainLooper())
    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()

        handler.postDelayed(
            {
                resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
                EspressoIdlingResource.decrement()
            },SERVICE_LATENCY_IN_MILLIS)
       // Log.e("Movie Remote Data", "value "+ resultMovie.value)
        return resultMovie
    }
    fun getAllTv():LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultTv = MutableLiveData<ApiResponse<List<MovieResponse>>>()

        handler.postDelayed(
            {
                resultTv.value=ApiResponse.success(jsonHelper.loadTvs())
                EspressoIdlingResource.decrement()
            },SERVICE_LATENCY_IN_MILLIS)
        return resultTv
    }

    fun getMovie(movieId: String): MutableLiveData<ApiResponse<MovieResponse>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<MovieResponse>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovie(movieId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }


}