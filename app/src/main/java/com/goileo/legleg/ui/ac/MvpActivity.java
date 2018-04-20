package com.goileo.legleg.ui.ac;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.goileo.legleg.mvp.presenter.BasePresenter;


/**
 * Created by Goileo on 2018/4/16.
 */

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {

    protected P mvpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mvpPresenter != null){
            mvpPresenter.detachView();
        }
    }
}
