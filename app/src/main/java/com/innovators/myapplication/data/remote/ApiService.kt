package com.innovators.myapplication.data.remote

import com.innovators.myapplication.model.cast.CastResponse
import com.innovators.myapplication.model.result.PopularMovieResponse
import com.innovators.myapplication.model.trailer.TrailerResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getPopular(@Query("api_key") apiKey:String) : Single<PopularMovieResponse>

    @GET("movie/{id}/credits")
    fun getCast(@Path("id") id:String, @Query("api_key") apiKey:String) : Single<CastResponse>

    @GET("movie/{id}/videos")
    fun getTrailer(@Path("id") id:String, @Query("api_key") apiKey:String) : Single<TrailerResponse>
}

