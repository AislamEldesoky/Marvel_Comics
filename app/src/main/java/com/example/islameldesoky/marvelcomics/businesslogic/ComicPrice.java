package com.example.islameldesoky.marvelcomics.businesslogic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by islam eldesoky on 08/08/2017.
 */

public class ComicPrice {
    @SerializedName("price")
    @Expose
    private String price ;

    @SerializedName("type")
    @Expose
    private String type ;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
