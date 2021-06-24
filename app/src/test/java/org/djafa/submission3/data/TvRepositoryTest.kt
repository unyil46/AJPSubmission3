package org.djafa.submission3.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import junit.framework.Assert.assertEquals
import org.djafa.submission3.data.source.remote.RemoteDataSourceTv
import org.djafa.submission3.utils.DataDummy
import org.djafa.submission3.utils.LiveDataTestUtil
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class TvRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val remote = Mockito.mock(RemoteDataSourceTv::class.java)
    private val tvRepository = FakeTvRepository(remote)
    private val tvResponses = DataDummy.generateRemoteDummyTvShows()
    private val tvId = tvResponses[0].movieId

    @Test
    fun getAllTv() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSourceTv.LoadTvCallback)
                .onAllTvReceived(tvResponses)
            null
        }.`when`(remote).getAllTv(any())
        val tvEntities = LiveDataTestUtil.getValue(tvRepository.getAllTv())
        com.nhaarman.mockitokotlin2.verify(remote).getAllTv(any())
        Assert.assertNotNull(tvEntities)
        assertEquals(tvResponses.size.toLong(), tvEntities.size.toLong())
    }

    @Test
    fun getMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSourceTv.LoadTvCallback)
                .onAllTvReceived(tvResponses)
            null
        }.`when`(remote).getAllTv(any())
        val tvEntities = LiveDataTestUtil.getValue(tvRepository.getTv(tvId!!))
        com.nhaarman.mockitokotlin2.verify(remote).getAllTv(any())
        Assert.assertNotNull(tvEntities)
        Assert.assertNotNull(tvEntities.title)
        Assert.assertNotNull(tvEntities.overview)
        Assert.assertNotNull(tvEntities.voteAverage)
        Assert.assertNotNull(tvEntities.poster_path)
        assertEquals(tvResponses[0].title, tvEntities.title)
        assertEquals(tvResponses[0].overview, tvEntities.overview)
        assertEquals(tvResponses[0].voteAverage, tvEntities.voteAverage)
    }
}