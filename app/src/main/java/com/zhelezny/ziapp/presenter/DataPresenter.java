package com.zhelezny.ziapp.presenter;

import android.util.Log;

import com.zhelezny.ziapp.api.AnimalApiService;
import com.zhelezny.ziapp.model.Animal;
import com.zhelezny.ziapp.model.Data;
import com.zhelezny.ziapp.view.MainInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataPresenter {
    private AnimalApiService mApiService;
    private MainInterface mainInterface;

    public DataPresenter(MainInterface mainInterface) {
        this.mainInterface = mainInterface;
        if (mApiService == null)
            mApiService = new AnimalApiService();
    }


    public void getData(String animal) {
        mApiService.getAPI().getResults(animal).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Data data = response.body();
                if (data != null && data.getData() != null) {
                    List<Animal> animals = data.getData();
                    mainInterface.showList(animals);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.e("error!", t.toString());
            }
        });
    }
}