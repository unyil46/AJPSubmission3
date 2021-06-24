package org.djafa.submission3.utils

import android.content.Context
import android.util.Log
import org.djafa.submission3.data.source.remote.response.MovieResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponse.json").toString())
            val listArray = responseObject.getJSONArray("results")

            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)
                val id = movie.getString("id")
                val title = movie.getString("title")
                val overview = movie.getString("overview")
                val posterPath = "https://image.tmdb.org/t/p/w500" + movie.getString("poster_path")
                val vote = movie.getString("vote_average")
                val movieResponse = MovieResponse(id, title, overview, vote, posterPath)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvs(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvshowResponse.json").toString())
            val listArray = responseObject.getJSONArray("results")
           // Log.e("Movie jSonHelper", listArray.toString())
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)
                val id = movie.getString("id")
                val title = movie.getString("title")
                val overview = movie.getString("overview")
                val posterPath = "https://image.tmdb.org/t/p/w500" + movie.getString("poster_path")
                val vote = movie.getString("vote_average")
                val movieResponse = MovieResponse(id, title, overview, vote, posterPath)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        //Log.e("Movie jSonHelper", list.toString())
        return list
    }

    fun loadMovie (movieId: String): MovieResponse {
        var dataResponse:MovieResponse?=null
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponse.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)
                if (movieId == movie.getString("id")) {
                    val id = movie.getString("id")
                    val title = movie.getString("title")
                    val overview = movie.getString("overview")
                    val posterPath =
                        "https://image.tmdb.org/t/p/w500" + movie.getString("poster_path")
                    val vote = movie.getString("voteAverage")
                    dataResponse = MovieResponse(id, title, overview, vote, posterPath)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return dataResponse as MovieResponse
    }
    fun loadTv (movieId: String): MovieResponse {
        var dataResponse:MovieResponse?=null
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponse.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)
                if (movieId == movie.getString("id")) {
                    val id = movie.getString("id")
                    val title = movie.getString("title")
                    val overview = movie.getString("overview")
                    val posterPath =
                        "https://image.tmdb.org/t/p/w500" + movie.getString("poster_path")
                    val vote = movie.getString("voteAverage")
                    dataResponse = MovieResponse(id, title, overview, vote, posterPath)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return dataResponse as MovieResponse
    }

}


