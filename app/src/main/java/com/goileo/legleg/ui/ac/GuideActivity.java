package com.goileo.legleg.ui.ac;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

import com.goileo.legleg.R;
import com.goileo.legleg.base.util.NetWorkUtil;
import com.goileo.legleg.mvp.presenter.BasePresenter;


/**
 * Created by Goileo on 2018/4/17.
 */

public class GuideActivity extends MvpActivity {

    static AsyncTask asyncTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        if(!NetWorkUtil.isNetworkAvailable(this)){
            new AlertDialog.Builder(this)
                    .setTitle("无网络提示")
                    .setMessage("当前没有网络，请打开网络")
                    .create().show();
        }

        startApp();
    }

    public void startApp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1500);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(GuideActivity.this, MainActivity.class));
                        finish();
                    }
                });
            }
        }).start();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
