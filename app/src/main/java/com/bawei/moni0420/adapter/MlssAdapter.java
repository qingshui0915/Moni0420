package com.bawei.moni0420.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.moni0420.R;
import com.bawei.moni0420.bean.ShopBean;
import com.bumptech.glide.Glide;

/**
 * Project_Name: Moni0420
 * Time: 2019/4/20
 * Data: 晚么
 * Description:
 */
public class MlssAdapter extends RecyclerView.Adapter<MlssAdapter.ViewHolder> {
    private Context context;
    private ShopBean.ResultBean.MlssBean mlssBean;
    private ShopBean.ResultBean.MlssBean.CommodityListBeanXX commodityListBeanXX;

    public MlssAdapter(Context context, ShopBean.ResultBean.MlssBean mlssBean) {
        this.context = context;
        this.mlssBean = mlssBean;
    }

    @NonNull
    @Override
    public MlssAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mlss_item, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MlssAdapter.ViewHolder viewHolder, int i) {
        commodityListBeanXX = mlssBean.getCommodityList().get(i);
        Glide.with(context).load(commodityListBeanXX.getMasterPic()).into(viewHolder.imageView);
        viewHolder.ntv.setText(commodityListBeanXX.getCommodityName());
        viewHolder.ptv.setText("￥"+commodityListBeanXX.getPrice()+"元");


    }

    @Override
    public int getItemCount() {
        return mlssBean.getCommodityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView ntv;
        private final TextView ptv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.shop_mlss_im);
            ntv = itemView.findViewById(R.id.shop_mlss_ntv);
            ptv = itemView.findViewById(R.id.shop_mlss_ptv);
        }
    }
}
