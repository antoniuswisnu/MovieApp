package com.example.movieapp

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val key_movie = "key_movie"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataMovie = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Movie>(key_movie, Movie::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Movie>(key_movie)
        }

        val tvTitle: TextView = findViewById(R.id.tv_title)
        val tvDescription: TextView = findViewById(R.id.tv_description)
        val tvRating: TextView = findViewById(R.id.tv_rating)
        val tvRelease: TextView = findViewById(R.id.tv_release_date)
        val tvGenre: TextView = findViewById(R.id.tv_genre)
        val tvDuration: TextView = findViewById(R.id.tv_duration)
        val imgPhoto: ImageView = findViewById(R.id.img_poster)
        val imgBack: ImageView = findViewById(R.id.img_back)

        tvTitle.text = dataMovie?.title
        tvDescription.text = dataMovie?.description
        tvRating.text = dataMovie?.rating
        tvRelease.text = dataMovie?.release
        tvGenre.text = dataMovie?.genre
        tvDuration.text = dataMovie?.duration
        imgPhoto.setImageResource(dataMovie?.photo!!)
        imgBack.setOnClickListener {
            onBackPressed()
        }

    }
}