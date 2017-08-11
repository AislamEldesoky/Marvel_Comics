package com.example.islameldesoky.marvelcomics.businesslogic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by islam eldesoky on 10/08/2017.
 */

public class Date implements Serializable {

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("date")
    @Expose
    private String date;

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
