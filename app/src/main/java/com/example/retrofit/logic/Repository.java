package com.example.retrofit.logic;

import android.util.Log;

import com.example.retrofit.logic.model.Shuju;
import com.example.retrofit.logic.network.huidiao;
import com.example.retrofit.logic.network.weatherNetwork;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    weatherNetwork weatherNetwork;
  private static Repository repository;
  private Repository(){

  }
  public static Repository getRepository(){
  if(repository==null)
      repository=new Repository();
    return repository;
  }
  public LiveData<Shuju.PlaceResPonse> searchPlaces(String query, huidiao huidiao){
final MutableLiveData<Shuju.PlaceResPonse> place=new MutableLiveData();
    weatherNetwork=new weatherNetwork();
    weatherNetwork.searchPlace(query, new Callback<Shuju.PlaceResPonse>() {
        @Override
        public void onResponse(Call<Shuju.PlaceResPonse> call, Response<Shuju.PlaceResPonse> response) {
            Shuju.PlaceResPonse placeResPonse=response.body();
          place.postValue(placeResPonse);
          huidiao.huidiao(placeResPonse.getPlaces());
        }

        @Override
        public void onFailure(Call<Shuju.PlaceResPonse> call, Throwable t) {
            Log.d("傻", "onFailure: "+t.getMessage());
        }
    });
    return place ;
  }
}

