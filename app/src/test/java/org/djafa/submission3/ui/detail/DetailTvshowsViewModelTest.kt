package org.djafa.submission3.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.djafa.submission3.data.DataRepository
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.utils.DataDummy
import org.junit.Assert.assertEquals
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

class DetailTvshowsViewModelTest {

    private lateinit var viewModel: DetailTvshowsViewModel
    private val dummyTv = DataDummy.generateDummyTvShows()[0]
    private val tvId: String = dummyTv.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvRepository: DataRepository

    @Mock
    private lateinit var tvObserver: Observer<MoviesEntity>

    @Before
    fun setUp() {
        viewModel = DetailTvshowsViewModel(tvRepository)
        viewModel.setSelectedMovie(tvId)
    }

    @Test
    fun setSelectedMovie() {
        viewModel = DetailTvshowsViewModel(tvRepository)
        viewModel.setSelectedMovie(tvId)
    }

    @Test
    fun getMovie() {
        val tv = MutableLiveData<MoviesEntity>()
        tv.value = dummyTv
        `when`(tvRepository.getTv(tvId)).thenReturn(tv)
        val tvsEntity = viewModel.selectedTv().value as MoviesEntity
        verify(tvRepository).getTv(tvId)
        assertNotNull(tvsEntity)
        assertEquals(dummyTv.movieId, tvsEntity.movieId)
        assertEquals(dummyTv.title, tvsEntity.title)
        assertEquals(dummyTv.voteAverage, tvsEntity.voteAverage)
        assertEquals(dummyTv.overview, tvsEntity.overview)
        viewModel.selectedTv().observeForever(tvObserver)
        verify(tvObserver).onChanged(dummyTv)
    }
}