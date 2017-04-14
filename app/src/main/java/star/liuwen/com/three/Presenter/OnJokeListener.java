package star.liuwen.com.three.Presenter;

import star.liuwen.com.three.Entity.JoKe;

/**
 * Created by liuwen on 2017/4/14.
 */
public interface OnJokeListener {

    void onSuccess(JoKe joKe);

    void onError();
}
