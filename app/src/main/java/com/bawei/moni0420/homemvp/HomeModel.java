package com.bawei.moni0420.homemvp;

import com.android.volley.VolleyError;
import com.bawei.moni0420.net.VolleyHttpClient;

/**
 * Project_Name: Moni0420
 * Time: 2019/4/20
 * Data: 晚么
 * Description:
 */
public class HomeModel implements HomeConstract.IHomeModel {
    public static final String URL="http://172.17.8.100/small/commodity/v1/commodityList";
    @Override
    public void getRequest(final ModelCallBack modelCallBack) {
        //网络请求
        VolleyHttpClient.getInstance().getVolleyHttp(URL, new VolleyHttpClient.VolleyCallBack() {
            @Override
            public void onSuccess(String result) {
                modelCallBack.onSuccess(result);
            }

            @Override
            public void onFail(VolleyError error) {
                modelCallBack.onError();
            }
        });
    }
}
