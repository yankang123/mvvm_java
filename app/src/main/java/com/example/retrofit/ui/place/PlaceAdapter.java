package com.example.retrofit.ui.place;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.retrofit.R;
import com.example.retrofit.logic.model.Shuju;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {
    private List<Shuju.Place> ponseList;
    public PlaceAdapter (List<Shuju.Place> ponseList){
        this.ponseList=ponseList;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView placename;
        TextView placeAdress;
        public ViewHolder(View view){
            super(view);
            placename=view.findViewById(R.id.placename);
            placeAdress=view.findViewById(R.id.placeAddress);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.place_item,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         Shuju.Place placeResPonse=ponseList.get(position);
          holder.placename.setText("placeResPonse.getName()");
          holder.placeAdress.setText(placeResPonse.getAddress());
    }

    @Override
    public int getItemCount() {
        return ponseList.size();
    }
}
