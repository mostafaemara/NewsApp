package com.example.newsapp.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newsapp.Data.Article;
import com.example.newsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleDetailsFragment extends Fragment {

private Article mArticle;
private  TextView title,description,author;
private ImageView articleImage;
private WebView webView;

    public void setmArticle(Article mArticle) {
        this.mArticle = mArticle;

    }

    public ArticleDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_article_details, container, false);

        webView=view.findViewById(R.id.webview);

        webView.loadUrl(mArticle.getmUrl());
        return  view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
    }
}
