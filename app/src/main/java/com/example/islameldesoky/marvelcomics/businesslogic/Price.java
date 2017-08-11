package com.example.islameldesoky.marvelcomics.businesslogic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by islam eldesoky on 10/08/2017.
 */

public class Price implements Serializable {

    @SerializedName("price")
    @Expose
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
