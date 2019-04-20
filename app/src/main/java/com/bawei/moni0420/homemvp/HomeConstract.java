package com.bawei.moni0420.homemvp;

import com.bawei.moni0420.MainActivity;

/**
 * Project_Name: Moni0420
 * Time: 2019/4/20
 * Data: 晚么
 * Description:契约类
 */
public interface HomeConstract {
    //IHomeView
    interface IHomeView{

        void getPreData(String data);
    }
    //IHomeModel
    interface IHomeModel{
        void getRequest(ModelCallBack modelCallBack);
        interface ModelCallBack{
            void onSuccess(String result);

            void onError();
        }
    }

    //IHomePresenter
    interface IHomePresenter{
        void accth(MainActivity mainActivity);

        void decth();

        void getmodel();
    };
}
