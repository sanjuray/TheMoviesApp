package com.example.themoviesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;

import com.example.themoviesapp.databinding.ActivityMainBinding;
import com.example.themoviesapp.model.Movie;
import com.example.themoviesapp.view.MovieAdapter;
import com.example.themoviesapp.viewModel.MyViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> movies;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ActivityMainBinding binding;
    private MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        );

        myViewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);

        getPopularMovies();

        swipeRefreshLayout = binding.swipeLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.black);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovies();
            }
        });

    }

    private void getPopularMovies() {
        myViewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> moviesFromLiveData) {
                movies = (ArrayList<Movie>) moviesFromLiveData;
                displayMoviesInRecyclerView();
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        },2);
    }

    private void displayMoviesInRecyclerView() {
        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        movieAdapter = new MovieAdapter(this, movies);



        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(movieAdapter);

        movieAdapter.notifyDataSetChanged();
    }
}