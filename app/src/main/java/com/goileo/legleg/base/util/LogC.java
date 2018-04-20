package com.goileo.legleg.base.util;

import android.util.Log;

import com.goileo.legleg.base.Constant;


/**
 * Created by Goileo on 2018/4/16.
 */

public class LogC {

    public static void e(String tag, String msg){
        if(Constant.isOpen){
            Log.e(tag, msg);
        }
    }

    public static void d(String tag, String msg){
        if(Constant.isOpen){
            Log.e(tag, msg);
        }
    }

}
