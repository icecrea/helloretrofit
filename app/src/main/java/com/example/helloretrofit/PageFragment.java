package com.example.helloretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.helloretrofit.Adapter.NewsAdapter;
import com.example.helloretrofit.Entity.News;
import com.example.helloretrofit.Entity.NewsGson;
import com.example.helloretrofit.Utils.ApiService;
import com.example.helloretrofit.Utils.PixUtil;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/3/7.
 */
public class PageFragment extends Fragment {
    public static final String PATH = "args_page";
    private int mPage;
    private List<News> newsListx;
    private NewsAdapter adapter;
    private int page=1;
    private String part;
    private static String[] path={"social","guonei","world","huabian","tiyu","nba","football"
    ,"keji","startup","apple"};

    public static PageFragment newInstance(int position) {
        Bundle args = new Bundle();

        args.putString(PATH, path[position]);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        part = getArguments().getString(PATH);
        adapter=new NewsAdapter(getActivity());
        newsListx=new ArrayList<News>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_recycler,container,false);
        EasyRecyclerView recyclerView=(EasyRecyclerView)view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        getData(part);
        SpaceDecoration itemDecoration = new SpaceDecoration((int) PixUtil.convertDpToPixel(8,getActivity()));//参数是距离宽度
        itemDecoration.setPaddingEdgeSide(true);//是否为左右2边添加padding.默认true.
        itemDecoration.setPaddingStart(true);//是否在给第一行的item添加上padding(不包含header).默认true.
        itemDecoration.setPaddingHeaderFooter(false);//是否对Header于Footer有效,默认false.
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                page=1;
                getData(part);
            }
        });
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                getData(part);
            }

            @Override
            public void onMoreClick() {

            }
        });
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ArrayList<String> data=new ArrayList<String>();
                data.add(adapter.getAllData().get(position).getPicUrl());
                data.add(adapter.getAllData().get(position).getUrl());
                Intent intent=new Intent(getActivity(),NewsDetailsActivity.class);
                Bundle bundle=new Bundle();
                bundle.putStringArrayList("data",data);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }

    public void getData(String part){
        Log.d("page",page+"");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com/")
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService service=retrofit.create(ApiService.class);
        //用rxjava+retroift进行网络请求
        service.getNewsData(part,"6ccd95e92c8481e4b1584316244b6a97", "10", page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<NewsGson, List<News>>() {
                    @Override
                    public List<News> call(NewsGson newsGson) {
                        return newsGson.getNewslist();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<News>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("hello",e.getMessage());
                        Toast.makeText(getActivity(),
                                "网络连接失败", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(List<News> newsList) {
                        //几个小时的教训！此处不能这样等于
                        //  newsListx=newsList;
                        //这个可以
                        //newsListx.addAll(newsList);
                        adapter.addAll(newsList);
                    }
                });
        page=page+1;
    }
}
