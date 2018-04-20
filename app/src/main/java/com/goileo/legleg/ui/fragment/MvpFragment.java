package com.goileo.legleg.ui.fragment;


import android.os.Bundle;
import android.view.View;

import com.goileo.legleg.mvp.presenter.BasePresenter;


/**
 * Created by Goileo on 2018/4/16.
 */

public abstract class MvpFragment<P extends BasePresenter> extends BaseFragment {
    protected P mvpPresenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter = createPresenter();
    }

    protected abstract P createPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }
}
