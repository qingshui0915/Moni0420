package com.bawei.moni0420.homemvp;

import com.bawei.moni0420.MainActivity;

/**
 * Project_Name: Moni0420
 * Time: 2019/4/20
 * Data: 晚么
 * Description:
 */
public class HomePresenter implements HomeConstract.IHomePresenter {
    private MainActivity ihomeview;
    private HomeModel homeModel;

    @Override
    public void accth(MainActivity mainActivity) {
        this.ihomeview=mainActivity;
        homeModel = new HomeModel();
        homeModel.getRequest(new HomeConstract.IHomeModel.ModelCallBack() {
            @Override
            public void onSuccess(String result) {
                ihomeview.getPreData(result);
            }

            @Override
            public void onError() {

            }
        });
    }
    @Override
    public void decth() {
        if (ihomeview!=null){
            ihomeview=null;
        }
        if (homeModel!=null){
            homeModel=null;
        }
        System.gc();

    }

    @Override
    public void getmodel() {

    }
}
