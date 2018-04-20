package com.goileo.legleg.mvp.model;

import java.util.List;

/**
 * Created by Goileo on 2018/4/19.
 */

public class RespBean {

    String wendu;
    String ganmao;
    List<WeatherBean> forecast;
    Object yesterday;
    String aqi;
    String city;

    public String getWendu() {
        return wendu;
    }

    public String getGanmao() {
        return ganmao;
    }

    public List<WeatherBean> getForecast() {
        return forecast;
    }

    public String getAqi() {
        return aqi;
    }

    public String getCity() {
        return city;
    }

    public class WeatherBean{
        String fengxiang;
        String fengli;
        String high;
        String type;
        String low;
        String date;

        public String getFengxiang() {
            return fengxiang;
        }

        public String getFengli() {
            return fengli;
        }

        public String getHigh() {
            return high;
        }

        public String getType() {
            return type;
        }

        public String getLow() {
            return low;
        }

        public String getDate() {
            return date;
        }
    }

}
