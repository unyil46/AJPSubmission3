package org.djafa.submission3.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.djafa.submission3.data.DataRepository
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.utils.DataDummy
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)

class MoviesViewModelTest {
    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<List<MoviesEntity>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateDummyMovies()
        val movies = MutableLiveData<List<MoviesEntity>>()
        movies.value = dummyMovies
        `when`(movieRepository.getAllMovies()).thenReturn(movies)
        val moviesEntities = viewModel.getMovies().value
        verify(movieRepository).getAllMovies()
        assertNotNull(moviesEntities)
        //assertEquals(11, moviesEntities?.size)
        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)

    }
}