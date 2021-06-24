package org.djafa.submission3.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import junit.framework.Assert.assertEquals
import org.djafa.submission3.data.source.remote.RemoteDataSource
import org.djafa.submission3.utils.DataDummy
import org.djafa.submission3.utils.LiveDataTestUtil
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)
    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].movieId

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getAllMovies())
        com.nhaarman.mockitokotlin2.verify(remote).getAllMovies(any())
        Assert.assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getMovie(movieId!!))
        com.nhaarman.mockitokotlin2.verify(remote).getAllMovies(any())
        Assert.assertNotNull(movieEntities)
        Assert.assertNotNull(movieEntities.title)
        Assert.assertNotNull(movieEntities.overview)
        Assert.assertNotNull(movieEntities.voteAverage)
        Assert.assertNotNull(movieEntities.poster_path)
        assertEquals(movieResponses[0].title, movieEntities.title)
        assertEquals(movieResponses[0].overview, movieEntities.overview)
        assertEquals(movieResponses[0].voteAverage, movieEntities.voteAverage)
    }
}