package star.liuwen.com.three.Ui;

import star.liuwen.com.three.Entity.JoKe;

/**
 * Created by liuwen on 2017/4/14.
 */
public interface JokeView {


    void showLoading();

    void hideLoading();

    void setJoke(JoKe joke);

    void showError();
}



