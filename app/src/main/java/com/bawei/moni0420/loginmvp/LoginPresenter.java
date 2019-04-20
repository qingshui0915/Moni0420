package com.bawei.moni0420.loginmvp;

import com.bawei.moni0420.LoginActivity;

/**
 * Project_Name: Moni0420
 * Time: 2019/4/20
 * Data: 晚么
 * Description:
 */
public class LoginPresenter implements LoginConstract.ILoginPresenter {

    private LoginModel loginModel;
    private LoginActivity iloginview;


    @Override
    public void accth(LoginActivity loginActivity) {
        this.iloginview=loginActivity;
        loginModel = new LoginModel();
    }

    @Override
    public void decth() {
        if (iloginview!=null){
            iloginview=null;
        }
        if (loginModel!=null){
            loginModel=null;
        }
        System.gc();

    }

    @Override
    public void getlogin(String url, String username, String pwd) {
        loginModel.Requester(url, username, pwd, new LoginConstract.ILoginModel.ModelCallBack() {
            @Override
            public void onSuccess(String result) {
                iloginview.getData(result);
            }

            @Override
            public void onError() {

            }
        });
    }

}
