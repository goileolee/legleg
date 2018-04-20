package com.goileo.legleg.ui.ac;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by Goileo on 2018/4/16.
 */

public class BaseActivity extends AppCompatActivity {
    public Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setFullScreen(){
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        ViewGroup mContentView = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
        View statusBarView = mContentView.getChildAt(0);
        //移除假的 View
        if (statusBarView != null && statusBarView.getLayoutParams() != null && statusBarView.getLayoutParams().height == getStatusBarHeight(this)) {
            mContentView.removeView(statusBarView);
        }
        //不预留空间
        if (mContentView.getChildAt(0) != null) {
            ViewCompat.setFitsSystemWindows(mContentView.getChildAt(0), false);
        }
    }

    public int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        setFullScreen();
        ButterKnife.bind(this);
        mActivity = this;
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setFullScreen();
        ButterKnife.bind(this);
        mActivity = this;
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        setFullScreen();
        ButterKnife.bind(this);
        mActivity = this;
    }

    private Toast mToast = null;
    public void showToast(CharSequence msg){
        if(mToast == null)
            mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        else mToast.setText(msg);
        mToast.show();
    }

    public void showToast(int resId){
        showToast(getResources().getText(resId));
    }

    public ProgressDialog progressDialog = null;

    public ProgressDialog showProgressDialog(CharSequence message) {
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage(message);
        progressDialog.show();
        return progressDialog;
    }

    private int count = 0;
    public void showLoading(){
        if(progressDialog != null){
            count +=1;
            return;
        }
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage("加载中");
        progressDialog.show();
    }

    public void dismissLoading(){
        if(count > 0){
            count -=1;
            return;
        }
        if (progressDialog != null && progressDialog.isShowing()) {
            // progressDialog.hide();//会导致android.view.WindowLeaked
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
