package com.goileo.legleg.mvp.view;


/**
 * Created by Goileo on 2018/4/16.
 */

public interface MainView<T> extends BaseView {


    void getDataSuccess(T model);

    void getDataFail(String msg);

}
