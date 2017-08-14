package com.example.islameldesoky.marvelcomics.utils;

import android.app.Application;

import com.example.islameldesoky.marvelcomics.businesslogic.Comics;
import com.orhanobut.hawk.Hawk;

import java.util.List;

/**
 * Created by islam eldesoky on 12/08/2017.
 */

public class App extends Application {
    private static App instance;

    public static final String ARG_COMICS = "comics";

    public App() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
    }

    public static App getInstance() {
        return instance;
    }

    public void setComics(List<Comics> comics) {
        Hawk.put(ARG_COMICS, comics);
    }

    public List<Comics> getComics() {
        return Hawk.get(ARG_COMICS);
    }
}
