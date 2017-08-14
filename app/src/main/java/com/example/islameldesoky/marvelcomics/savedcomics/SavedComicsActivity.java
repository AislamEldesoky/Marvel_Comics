package com.example.islameldesoky.marvelcomics.savedcomics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.islameldesoky.marvelcomics.R;
import com.example.islameldesoky.marvelcomics.businesslogic.Comics;
import com.example.islameldesoky.marvelcomics.businesslogic.Result;
import com.example.islameldesoky.marvelcomics.savedcomics.adapter.SavedComicsAdapter;
import com.example.islameldesoky.marvelcomics.utils.App;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SavedComicsActivity extends AppCompatActivity {
    public static final String ARG_COMIC = "comic";
    private RecyclerView recyclerView;
    private SavedComicsAdapter adapter;
    private List<Comics> comics;
    private Result result;


    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);

        recyclerView = (RecyclerView) findViewById(R.id.comic_list);

        DatabaseReference myRef = database.getReference("comics");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                comics = new ArrayList<>();
                for (DataSnapshot comicSnapShot : dataSnapshot.getChildren()) {
                    Comics comic = comicSnapShot.getValue(Comics.class);
                    comics.add(comic);
                }

                App.getInstance().setComics(comics);
                setComics(comics);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Firebase Error", databaseError.getMessage());
            }
        });
    }

    public void setComics(List<Comics> comics) {
        if (adapter == null) {
            adapter = new SavedComicsAdapter(comics);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setData(comics);
        }
    }
}

