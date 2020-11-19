package com.example.retrofit.ui.place;

import android.view.animation.Transformation;
import android.widget.Toast;

import com.example.retrofit.logic.Repository;
import com.example.retrofit.logic.model.Shuju;
import com.example.retrofit.logic.network.huidiao;
import com.example.retrofit.weatherApplication;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PlaceViewmodel extends ViewModel {
    Repository repository=Repository.getRepository();
    List<Shuju.Place> placeList=new ArrayList<>();
    MutableLiveData<String> ponseMutableLiveData=new MutableLiveData<>();
   public void getPlace(String query){
         ponseMutableLiveData.postValue(query);
    }
    public LiveData<Shuju.PlaceResPonse> liveData= Transformations.switchMap(ponseMutableLiveData,(baba)->{
      return repository.searchPlaces(baba, new huidiao() {
          @Override
          public void huidiao(List<Shuju.Place> places) {
              placeList=places;

              Placeteo.place=placeList.get(1);
          }
      });
    });
}
