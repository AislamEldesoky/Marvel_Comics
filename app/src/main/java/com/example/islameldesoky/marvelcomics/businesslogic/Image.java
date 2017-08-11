package com.example.islameldesoky.marvelcomics.businesslogic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by islam eldesoky on 08/08/2017.
 */

public class Image implements Serializable {
    @SerializedName("path")
    @Expose
    private String path ;

    @SerializedName("extension")
    @Expose
    private String extension  ;

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
