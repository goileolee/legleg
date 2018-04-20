package com.goileo.legleg.http;


import com.goileo.legleg.mvp.model.RespBean;
import com.goileo.legleg.mvp.model.RespModel;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Goileo on 2018/4/16.
 */

public interface ApiStores {

    String SERVER_URL = "http://wthrcdn.etouch.cn/";

    @GET("weather_mini")
    Observable<RespModel<RespBean>> apiWeather(@Query("city") String params);


    // ================ 以下是实际项目中可能会用到的请求方式 ==========================================

    // GET 示例
    // params 参数会跟到 api/one 后面进行请求
    @GET("api/one")
    Observable<RespModel<RespBean>> apiOne(@QueryMap Map<String, Object> params);

    @GET("api/two")
    Observable<RespModel<List<RespBean>>> apiTwo(@QueryMap Map<String, Object> params);


    // POST 示例
    // params 参数会添加到请求体中

    /**
     * {
     *     "msg":"success"
     *     "code":200
     *     "data":[]
     * }
     */
    @POST("api/three")
    Observable<RespModel<List<RespBean>>> apiThree(@Body Map<String, Object> params);

    /**
     * {
     *     "msg":"success"
     *     "code":200
     *     "data":{}
     * }
     */
    @POST("api/four")
    Observable<RespModel<RespBean>> apiFour(@Body Map<String, Object> params);

    /**
     * {
     *     "msg":"success"
     *     "code":200
     *     "data":""
     * }
     */
    @POST("api/five")
    Observable<RespModel> apiFive(@Body Map<String, Object> params);

    /**
     * 表单上传方式
     * 返回类型与 api/four 类似。
     */
    @FormUrlEncoded
    @POST("api/six")
    Observable<RespModel<RespBean>> apiSix(@FieldMap Map<String, Object> params);

}
