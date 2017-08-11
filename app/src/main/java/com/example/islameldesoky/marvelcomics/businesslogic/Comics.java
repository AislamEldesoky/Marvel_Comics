package com.example.islameldesoky.marvelcomics.businesslogic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by islam eldesoky on 08/08/2017.
 */

public class Comics implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("dates")
    @Expose
    private List<Date> dates;

    @SerializedName("prices")
    @Expose
    private List<Price> prices;

    @SerializedName("images")
    @Expose
    private List<Image> images;

    @SerializedName("creators")
    @Expose
    private Creators creators;

    @SerializedName("characters")
    @Expose
    private Characters characters;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Date> getDates() {
        return dates;
    }

    public List<Price> getPrice() {
        return prices;
    }

    public List<Image> getImages() {
        return images;
    }

    public Creators getCreators() {
        return creators;
    }

    public Characters getCharacters() {
        return characters;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setCreators(Creators creators) {
        this.creators = creators;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
