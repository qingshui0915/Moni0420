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
public class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.ViewHolder> {
    private Context context;
    private ShopBean.ResultBean.RxxpBean rxxpBean;
    private View inflate;
    private ShopBean.ResultBean.RxxpBean.CommodityListBean commodityListBean;

    setClick setonClick;
    public RxxpAdapter(Context context, ShopBean.ResultBean.RxxpBean rxxpBean) {
        this.context = context;
        this.rxxpBean = rxxpBean;
    }

    @NonNull
    @Override
    public RxxpAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = LayoutInflater.from(context).inflate(R.layout.rxxp_item, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RxxpAdapter.ViewHolder viewHolder, final int i) {
        commodityListBean = rxxpBean.getCommodityList().get(i);
        Glide.with(context).load(commodityListBean.getMasterPic()).into(viewHolder.imageView);
        viewHolder.ntv.setText(commodityListBean.getCommodityName());
        viewHolder.ptv.setText("￥"+commodityListBean.getPrice()+"元");

        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setonClick.Onclick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rxxpBean.getCommodityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView ntv,ptv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.shop_rxxp_im);
            ntv = itemView.findViewById(R.id.shop_rxxp_ntv);
            ptv = itemView.findViewById(R.id.shop_rxxp_ptv);
        }
    }


    //点击事件
    public void setRxxpClick(setClick setonClick){
        this.setonClick=setonClick;
    }
    public interface setClick{
        void Onclick(int i);
    }
}
