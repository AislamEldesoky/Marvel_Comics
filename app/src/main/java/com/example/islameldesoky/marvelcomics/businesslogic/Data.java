package com.example.islameldesoky.marvelcomics.businesslogic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {

    public List<Comics> getResults() {
        return results;
    }

    @SerializedName("results")
    @Expose
    public List<Comics> results;

}