package com.example.islameldesoky.marvelcomics.Comics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.TransitionInflater;

import com.example.islameldesoky.marvelcomics.Comics.adapter.ComicListAdapter;
import com.example.islameldesoky.marvelcomics.R;
import com.example.islameldesoky.marvelcomics.businesslogic.ComicController;
import com.example.islameldesoky.marvelcomics.businesslogic.Comics;

import java.util.List;

/**
 * Created by islam eldesoky on 08/08/2017.
 */

public class ComicListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private ComicListAdapter adapter;
    private  FragmentManager manager ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.comic_list);

        ComicController comicController = new ComicController(this);
        comicController.start();

        setupWindowAnimations();


    }

    private void setupWindowAnimations() {
       Explode explode = (Explode) TransitionInflater.from(this).inflateTransition(R.transition.activity_explode);
        getWindow().setExitTransition(explode);

    }

    public void setComics(List<Comics> comics) {
        if (adapter == null) {
            adapter = new ComicListAdapter(comics );
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setData(comics);
        }
    }
}
