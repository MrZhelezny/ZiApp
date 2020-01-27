package com.zhelezny.ziapp.model;

import com.google.gson.annotations.SerializedName;

public class Animal {
    @SerializedName("url")
    private String image;

    @SerializedName("title")
    private String title;

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}