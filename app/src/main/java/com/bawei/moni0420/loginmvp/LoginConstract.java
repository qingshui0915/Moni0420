package com.bawei.moni0420.loginmvp;

import com.bawei.moni0420.LoginActivity;

/**
 * Project_Name: Moni0420
 * Time: 2019/4/20
 * Data: 晚么
 * Description:登录的契约类
 */
public interface LoginConstract {
    //ILoginView
    interface ILoginView{
        void getData(String data);
    }

    //ILoginModel
    interface ILoginModel{
        void Requester(String url,String username,String pwd,ModelCallBack modelCallBack);
        interface ModelCallBack{
            void onSuccess(String result);

            void onError();
        }
    }
    //ILoginPresenter
    interface ILoginPresenter{
        void accth(LoginActivity loginActivity);

        void decth();

        void getlogin(String url,String username,String pwd);
    }
}
