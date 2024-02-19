package com.example.themoviesapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.themoviesapp.model.Movie;
import com.example.themoviesapp.repository.MovieRepository;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    //androidViewModel: used whe viewmodel class needs to access android-specific components
    //viewModel : used for non-android-specific logic like data transformation and presentaion logic

    Application application;
    private MovieRepository movieRepository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        this.movieRepository = new MovieRepository(application);
    }

    public LiveData<List<Movie>> getAllMovies(){
        return movieRepository.getMutableLiveData();
    }

}
