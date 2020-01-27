package com.zhelezny.ziapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("text")
    private String text;

    @SerializedName("data")
    private List<Animal> data;

    public String getText() {
        return text;
    }

    public List<Animal> getData() {
        return data;
    }
}