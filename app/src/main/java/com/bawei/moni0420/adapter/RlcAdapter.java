package com.bawei.moni0420.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.moni0420.HelpActivity;
import com.bawei.moni0420.R;
import com.bawei.moni0420.bean.ShopBean;

/**
 * Project_Name: Moni0420
 * Time: 2019/4/20
 * Data: 晚么
 * Description:多条目适配器
 */
public class RlcAdapter extends RecyclerView.Adapter {
    private Context context;
    private ShopBean.ResultBean shopBeanResult;

    private int TypeRxxp=0;
    private int TypePzsh=1;
    private int TypeMlss=2;
    private int itemViewType;
    private View inflaterxxp;
    private View inflatepzsh;
    private View inflatemlss;
    private int viewHolderItemViewType;
    private ShopBean.ResultBean.RxxpBean rxxpBean;
    private RxxpAdapter rxxpAdapter;
    private ShopBean.ResultBean.PzshBean pzshBean;
    private ShopBean.ResultBean.MlssBean mlssBean;


    public RlcAdapter(Context context, ShopBean.ResultBean shopBeanResult) {
        this.context = context;
        this.shopBeanResult = shopBeanResult;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        itemViewType = getItemViewType(i);
        if (itemViewType==TypeRxxp){
            inflaterxxp = LayoutInflater.from(context).inflate(R.layout.rxxp, viewGroup, false);
            return new ViewHolderRxxp(inflaterxxp);
        }else if (itemViewType==TypePzsh){
            inflatepzsh = LayoutInflater.from(context).inflate(R.layout.pzsh, viewGroup, false);
            return new ViewHolderPzsh(inflatepzsh);
        }else{
            inflatemlss = LayoutInflater.from(context).inflate(R.layout.mlss, viewGroup, false);
            return new ViewHolderMlss(inflatemlss);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        viewHolderItemViewType = viewHolder.getItemViewType();
        if (viewHolderItemViewType==TypeRxxp){
            ViewHolderRxxp viewHolderRxxp= (ViewHolderRxxp) viewHolder;
            rxxpBean = shopBeanResult.getRxxp();
            viewHolderRxxp.shop_title.setText(shopBeanResult.getRxxp().getName());
            //设置布局管理器
            LinearLayoutManager rxxpManager = new LinearLayoutManager(context);
            rxxpManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            viewHolderRxxp.rc.setLayoutManager(rxxpManager);
            //添加布局管理器
            rxxpAdapter = new RxxpAdapter(context, rxxpBean);
            viewHolderRxxp.rc.setAdapter(rxxpAdapter);

            //点击条目跳转
            rxxpAdapter.setRxxpClick(new RxxpAdapter.setClick() {
                @Override
                public void Onclick(int i) {
                    Intent intent = new Intent(context, HelpActivity.class);
                    context.startActivity(intent);
                    Toast.makeText(context,"点击我"+i,Toast.LENGTH_SHORT).show();
                }
            });


        }else if (viewHolderItemViewType==TypePzsh){
            ViewHolderPzsh viewHolderPzsh= (ViewHolderPzsh) viewHolder;
            pzshBean = shopBeanResult.getPzsh();
            viewHolderPzsh.shop_title.setText(shopBeanResult.getPzsh().getName());
            //设置布局管理器
            LinearLayoutManager pzshManager = new LinearLayoutManager(context);
            pzshManager.setOrientation(LinearLayoutManager.VERTICAL);
            //添加布局管理
            viewHolderPzsh.rc.setLayoutManager(pzshManager);

            PzshAdapter pzshAdapter = new PzshAdapter(context, pzshBean);
            viewHolderPzsh.rc.setAdapter(pzshAdapter);
        }else{
            ViewHolderMlss viewHolderMlss= (ViewHolderMlss) viewHolder;
            mlssBean = shopBeanResult.getMlss();
            viewHolderMlss.shop_title.setText(shopBeanResult.getMlss().getName());
            //添加布局管理器
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            viewHolderMlss.rc.setLayoutManager(gridLayoutManager);
            //设置适配器
            MlssAdapter mlssAdapter = new MlssAdapter(context, mlssBean);
            viewHolderMlss.rc.setAdapter(mlssAdapter);
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return TypeRxxp;
        }else if(position==1){
            return TypePzsh;
        }else{
            return TypeMlss;
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolderRxxp extends RecyclerView.ViewHolder {

        private final TextView shop_title;
        private final RecyclerView rc;

        public ViewHolderRxxp(@NonNull View itemView) {
            super(itemView);
            shop_title = itemView.findViewById(R.id.shop_title);
            rc = itemView.findViewById(R.id.rc);
        }
    }
    public class ViewHolderPzsh extends RecyclerView.ViewHolder {

        private final TextView shop_title;
        private final RecyclerView rc;

        public ViewHolderPzsh(@NonNull View itemView) {
            super(itemView);
            shop_title = itemView.findViewById(R.id.shop_title);
            rc = itemView.findViewById(R.id.rc);
        }
    }
    public class ViewHolderMlss extends RecyclerView.ViewHolder {

        private final TextView shop_title;
        private final RecyclerView rc;

        public ViewHolderMlss(@NonNull View itemView) {
            super(itemView);
            shop_title = itemView.findViewById(R.id.shop_title);
            rc = itemView.findViewById(R.id.rc);
        }
    }
}
