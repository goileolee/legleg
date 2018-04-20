package com.goileo.legleg.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goileo.legleg.R;
import com.goileo.legleg.base.adapter.WeatherAdapter;
import com.goileo.legleg.mvp.model.RespBean;
import com.goileo.legleg.mvp.presenter.WeatherPresenter;
import com.goileo.legleg.mvp.view.MainView;

import butterknife.Bind;

/**
 * Created by Goileo on 2018/4/19.
 */

public class WeatherFragment extends MvpFragment<WeatherPresenter> implements MainView<RespBean>,
        SwipeRefreshLayout.OnRefreshListener{

    @Bind(R.id.title_main_tv)
    TextView titleMainTv;
    @Bind(R.id.weather_recv)
    RecyclerView weatherRecv;
    @Bind(R.id.weather_fragment_srl)
    SwipeRefreshLayout weatherFragmentSrl;

    private View headView;
    private TextView cityWeatherTv;
    private TextView temperatureWeatherTv;
    private TextView aqiWeatherTv;
    private TextView descriptionWeatherTv;
    private WeatherAdapter weatherAdapter;
    private LinearLayoutManager layoutManager;
    private int lastItemPosition;
    private boolean isRefresh;

    @Override
    protected View getRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        headView = inflater.inflate(R.layout.item_head_weather, container, false);
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override
    protected WeatherPresenter createPresenter() {
        return new WeatherPresenter(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        weatherFragmentSrl.setOnRefreshListener(this);
        onRefresh();

        titleMainTv.setText(R.string.weather_name);
        layoutManager = new LinearLayoutManager(baseActivity);
        weatherRecv.setLayoutManager(layoutManager);
        weatherAdapter = new WeatherAdapter(baseActivity);
        weatherAdapter.setHeaderView(headView);
        weatherRecv.setAdapter(weatherAdapter);


        cityWeatherTv = headView.findViewById(R.id.city_weather_tv);
        temperatureWeatherTv = headView.findViewById(R.id.temperature_weather_tv);
        aqiWeatherTv = headView.findViewById(R.id.aqi_weather_tv);
        descriptionWeatherTv = headView.findViewById(R.id.description_weather_tv);

        weatherRecv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastItemPosition+1 == weatherAdapter.getItemCount()){
                    isRefresh = false;
                    // 处理加载更多
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastItemPosition = layoutManager.findLastVisibleItemPosition();
            }
        });
    }

    @Override
    public void onRefresh() {
        mvpPresenter.httpWeather("成都");
    }

    @Override
    public void getDataSuccess(RespBean model) {
        weatherFragmentSrl.setRefreshing(false);

        cityWeatherTv.setText(model.getCity());
        temperatureWeatherTv.setText(model.getWendu());
        aqiWeatherTv.setText(model.getAqi());
        descriptionWeatherTv.setText(model.getGanmao());

        weatherAdapter.clearDatas();
        weatherAdapter.addDatas(model.getForecast());
    }

    @Override
    public void getDataFail(String msg) {
        weatherFragmentSrl.setRefreshing(false);
        baseActivity.showToast("error: "+msg);

    }
}
