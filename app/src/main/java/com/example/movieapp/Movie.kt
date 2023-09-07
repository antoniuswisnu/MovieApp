package com.example.movieapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    var title: String,
    var description: String,
    var rating: String,
    var photo: Int,
    var release: String,
    var genre: String,
    var duration: String,
) : Parcelable