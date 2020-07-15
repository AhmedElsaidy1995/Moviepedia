package com.innovators.myapplication.repository

import com.innovators.myapplication.API_KEY
import com.innovators.myapplication.data.remote.ApiService

class MovieRepository(private val apiService: ApiService) {

    fun getPopularMovies() = apiService.getPopular(API_KEY)
    fun getCastMovies(id:String) = apiService.getCast(id,API_KEY)
    fun getMoviesTrailer(id:String) = apiService.getTrailer(id,API_KEY)




}