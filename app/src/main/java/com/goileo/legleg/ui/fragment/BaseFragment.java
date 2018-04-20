package com.goileo.legleg.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goileo.legleg.ui.ac.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by Goileo on 2018/4/16.
 */

public abstract class BaseFragment extends Fragment {

    private final static String TAG = BaseFragment.class.getSimpleName();
    protected BaseActivity baseActivity;
    protected Context context;
    protected View rootView;
    protected abstract View getRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = getRootView(inflater, container, savedInstanceState);
        }
        context = getActivity();
        if (context instanceof BaseActivity) {
            baseActivity = (BaseActivity) context;
        } else {
            throw new RuntimeException("Fragment的上层Activity必须为BaseActivity");
        }
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, rootView);
    }



    public void showLoading(){
        baseActivity.showLoading();
    }

    public void dismissLoading(){
        baseActivity.dismissLoading();
    }

    @Override
    public void onPause() {
        super.onPause();
//        LogC.d(TAG, "--onPause--");
    }

    @Override
    public void onStop() {
        super.onStop();
//        LogC.d(TAG, "--onStop--");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        LogC.d(TAG, "--onDestroyView--");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        LogC.d(TAG, "--onDestroy--");
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        LogC.d(TAG, "--onDetach--");
    }
}
