package org.djafa.submission3.ui.tvshows

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.djafa.submission3.databinding.FragmentTvShowsBinding
import org.djafa.submission3.ui.movies.MoviesAdapter
import org.djafa.submission3.viewmodel.TvViewModelFactory
import org.djafa.submission3.vo.Status

class TvShowsFragment : Fragment() {
    private lateinit var fragmentTvBinding: FragmentTvShowsBinding
    private val binding get() = fragmentTvBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return fragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = TvViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowsViewModel::class.java]
            val tvsAdapter = TvShowsAdapter()
            viewModel.getTvSHows().observe(viewLifecycleOwner, { tvs ->
                if (tvs != null) {
                    when (tvs.status) {
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            tvsAdapter.setMovies(tvs.data)
                            tvsAdapter.notifyDataSetChanged()
                           // Log.e("TvShows Fragment", "value: " + tvs.data.toString())
                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(binding.rvTvshows) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = tvsAdapter
            }
        }
    }
}