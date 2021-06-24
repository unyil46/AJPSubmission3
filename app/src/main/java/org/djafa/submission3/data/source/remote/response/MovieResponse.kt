package org.djafa.submission3.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    var movieId: String? = null,
    var title: String? = null,
    var overview: String? = null,
    var voteAverage: String? = null,
    var posterPath: String? = null
) : Parcelable