package com.example.islameldesoky.marvelcomics.Comics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.islameldesoky.marvelcomics.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_comic_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();

        switch (i) {
            case R.id.action_read_later:
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child("comics").push().setValue(getIntent().getExtras().getSerializable(ComicDetailFragment.ARG_COMIC));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
