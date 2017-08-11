package com.example.islameldesoky.marvelcomics.businesslogic;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.islameldesoky.marvelcomics.Comics.ComicListActivity;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by islam eldesoky on 08/08/2017.
 */

public class ComicController {
    static final String BASE_URL = "https://gateway.marvel.com/v1/public/";
    List<Comics> comics;
    String apikey = "7600e42cb3ea1a7c5d80726191fe717f";
    Call<Result> call;

    private ComicListActivity comicListActivity;

    public ComicController(AppCompatActivity activity) {
        this.comicListActivity = (ComicListActivity) activity;
    }

    public void start() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ComicsAPI comicsAPI = retrofit.create(ComicsAPI.class);
        call = comicsAPI.getComics(apikey);
        new ComicsAsyncTask().execute();
    }

    private class ComicsAsyncTask extends AsyncTask<Void, Void, Response<Result>> {

        @Override
        protected Response<Result> doInBackground(Void... params) {
            try {
                return call.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Response<Result> response) {
            if (response.isSuccessful()) {
                comics = response.body().data.results;
                comicListActivity.setComics(response.body().data.results);
                //App.getInstance().setComics(response.body().data.results);
                Log.d("CC: response", response.body().data.results.get(0).getTitle());
            } else {
                Log.e("RC", response.message());
                Toast.makeText(comicListActivity, response.message(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
