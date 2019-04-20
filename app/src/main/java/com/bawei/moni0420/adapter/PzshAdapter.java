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
public class PzshAdapter extends RecyclerView.Adapter<PzshAdapter.ViewHolder> {
    private Context context;
    private ShopBean.ResultBean.PzshBean pzshBean;
    private ShopBean.ResultBean.PzshBean.CommodityListBeanX commodityListBeanX;

    public PzshAdapter(Context context, ShopBean.ResultBean.PzshBean pzshBean) {
        this.context = context;
        this.pzshBean = pzshBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pzsh_item, viewGroup, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        commodityListBeanX = pzshBean.getCommodityList().get(i);
        Glide.with(context).load(commodityListBeanX.getMasterPic()).into(viewHolder.imageView);
        viewHolder.ntv.setText(commodityListBeanX.getCommodityName());
        viewHolder.ptv.setText("￥"+commodityListBeanX.getPrice()+"元");

    }

    @Override
    public int getItemCount() {
        return pzshBean.getCommodityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView ntv;
        private final TextView ptv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.shop_pzsh_im);
            ntv = itemView.findViewById(R.id.shop_pzsh_ntv);
            ptv = itemView.findViewById(R.id.shop_pzsh_ptv);
        }
    }
}
