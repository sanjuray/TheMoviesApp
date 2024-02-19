package com.example.themoviesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.themoviesapp.databinding.ActivityMain2Binding;
import com.example.themoviesapp.model.Movie;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        Movie movie = (Movie)i.getSerializableExtra("Movie");
        ActivityMain2Binding activityMain2Binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main2
        );
        activityMain2Binding.setMovie(movie);
    }
}