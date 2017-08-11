package com.example.islameldesoky.marvelcomics.businesslogic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by islam eldesoky on 08/08/2017.
 */

public class Characters implements Serializable {

    @SerializedName("items")
    @Expose
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public static class Item implements Serializable{

        @SerializedName("name")
        @Expose
        private String name;

        public String getName() {
            return name;
        }
    }
}
