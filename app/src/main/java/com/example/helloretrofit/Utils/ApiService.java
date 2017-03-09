package com.example.helloretrofit.Utils;

import com.example.helloretrofit.Entity.NewsGson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/3/8.
 */
public interface ApiService {
    @GET("{part}/")
    Observable<NewsGson> getNewsData(@Path("part") String part, @Query("key") String key, @Query("num") String num, @Query("page") int page);
}
