package com.goileo.legleg.base.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goileo.legleg.R;
import com.goileo.legleg.mvp.model.RespBean;
import com.goileo.legleg.ui.ac.BaseActivity;


/**
 * Created by Goileo on 2018/4/19.
 */

public class WeatherAdapter extends BaseRecyclerAdapter<RespBean.WeatherBean> {

    private BaseActivity baseActivity;

    public WeatherAdapter(BaseActivity baseActivity){
        this.baseActivity = baseActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(baseActivity).inflate(R.layout.item_weather, parent, false);
        return new WeatherHolder(view);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, final RespBean.WeatherBean data) {
        if(viewHolder instanceof WeatherHolder) {
            WeatherHolder weatherHolder = (WeatherHolder) viewHolder;

            weatherHolder.windDirectionWeatherTv.setText(data.getFengxiang());
            weatherHolder.windPowerWeatherTv.setText(data.getFengli());
            weatherHolder.highTemperatureWeatherTv.setText(data.getHigh());
            weatherHolder.typeWeatherTv.setText(data.getType());
            weatherHolder.lowTemperatureWeatherTv.setText(data.getLow());
            weatherHolder.dateWeatherTv.setText(data.getDate());

        }
    }

    class WeatherHolder extends Holder{
        TextView windDirectionWeatherTv;
        TextView windPowerWeatherTv;
        TextView highTemperatureWeatherTv;
        TextView typeWeatherTv;
        TextView lowTemperatureWeatherTv;
        TextView dateWeatherTv;

        public WeatherHolder(View itemView) {
            super(itemView);
            windDirectionWeatherTv = itemView.findViewById(R.id.wind_direction_weather_tv);
            windPowerWeatherTv = itemView.findViewById(R.id.wind_power_weather_tv);
            highTemperatureWeatherTv = itemView.findViewById(R.id.high_temperature_weather_tv);
            typeWeatherTv = itemView.findViewById(R.id.type_weather_tv);
            lowTemperatureWeatherTv = itemView.findViewById(R.id.low_temperature_weather_tv);
            dateWeatherTv = itemView.findViewById(R.id.date_weather_tv);

        }
    }
}
