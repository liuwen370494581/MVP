package me.songning.mvp.mvp.contract;

import me.songning.mvp.base.BaseModel;
import me.songning.mvp.base.BasePresenter;
import me.songning.mvp.base.BaseView;
import me.songning.mvp.bean.Gank;
import rx.Observable;

/**
 * Created by liuwen on 2017/4/19.
 * 契约者 用来衔接view  model 和presenter
 */

public interface MainContract {

    //视图逻辑  视图逻辑都是为业务逻辑服务
    interface View extends BaseView {

        void showDialog();

        void onSucceed(Gank data);

        void onFail(String err);

        void hideDialog();

    }

    //业务逻辑
    interface Model extends BaseModel {
        Observable<Gank> getGank();
    }


    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getGank();
    }
}
