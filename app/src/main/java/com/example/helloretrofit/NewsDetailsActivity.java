package com.example.helloretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/8.
 */
public class NewsDetailsActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private WebView webView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail);
        webView=(WebView)findViewById(R.id.webview);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        imageView=(ImageView)findViewById(R.id.ivImage);
        toolbar.setTitle("新闻详情");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //新页面接受数据
        Bundle bundle=this.getIntent().getExtras();
        final ArrayList<String> data=bundle.getStringArrayList("data");
        Log.d("url",data.get(0));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
        });
        webView.loadUrl(data.get(1));
        Glide.with(this).load(data.get(0)).error(R.mipmap.ic_launcher)
                .fitCenter().into(imageView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
