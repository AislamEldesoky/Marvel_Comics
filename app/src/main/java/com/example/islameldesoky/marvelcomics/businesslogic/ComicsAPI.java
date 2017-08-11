package com.example.islameldesoky.marvelcomics.businesslogic;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by islam eldesoky on 08/08/2017.
 */

public interface ComicsAPI {
    @GET("comics?format=comic&dateDescriptor=thisWeek&ts=1&hash=92757a9d6b8bd95d92deae0cb6198043")
    Call<Result> getComics(@Query("apikey") String api_key);

}
