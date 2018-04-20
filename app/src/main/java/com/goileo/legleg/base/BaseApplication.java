package com.goileo.legleg.base;

import android.app.Application;

/**
 * Created by Goileo on 2018/4/8.
 */

public class BaseApplication extends Application {

    private static BaseApplication baseApp = null;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApp = this;
    }

    public static BaseApplication getApp() {
        return baseApp;
    }


}
