package com.goileo.legleg.mvp.presenter;


import com.goileo.legleg.http.ApiCallback;
import com.goileo.legleg.mvp.model.RespBean;
import com.goileo.legleg.mvp.view.MainView;

/**
 * Created by Goileo on 2018/4/16.
 */

public class WeatherPresenter extends BasePresenter<MainView> {

    public WeatherPresenter(MainView mainView){
        attachView(mainView);
    }

    public void httpWeather(String params){
        mvpView.showLoading();
        addSubscription(apiStores.apiWeather(params),
                new ApiCallback<RespBean>(){

                    @Override
                    public void onSuccess(RespBean model) {
                        mvpView.getDataSuccess(model);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.getDataFail(msg);
                    }

                    @Override
                    public void onFinish() {
                        mvpView.dismissLoading();
                    }
                });

    }
}
