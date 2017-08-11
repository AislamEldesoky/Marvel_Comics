package com.example.islameldesoky.marvelcomics.Comics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.islameldesoky.marvelcomics.R;

/**
 * Created by islam eldesoky on 08/08/2017.
 */

public class ComicDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.detail_container, new ComicDetailFragment())
                    .commit();
        }
    }

    }
