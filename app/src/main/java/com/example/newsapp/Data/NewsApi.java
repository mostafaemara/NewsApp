package com.example.newsapp.Data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsApi {


public  static Retrofit retrofit=null;


public  static  Retrofit getApiClient(){
if (retrofit==null){



    retrofit=new Retrofit.Builder().
            baseUrl(ConstantVariables.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
return retrofit;



}

}
