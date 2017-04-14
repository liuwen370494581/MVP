package star.liuwen.com.three.Base;

import android.app.Application;

import com.android.volley.toolbox.Volley;

import star.liuwen.com.three.utils.VolleyRequest;

/**
 * Created by liuwen on 2017/4/14.
 */
public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        VolleyRequest.buildRequestQueue(this);
    }
}
