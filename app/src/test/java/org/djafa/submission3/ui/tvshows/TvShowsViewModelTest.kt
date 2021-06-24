package org.djafa.submission3.ui.tvshows

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
class TvShowsViewModelTest {
    private lateinit var viewModel: TvShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<List<MoviesEntity>>

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel(tvRepository)

    }

    @Test
    fun getTvShows() {
        val dummyTvs = DataDummy.generateDummyTvShows()
        val tvs = MutableLiveData<List<MoviesEntity>>()
        tvs.value = dummyTvs
        `when`(tvRepository.getAllTv()).thenReturn(tvs)
        val tvsEntities = viewModel.getTvSHows().value
        verify(tvRepository).getAllTv()
        assertNotNull(tvsEntities)
        //assertEquals(11, tvsEntities?.)
        viewModel.getTvSHows().observeForever(observer)
        verify(observer).onChanged(dummyTvs)
    }
}