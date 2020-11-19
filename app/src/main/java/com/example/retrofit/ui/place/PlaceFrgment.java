package com.example.retrofit.ui.place;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit.MainActivity;
import com.example.retrofit.R;
import com.example.retrofit.logic.Repository;
import com.example.retrofit.logic.model.Shuju;
import com.example.retrofit.weatherApplication;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PlaceFrgment extends Fragment {

private PlaceAdapter placeAdapter;
EditText editText;
TextView textView;
RecyclerView recyclerView;
Button button;
List<Shuju.Place> listyy=new ArrayList<>();

    String content=null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_place,container,false);
recyclerView=view.findViewById(R.id.recyclerview);
editText=view.findViewById(R.id.searchPaceEdit);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        PlaceViewmodel viewmodel=new ViewModelProvider(this).get(PlaceViewmodel.class);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(weatherApplication.getContext());
        recyclerView.setLayoutManager(layoutManager);
        List<Shuju.Place> list=new ArrayList<>();
        Shuju shuju=new Shuju();
        Shuju.Place place=shuju.new Place();
        place.setAddress("dkdsf");
        place.setName("啥子");
        list.add(place);

        placeAdapter=new PlaceAdapter(listyy);//检测方法一，添加一个place
recyclerView.setAdapter(placeAdapter);

editText.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String content=s.toString();
        if(content.isEmpty()){

        }else
viewmodel.getPlace(s.toString());
    }
});

        viewmodel.liveData.observe(getViewLifecycleOwner(), new Observer<Shuju.PlaceResPonse>() {
            @Override
            public void onChanged(Shuju.PlaceResPonse placeResPonse) {
              
                listyy.addAll(viewmodel.placeList);
                placeAdapter.notifyDataSetChanged();
            }
        });;

    }

}
