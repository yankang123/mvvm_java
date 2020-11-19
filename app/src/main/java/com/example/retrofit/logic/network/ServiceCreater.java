package com.example.retrofit.logic.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceCreater {
    private String BASE_URL="https://api.caiyunapp.com/";
    private Retrofit retrofit;
    private  static ServiceCreater instance;
    private ServiceCreater(){
        retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();


    }
    public static ServiceCreater getInstance(){
           if(instance==null){
   {
                   instance=new ServiceCreater();
               }
           }
           return instance;
    }
    public <T> T create(Class<T> service){
       return retrofit.create(service);
    }
}
