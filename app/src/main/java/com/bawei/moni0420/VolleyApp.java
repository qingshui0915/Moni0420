package com.bawei.moni0420;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Project_Name: Moni0420
 * Time: 2019/4/20
 * Data: 晚么
 * Description:
 */
public class VolleyApp extends Application {

    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }
    public static RequestQueue getVolley(){
        return requestQueue;
    }
}
