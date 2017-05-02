package me.songning.mvp.ui;

import android.app.ProgressDialog;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import me.songning.mvp.R;
import me.songning.mvp.base.BaseActivity;
import me.songning.mvp.bean.Gank;
import me.songning.mvp.broadcast.ConnectionChangeReceiver;
import me.songning.mvp.mvp.contract.MainContract;
import me.songning.mvp.mvp.presenter.MainPresenter;

/**
 * Created by liuwen on 2017/4/19.
 */
public class MainActivity extends BaseActivity<MainPresenter>
        implements MainContract.View {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog mDialog;
    private Toolbar mToolbar;
    private FloatingActionButton mFab;
    private TextView mTextView;
    private RelativeLayout reShow;
    private ConnectionChangeReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mTextView = (TextView) findViewById(R.id.tv);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        reShow = (RelativeLayout) findViewById(R.id.re_show);

        mDialog = new ProgressDialog(this);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setCancelable(false);
        mDialog.setMessage("正在加载...");

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getGank();
            }
        });
        mReceiver = new ConnectionChangeReceiver();
        mReceiver.setListener(new ConnectionChangeReceiver.IConnectionChangeReceiverListener() {
            @Override
            public void onConnect() {
                reShow.setVisibility(View.GONE);
            }

            @Override
            public void onDisconnect() {
                reShow.setVisibility(View.VISIBLE);
            }
        });
        IntentFilter netConnFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mReceiver, netConnFilter);
    }

    @Override
    protected MainPresenter onCreatePresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showDialog() {
        mDialog.show();
    }

    @Override
    public void onSucceed(Gank data) {
        Toast.makeText(this, "请求成功", Toast.LENGTH_SHORT).show();
        List<Gank.Result> results = data.getResults();
        mTextView.setText(results.get(new Random().nextInt(10)).toString());
        for (Gank.Result result : results) {
            Log.e(TAG, result.toString());
        }
    }

    @Override
    public void onFail(String err) {
        Log.e(TAG, err);
        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideDialog() {
        mDialog.dismiss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mReceiver) {
            unregisterReceiver(mReceiver);
        }
    }
}
