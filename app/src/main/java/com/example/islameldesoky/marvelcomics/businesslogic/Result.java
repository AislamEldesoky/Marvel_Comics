package com.example.islameldesoky.marvelcomics.businesslogic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable {

    public Data getData() {
        return data;
    }

    @SerializedName("data")
    @Expose
    public Data data;

}