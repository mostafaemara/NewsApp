package com.example.newsapp.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Articles {

    @SerializedName("articles")
    private List<Article> mArticles;

    public Articles(List<Article> mArticles) {
        this.mArticles = mArticles;
    }

    public List<Article> getmArticles() {
        return mArticles;
    }
}
