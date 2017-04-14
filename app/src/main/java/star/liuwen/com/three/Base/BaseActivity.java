package star.liuwen.com.three.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by liuwen on 2017/4/14.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariables();
        initView();
        loaderData();
    }

    //做一些初始化方面的工作，比如接收上一个界面的Intent
    protected abstract void initVariables();

    //初始化控件
    protected abstract void initView();

    //加载数据
    protected abstract void loaderData();
}
