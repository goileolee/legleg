package com.goileo.legleg.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goileo.legleg.R;

import butterknife.Bind;


/**
 * Created by Goileo on 2018/4/16.
 */

public class LeftFragment extends BaseFragment {

    private static final String TAG = LeftFragment.class.getSimpleName();
    @Bind(R.id.title_main_tv)
    TextView titleMainTv;
    public static LeftFragment leftFragment;

    public static LeftFragment getInstance() {
        if (leftFragment == null) {
            leftFragment = new LeftFragment();
        }
        return leftFragment;
    }

    @Override
    protected View getRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_left, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        titleMainTv.setText(R.string.leftFragment_name);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
