package com.example.retrofit.logic.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Shuju {
    public class Location{
        String lng;
        String lat;

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }
    }

    public class Place{
        String name;
        Location location;
@SerializedName("formatted_address")
        String address;//有和没有这个注解有什么区别

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }


    }
 public class PlaceResPonse{
     public   String status;
        List<Place> places;


     public String getStatus() {
         return status;
     }

     public void setStatus(String statuss) {
         this.status = statuss;
     }

     public List<Place> getPlaces() {
         return places;
     }

     public void setPlaces(List<Place> places) {
         this.places = places;
     }
 }


}
