package star.liuwen.com.three.Model;

import star.liuwen.com.three.Presenter.OnJokeListener;

/**
 * Created by liuwen on 2017/4/14.
 * 业务需求和页面逻辑
 */
public interface JokeModel {


    /**
     * 获取笑话内容
     *
     * @param pNum            请求哪一页
     * @param pSize           每页返回多少条
     * @param pOnJokeListener 回调监听  这么model和presenter关联了起来
     */
    void getJoke(String pNum, String pSize, OnJokeListener pOnJokeListener);
}
