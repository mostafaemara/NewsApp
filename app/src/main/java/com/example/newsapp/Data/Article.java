package com.example.newsapp.Data;


import com.google.gson.annotations.SerializedName;

public class Article {


    @SerializedName("author")
    private  String mAuthor;

    @SerializedName("title")
    private  String mTitle;

    @SerializedName("description")
    private  String mDescription;

    @SerializedName("url")
    private  String mUrl;

    @SerializedName("urlToImage")
    private  String mUrlToImage;

    @SerializedName("publishedAt")
    private  String mPublishedAt;

    @SerializedName("content")
    private  String mContent;


    public Article(String mAuthor, String mTitle, String mDescription, String mUrl, String mUrlToImage, String mPublishedAt, String mContent) {
        this.mAuthor = mAuthor;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mUrl = mUrl;
        this.mUrlToImage = mUrlToImage;
        this.mPublishedAt = mPublishedAt;
        this.mContent = mContent;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmUrlToImage() {
        return mUrlToImage;
    }

    public String getmPublishedAt() {
        return mPublishedAt;
    }

    public String getmContent() {
        return mContent;
    }
}
