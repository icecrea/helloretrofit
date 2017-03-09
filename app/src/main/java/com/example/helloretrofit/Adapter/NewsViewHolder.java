package com.example.helloretrofit.Adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.helloretrofit.Entity.News;
import com.example.helloretrofit.Utils.MyApplication;
import com.example.helloretrofit.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2017/3/8.
 */
public class NewsViewHolder extends BaseViewHolder<News> {
    private TextView title;
    private ImageView imageView;
    private TextView date;

    @Override
    public void setData(News news) {
        date.setText(news.getCtime());
        title.setText(news.getTitle());
        Glide.with(MyApplication.getContext()).load(news.getPicUrl()).into(imageView);
    }

    public NewsViewHolder(ViewGroup parent) {
        super(parent, R.layout.news_recycler_item);
        title=$(R.id.news_item_title);
        date=$(R.id.news_item_date);
        imageView=$(R.id.news_item_image);
    }
}

