package com.bawei.moni0420;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.bawei.moni0420.adapter.RlcAdapter;
import com.bawei.moni0420.bean.BannerBean;
import com.bawei.moni0420.bean.ShopBean;
import com.bawei.moni0420.bean.XBannerImage;
import com.bawei.moni0420.homemvp.HomeConstract;
import com.bawei.moni0420.homemvp.HomePresenter;
import com.bawei.moni0420.net.VolleyHttpClient;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeConstract.IHomeView {

    private HomePresenter homePresenter;
    private XBanner xBanner;
    private RecyclerView rlc;
    private ShopBean shopBean;
    private ShopBean.ResultBean shopBeanResult;
    private RlcAdapter rlcAdapter;
    public static final String XBnner_URL="http://172.17.8.100/small/commodity/v1/bannerShow";
    private BannerBean bannerBean;
    private List<XBannerImage> xBannerImageList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homePresenter = new HomePresenter();
        homePresenter.accth(this);

        rlc = findViewById(R.id.rlc);
        xBanner = findViewById(R.id.xbnner);


    }

    @Override
    public void getPreData(String data) {
        Gson gson = new Gson();
        shopBean = gson.fromJson(data, ShopBean.class);
        shopBeanResult = shopBean.getResult();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlc.setLayoutManager(linearLayoutManager);

        rlcAdapter = new RlcAdapter(this, shopBeanResult);
        rlc.setAdapter(rlcAdapter);
        rlc.setNestedScrollingEnabled(true);

        initData();

    }

    private void initData() {
        //Xbnner展示
        VolleyHttpClient.getInstance().getVolleyHttp(XBnner_URL, new VolleyHttpClient.VolleyCallBack() {
            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();
                bannerBean = gson.fromJson(result, BannerBean.class);

                if (xBannerImageList.size()<=0){
                    XBannerImage xBannerImage;
                    for (int i = 0; i <bannerBean.getResult().size() ; i++) {
                        xBannerImage= new XBannerImage();
                        xBannerImage.imgurl=bannerBean.getResult().get(i).getImageUrl();
                        xBannerImageList.add(xBannerImage);
                    }
                        xBanner.setBannerData(xBannerImageList);

                }else{
                    xBanner.setBannerData(xBannerImageList);
                }
                    xBanner.loadImage(new XBanner.XBannerAdapter() {
                        @Override
                        public void loadBanner(XBanner banner, Object model, View view, int position) {
                            Glide.with(MainActivity.this).load(((XBannerImage)model).imgurl).into((ImageView) view);
                        }
                    });


            }
            @Override
            public void onFail(VolleyError error) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        homePresenter.decth();

    }
}
