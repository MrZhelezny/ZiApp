package com.zhelezny.ziapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimalApiService {
    private Retrofit retrofit = null;

    public AnimalApi getAPI() {
        String BASE_URL = "http://kot3.com/xim/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(AnimalApi.class);
    }
}