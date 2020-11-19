package com.example.retrofit.logic.network;



import com.example.retrofit.logic.model.Shuju;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface PlaceService {
    @GET("v2/place?token=${weatherApllication.token}&lang=zh_CN")
    Call<Shuju.PlaceResPonse> searchPlaces(@Query("query") String query);
}
