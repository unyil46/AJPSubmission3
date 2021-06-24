package org.djafa.submission3.ui.movies
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.djafa.submission3.databinding.FragmentMoviesBinding
import org.djafa.submission3.viewmodel.ViewModelFactory
import org.djafa.submission3.vo.Status
class MoviesFragment : Fragment() {
    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding
    private val binding get() = fragmentMoviesBinding
    override fun onCreateView(        inflater: LayoutInflater,        container: ViewGroup?,        savedInstanceState: Bundle?    ): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]
            val moviesAdapter = MoviesAdapter()
            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            moviesAdapter.setMovies(movies.data)
                            moviesAdapter.notifyDataSetChanged()
                           // Log.e("Movie Fragment", "value: " + movies.data.toString())
                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(binding.rvMovies) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = moviesAdapter
            }
        }
    }
}