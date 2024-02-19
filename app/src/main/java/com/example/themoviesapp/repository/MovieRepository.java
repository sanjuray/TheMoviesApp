package com.example.themoviesapp.repository;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.themoviesapp.R;
import com.example.themoviesapp.model.Movie;
import com.example.themoviesapp.model.Result;
import com.example.themoviesapp.serviceapi.MovieApiService;
import com.example.themoviesapp.serviceapi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    // used to abstract the data source details and
    // provides a clean API for the ViewModel to
    // fetch and manage data

    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        MovieApiService movieApiService = RetrofitInstance.getService();
        Call<Result> call = movieApiService.getPopularMovies(application.getApplicationContext().getString(R.string.api_key));

        //async method for http requests
        // to handle network request in the background thread
        // and handle the response in main UI thread
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if(result != null && result.getResults() != null){
                    movies = (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(), "REQUEST FAILURE!", Toast.LENGTH_SHORT).show();
            }
        });

        return mutableLiveData;
    }
}
