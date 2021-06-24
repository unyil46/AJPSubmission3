package org.djafa.submission3.di

import android.content.Context
import org.djafa.submission3.data.DataRepository
import org.djafa.submission3.data.source.local.LocalDataSource
import org.djafa.submission3.data.source.local.room.MovieDatabase
import org.djafa.submission3.data.source.remote.RemoteDataSource
import org.djafa.submission3.utils.AppExecutors
import org.djafa.submission3.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): DataRepository {
        val database = MovieDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.MovieDao())
        val appExecutors = AppExecutors()
        return DataRepository.getInstance(remoteDataSource, localDataSource,appExecutors)
    }
   /* fun provideTvRepository(context: Context): TvRepository {
        val database = MovieDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.MovieDao())
        val appExecutors = AppExecutors()
        return TvRepository.getInstance(remoteDataSource, localDataSource,appExecutors)
    }*/
}