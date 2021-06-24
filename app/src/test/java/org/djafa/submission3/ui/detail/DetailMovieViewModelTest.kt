package org.djafa.submission3.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.djafa.submission3.data.DataRepository
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.utils.DataDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId: String = dummyMovie.movieId.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: DataRepository

    @Mock
    private lateinit var movieObserver: Observer<MoviesEntity>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(movieRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun setSelectedMovie() {
        viewModel = DetailMovieViewModel(movieRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MoviesEntity>()
        movie.value = dummyMovie
        `when`(movieRepository.getMovie(movieId)).thenReturn(movie)
        val moviesEntity = viewModel.selectedMovie().value as MoviesEntity
        verify(movieRepository).getMovie(movieId)
        assertNotNull(moviesEntity)
        assertEquals(dummyMovie.movieId, moviesEntity.movieId)
        assertEquals(dummyMovie.title, moviesEntity.title)
        assertEquals(dummyMovie.voteAverage, moviesEntity.voteAverage)
        assertEquals(dummyMovie.overview, moviesEntity.overview)
        viewModel.selectedMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }
}