package me.songning.mvp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by liuwen on 2017/5/2.
 */
public class ConnectionChangeReceiver extends BroadcastReceiver {
    private final String TAG = "MainActivity";
    private static int LastType = 1;//1.网络断开，-1网络连接
    private boolean mFirstReg = true;
    private IConnectionChangeReceiverListener mListener;
    private Context mContext;


    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            mContext = context;
            handler.postDelayed(runnable, 2500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.sendEmptyMessage(1);
        }
    };


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            ConnectionDetector cd = new ConnectionDetector(mContext);
            Boolean isInternetPresent = cd.isConnectingToInternet();
            if (!isInternetPresent) {
                if (LastType != -1) {
                    Log.e(TAG, "网络连接中断");
                    mListener.onDisconnect();
                }
                LastType = -1;
            } else {
                if (LastType != 1 && !mFirstReg) {
                    Log.e(TAG, "网络连接上");
                    mListener.onConnect();
                }
                LastType = 1;
            }
            mFirstReg = false;
        }
    };

    public void setListener(IConnectionChangeReceiverListener listener) {
        mListener = listener;

    }

    public interface IConnectionChangeReceiverListener {
        void onConnect();

        void onDisconnect();
    }
}
