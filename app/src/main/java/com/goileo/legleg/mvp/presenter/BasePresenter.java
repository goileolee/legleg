package com.goileo.legleg.mvp.presenter;


import com.goileo.legleg.http.ApiClient;
import com.goileo.legleg.http.ApiStores;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Goileo on 2018/4/16.
 */

public class BasePresenter<V> {

    public V mvpView;
    protected ApiStores apiStores;
    public static Disposable disposable;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
        apiStores = ApiClient.retrofit().create(ApiStores.class);
    }

    public void detachView() {
        this.mvpView = null;
        if(disposable != null)
            disposable.dispose();
    }

    public void addSubscription(Observable observable, Observer observer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }



}
