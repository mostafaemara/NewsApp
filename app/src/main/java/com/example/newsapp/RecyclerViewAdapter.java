package com.example.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newsapp.Data.Article;
import com.example.newsapp.Fragments.ArticleDetailsFragment;
import com.example.newsapp.Fragments.NewsFragment;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter< RecyclerViewAdapter.ArticleViewHolder> {



    public interface OnItemClickListener {
        void onItemClick(Article item);
    }

private Context mContext;


    public RecyclerViewAdapter(Context mContext, List<Article> mArticles) {
        this.mContext = mContext;
        this.mArticles = mArticles;
    }

    List<Article> mArticles;

    public RecyclerViewAdapter(List<Article> mArticles) {
        this.mArticles = mArticles;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items,viewGroup,false);
        ArticleViewHolder articleViewHolder=new ArticleViewHolder(view);
        return articleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder articleViewHolder, int i) {
       Article article= mArticles.get(i);
        articleViewHolder.mArticleTitle.setText(article.getmTitle());

        Glide.with(mContext).load(article.getmUrlToImage()).into(articleViewHolder.mArticalImageView);

    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public  class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

private TextView mArticleTitle;
private ImageView mArticalImageView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            mArticleTitle=itemView.findViewById(R.id.arttitle);

  mArticalImageView=itemView.findViewById(R.id.artimage);
itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
Article article=mArticles.get(getLayoutPosition());


            Fragment fragment;

            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            fragment = new ArticleDetailsFragment();
             ((ArticleDetailsFragment) fragment).setmArticle(article);
            activity.getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.fragment_container, fragment).
                    addToBackStack(null).
                    commit();

        }
    }

    }



