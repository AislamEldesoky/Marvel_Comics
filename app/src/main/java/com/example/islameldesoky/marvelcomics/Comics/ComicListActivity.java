package com.example.islameldesoky.marvelcomics.Comics;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.example.islameldesoky.marvelcomics.Comics.adapter.ComicListAdapter;
import com.example.islameldesoky.marvelcomics.R;
import com.example.islameldesoky.marvelcomics.businesslogic.ComicController;
import com.example.islameldesoky.marvelcomics.businesslogic.Comics;
import com.example.islameldesoky.marvelcomics.savedcomics.SavedComicsActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by islam eldesoky on 08/08/2017.
 */

public class ComicListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ComicListAdapter adapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);

        recyclerView = (RecyclerView) findViewById(R.id.comic_list);

        ComicController comicController = new ComicController(this);
        comicController.start();

        setupWindowAnimations();

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }

    private void setupWindowAnimations() {
        Explode explode = (Explode) TransitionInflater.from(this).inflateTransition(R.transition.activity_explode);
        getWindow().setExitTransition(explode);

    }

    public void setComics(List<Comics> comics) {
        if (adapter == null) {
            adapter = new ComicListAdapter(comics);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setData(comics);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_comic_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();

        switch (i) {
            case R.id.action_view_saved_comics:
                startActivity(new Intent(this, SavedComicsActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
