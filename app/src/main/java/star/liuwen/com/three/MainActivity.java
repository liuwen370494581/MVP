package star.liuwen.com.three;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import star.liuwen.com.three.Base.BaseActivity;
import star.liuwen.com.three.Entity.JoKe;
import star.liuwen.com.three.Entity.JokeInfo;
import star.liuwen.com.three.Presenter.JokePresenter;
import star.liuwen.com.three.Ui.JokeView;

public class MainActivity extends BaseActivity implements JokeView {


    public static final String PAGE_NUM = "1";
    public static final String PAGE_SIZE = "20";

    private JokePresenter mJokePresenter = null;
    private ArrayList<JokeInfo> mJokeInfoArrayList = null;


    @Override
    protected void initVariables() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void loaderData() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void setJoke(JoKe joke) {

    }

    @Override
    public void showError() {

    }
}
