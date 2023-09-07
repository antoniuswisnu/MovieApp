package com.example.movieapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMovies: RecyclerView
    private var list = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rv_movies)
        rvMovies.setHasFixedSize(true)

        list.addAll(getListMovies())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListMovies(): ArrayList<Movie> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataRating = resources.getStringArray(R.array.data_rating)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataRelease = resources.getStringArray(R.array.data_release)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val dataDuration = resources.getStringArray(R.array.data_duration)
        val listMovie = ArrayList<Movie>()
        for (position in dataTitle.indices) {
            val movie = Movie(
                dataTitle[position],
                dataDescription[position],
                dataRating[position],
                dataPhoto.getResourceId(position, -2),
                dataRelease[position],
                dataGenre[position],
                dataDuration[position]
            )
            listMovie.add(movie)
        }
        return listMovie
    }

    private fun showRecyclerList() {
        rvMovies.layoutManager = LinearLayoutManager(this)
        val listMovieAdapter = ListMovieAdapter(list)
        rvMovies.adapter = listMovieAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
             R.id.action_list -> {
                 rvMovies.layoutManager = LinearLayoutManager(this)
             }
            R.id.action_grid -> {
                rvMovies.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_about -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}