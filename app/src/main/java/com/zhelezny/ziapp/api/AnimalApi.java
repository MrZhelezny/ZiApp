package com.zhelezny.ziapp.api;

import com.zhelezny.ziapp.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AnimalApi {
    @GET("api.php")
    Call<Data> getResults(@Query("query") String animal);
}