package com.example.retrofit.logic.network;

import android.util.Log;


import com.example.retrofit.logic.model.Shuju;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class weatherNetwork {
  public Shuju.PlaceResPonse placeResPonse;
    private  PlaceService placeService=ServiceCreater.getInstance().create(PlaceService.class);
    public void searchPlace(String Query, Callback<Shuju.PlaceResPonse> callback){
        Call<Shuju.PlaceResPonse> call=placeService.searchPlaces(Query);
        call.enqueue(callback);


    }

}
