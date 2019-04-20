package com.bawei.moni0420.net;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Project_Name: Moni0420
 * Time: 2019/4/20
 * Data: 晚么
 * Description:
 */
public class AsyncHttpClient {
    private static final AsyncHttpClient ourInstance = new AsyncHttpClient();

    public static AsyncHttpClient getInstance() {
        return ourInstance;
    }

    private AsyncHttpClient() {
    }
    //post异步请求
    public void postAsync(String url, String username, String pwd, final AsyncCallBack asyncCallBack){
        new AsyncTask<String,Void,String>(){
            @Override
            protected String doInBackground(String... strings) {
                return postDataFromServer(strings[0],strings[1],strings[2]);
            }

            @Override
            protected void onPostExecute(String s) {
                if (!TextUtils.isEmpty(s)){
                    asyncCallBack.onSuccee(s);
                }else{
                    asyncCallBack.onError(2002);
                }
            }
        }.execute(url,username,pwd);

    }
    //post获取网络请求
    public String postDataFromServer(String url,String name,String pwd){
        HttpURLConnection connection=null;
        try {
            URL url1 = new URL(url);
            connection= (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            //请求头
            String body = "phone=" + URLEncoder.encode(name) + "&pwd=" + URLEncoder.encode(pwd);
            connection.getOutputStream().write(body.getBytes());
            //判断
            if (connection.getResponseCode()==HttpURLConnection.HTTP_OK){
                return CharStreams.toString(new InputStreamReader(connection.getInputStream()));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    //设置接口
    public interface AsyncCallBack{
        void onSuccee(String result);

        void onError(int code);
    }

}
