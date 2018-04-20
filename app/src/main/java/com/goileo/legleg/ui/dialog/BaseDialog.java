package com.goileo.legleg.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.goileo.legleg.R;
import com.goileo.legleg.mvp.presenter.BasePresenter;
import com.goileo.legleg.ui.ac.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by Goileo on 2018/4/16.
 */

public class BaseDialog<P extends BasePresenter> extends Dialog {

    private BaseActivity baseActivity;

    public BaseDialog(@NonNull Context context) {
        super(context, R.style.customDialog);
        baseActivity = (BaseActivity) context;
    }

    @Override
    public void setContentView(@NonNull View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(@NonNull View view, @Nullable ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setCanceledOnTouchOutside(false);

    }

    public void showLoading(){
        baseActivity.showLoading();
    }

    public void dismissLoading(){
        baseActivity.dismissLoading();
    }


}
