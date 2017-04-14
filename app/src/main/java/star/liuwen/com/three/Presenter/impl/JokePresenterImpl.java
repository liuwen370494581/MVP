package star.liuwen.com.three.Presenter.impl;

import star.liuwen.com.three.Entity.JoKe;
import star.liuwen.com.three.Model.JokeModel;
import star.liuwen.com.three.Model.impl.JokeModelImpl;
import star.liuwen.com.three.Presenter.JokePresenter;
import star.liuwen.com.three.Presenter.OnJokeListener;
import star.liuwen.com.three.Ui.JokeView;

/**
 * Created by liuwen on 2017/4/14.
 */
public class JokePresenterImpl implements JokePresenter, OnJokeListener {


    //p层作为M层的衔接者，需要持有JokeView和JokeModel的引用
    private JokeModel mJokeModel = new JokeModelImpl();
    private JokeView mJokeView;


    public JokePresenterImpl(JokeView jokeView) {
        mJokeView = jokeView;
    }


    /**
     * 读取Model的数据
     *
     * @param pNum
     * @param pSize
     */
    @Override
    public void getJoke(String pNum, String pSize) {
        mJokeView.showLoading();
        mJokeModel.getJoke(pNum, pSize, this);
    }

    @Override
    public void onSuccess(JoKe joKe) {
        mJokeView.hideLoading();
        mJokeView.setJoke(joKe);
    }

    @Override
    public void onError() {
        mJokeView.hideLoading();
    }
}
