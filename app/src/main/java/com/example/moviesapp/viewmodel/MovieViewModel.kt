package com.example.moviesapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.model.Movie
import com.example.moviesapp.network.ApiService
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {
    var movieListResponse:List<Movie> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getMovieList(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try{
                val movieList = apiService.getMovies()
                movieListResponse = movieList
            }
            catch (e:Exception){
                errorMessage = e.message.toString()
            }
        }
    }

}