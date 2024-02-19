package com.example.themoviesapp.serviceapi;

import com.example.themoviesapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {
    //The service interface defines the structure
    //and behavior of the API requests
    //Acts as a bridge between your app and API
    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);
}
