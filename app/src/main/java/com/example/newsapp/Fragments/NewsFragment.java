package com.example.newsapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.newsapp.Data.Article;
import com.example.newsapp.Data.Articles;
import com.example.newsapp.Data.ConstantVariables;
import com.example.newsapp.Data.NewsApi;
import com.example.newsapp.Data.NewsApiInterFace;
import com.example.newsapp.R;
import com.example.newsapp.RecyclerViewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {
 private String mCountery;
    private String mCategory;

    public void setmCountery(String mCountery) {
        this.mCountery = mCountery;
    }

    private Articles mArticles;
    private NewsApiInterFace mNewsApiInterFace;
   private TextView mTextView;
   private ProgressBar mProgressBar;
   private RecyclerViewAdapter recyclerViewAdapter;
   RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_news,container,false);
mProgressBar=view.findViewById(R.id.progressbar);
recyclerView=view.findViewById(R.id.ryclview);
mProgressBar.setVisibility(View.VISIBLE);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        mNewsApiInterFace= NewsApi.getApiClient().create(NewsApiInterFace.class);
        Call<Articles> call=mNewsApiInterFace.getArticles(mCategory, ConstantVariables.API_KEY,mCountery);
        call.enqueue(new Callback<Articles>() {
            @Override
            public void onResponse(Call<Articles> call, Response<Articles> response) {

                mProgressBar.setVisibility(View.INVISIBLE);
                mArticles=response.body();
                List<Article> articles=mArticles.getmArticles();
                recyclerViewAdapter=new RecyclerViewAdapter(getActivity(),articles);

                recyclerView.setAdapter(recyclerViewAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            }

            @Override
            public void onFailure(Call<Articles> call, Throwable t) {



            }
        });
        super.onCreate(savedInstanceState);
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }
}
