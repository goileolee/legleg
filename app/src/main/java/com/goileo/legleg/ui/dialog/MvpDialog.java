package com.goileo.legleg.ui.dialog;

import android.content.Context;
import android.support.annotation.NonNull;

import com.goileo.legleg.mvp.presenter.BasePresenter;

/**
 * Created by Goileo on 2018/4/16.
 */

public abstract class MvpDialog<P extends BasePresenter> extends BaseDialog {
    protected P mvpPresenter;
    protected abstract P createPresenter();

    public MvpDialog(@NonNull Context context) {
        super(context);
        mvpPresenter = createPresenter();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if(mvpPresenter != null){
            mvpPresenter.detachView();
        }
    }
}
