package com.bawei.moni0420.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

/**
 * Project_Name: Moni0420
 * Time: 2019/4/20
 * Data: 晚么
 * Description:
 */
public class XBannerImage extends SimpleBannerInfo{

   public String imgurl;
    @Override
    public Object getXBannerUrl() {
        return imgurl;
    }
}
