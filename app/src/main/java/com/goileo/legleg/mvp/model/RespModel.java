package com.goileo.legleg.mvp.model;

/**
 * Created by Goileo on 2018/4/16.
 */

public class RespModel<T> {

    public int status;
    public String desc;
    T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
