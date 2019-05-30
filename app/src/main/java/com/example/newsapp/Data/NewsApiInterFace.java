package com.example.newsapp.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public  interface NewsApiInterFace {

@GET("/v2/top-headlines")
Call<Articles> getArticles(@Query("category") String category,@Query("apiKey") String apiKey,@Query("country") String country );
 }
