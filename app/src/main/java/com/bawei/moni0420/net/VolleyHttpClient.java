package com.bawei.moni0420.net;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.moni0420.VolleyApp;

/**
 * Project_Name: Moni0420
 * Time: 2019/4/20
 * Data: 晚么
 * Description:Vooley封装网络
 */
public class VolleyHttpClient {
    private static final VolleyHttpClient ourInstance = new VolleyHttpClient();

    public static VolleyHttpClient getInstance() {
        return ourInstance;
    }

    private VolleyHttpClient() {
    }
    //get请求
    public void getVolleyHttp(String url, final VolleyCallBack volleyCallBack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleyCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallBack.onFail(error);
            }
        });

        stringRequest.setTag("TestTag");

        VolleyApp.getVolley().add(stringRequest);


    }

    public interface VolleyCallBack{
        void onSuccess(String result);

        void onFail(VolleyError error);
    }

}
