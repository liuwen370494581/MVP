package me.songning.mvp.api;

import me.songning.mvp.bean.Gank;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by liuwen on 2017/4/19.
 */

public interface ApiService {

    String BASE_URL="http://gank.io/";

    @GET("api/data/Android/10/{page}")
    Observable<Gank> getGank(@Path("page") String page);

}
