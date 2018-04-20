package com.goileo.legleg.base.util;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;

/**
 * Created by Goileo on 2018/4/16.
 */

public class NetWorkUtil {

    /**
     * @param context
     * @return
     * @Title: isNetworkAvailable
     * @Description:判断网络连接是否可用
     */
    public static boolean isNetworkAvailable(Context context) {
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null)
                return networkInfo.isAvailable();
        }
        return false;
    }
}
