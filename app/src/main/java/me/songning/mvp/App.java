package me.songning.mvp;

import android.app.Application;

/**
 * Created by liuwen on 2017/4/19.
 */

public class App extends Application {

    private static App mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static App getContext() {
        return mContext;
    }
}
