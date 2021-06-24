package org.djafa.submission3.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.databinding.ActivityDetailTvshowsBinding
import org.djafa.submission3.databinding.ContentDetailTvshowsBinding
import org.djafa.submission3.viewmodel.TvViewModelFactory
import org.djafa.submission3.vo.Status

class DetailTvshowsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailTvBinding: ContentDetailTvshowsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailTvBinding = ActivityDetailTvshowsBinding.inflate(layoutInflater)
        detailTvBinding = activityDetailTvBinding.detailContent
        setContentView(activityDetailTvBinding.root)
        setSupportActionBar(activityDetailTvBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val factory = TvViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(
            this, factory
        )[DetailTvshowsViewModel::class.java]
        val extras = intent.extras
        if (extras != null) {
            val tvId = extras.getString(EXTRA_MOVIE)
            if (tvId != null) {
                //viewModel.setFavorite(tvId)
                viewModel.selectedTv.observe(this, { tv ->
                    if (tv != null) {
                        when (tv.status) {
                            Status.LOADING -> activityDetailTvBinding.progressBar.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> if (tv.data != null) {
                                activityDetailTvBinding.progressBar.visibility = View.GONE
                                //cek favorite
                                activityDetailTvBinding.tv.visibility = View.VISIBLE
                                populateTv(tv.data)
                            }
                            Status.ERROR -> {
                                activityDetailTvBinding.progressBar.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }
        }

    }

    private fun populateTv(movieEntity: MoviesEntity) {
        detailTvBinding.textTitleTv.text = movieEntity.title
        detailTvBinding.textOverviewTv.text = movieEntity.overview
        detailTvBinding.textRateTv.text = movieEntity.voteAverage
        Glide.with(this)
            .load(movieEntity.posterPath)
            .transform(RoundedCorners(20))
            .into(detailTvBinding.imagePathTv)


    }
}