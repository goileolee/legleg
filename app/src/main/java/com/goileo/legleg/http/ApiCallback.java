package com.goileo.legleg.http;


import com.goileo.legleg.base.util.LogC;
import com.goileo.legleg.mvp.model.RespModel;
import com.goileo.legleg.mvp.presenter.BasePresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by Goileo on 2018/4/16.
 */

public abstract class ApiCallback<M> implements Observer<RespModel<M>> {

    public abstract void onSuccess(M model);

    public abstract void onFailure(String msg);

    public abstract void onFinish();

    @Override
    public void onSubscribe(Disposable d) {
        BasePresenter.disposable = d;
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            String msg = httpException.getMessage();
            LogC.d("ApiCallback", "code=" + code);
            if (code == 504) {
                msg = "网络不给力";
            }
            if (code == 502 || code == 404) {
                msg = "服务器异常，请稍后再试";
            }
            onFailure(msg);
        } else {
            onFailure(e.getMessage());
        }
        onFinish();
    }

    @Override
    public void onNext(RespModel<M> model) {
        switch (model.getStatus()){
            case 1000:
                onSuccess(model.getData());
                break;
            default:
                onFailure(model.getDesc());
                break;
        }
    }

    @Override
    public void onComplete() {
        onFinish();
    }
}
