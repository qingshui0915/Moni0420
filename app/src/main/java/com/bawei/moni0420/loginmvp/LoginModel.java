package com.bawei.moni0420.loginmvp;

import com.android.volley.VolleyError;
import com.bawei.moni0420.net.AsyncHttpClient;
import com.bawei.moni0420.net.VolleyHttpClient;

/**
 * Project_Name: Moni0420
 * Time: 2019/4/20
 * Data: 晚么
 * Description:
 */
public class LoginModel implements LoginConstract.ILoginModel {
    @Override
    public void Requester(String url, String username, String pwd, final ModelCallBack modelCallBack) {
        AsyncHttpClient.getInstance().postAsync(url, username, pwd, new AsyncHttpClient.AsyncCallBack() {
            @Override
            public void onSuccee(String result) {
                modelCallBack.onSuccess(result);
            }

            @Override
            public void onError(int code) {

            }
        });


    }
}
