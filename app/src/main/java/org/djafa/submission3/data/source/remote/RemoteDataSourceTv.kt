package org.djafa.submission3.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.djafa.submission3.data.source.remote.response.MovieResponse
import org.djafa.submission3.utils.EspressoIdlingResource
import org.djafa.submission3.utils.JsonHelper

class RemoteDataSourceTv private constructor(private val jsonHelper: JsonHelper) {
 /*   private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSourceTv? = null

        fun getInstance(helper: JsonHelper): RemoteDataSourceTv =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSourceTv(helper).apply { instance = this }
            }
    }

    fun getAllTv():LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultTv = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed(
            {
                resultTv.value=ApiResponse.success(jsonHelper.loadTv())
                EspressoIdlingResource.decrement()
            },SERVICE_LATENCY_IN_MILLIS)
        return resultTv
    }

    interface LoadTvCallback {
        fun onAllTvReceived(movieResponses: List<MovieResponse>)

    }*/
}
