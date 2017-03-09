package com.example.helloretrofit.Adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.helloretrofit.Entity.News;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by Administrator on 2017/3/8.
 */
public class NewsAdapter extends RecyclerArrayAdapter<News> {

    public NewsAdapter(Context context){
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(parent);
    }

}
