package com.patipatphiphi.mydemoapplication;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by patipat_phi on 6/13/2017 AD.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    TextView tvPriceItem;
    private List<ShopItem> shopItemList;
    private Context mContext;
    private SecondActivity activity;

    public ItemAdapter(Context mContext, List<ShopItem> shopItemList, SecondActivity activity) {
        this.mContext = mContext;
        this.shopItemList = shopItemList;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ShopItem shopItem = shopItemList.get(position);
        holder.imgItem.setBackground(ContextCompat.getDrawable(mContext, shopItem.getImg()));
        holder.tvNameItem.setText(shopItem.getName());
        holder.tvPriceItem.setText(shopItem.getPrice());
        holder.tvPriceItem.setText(shopItem.getPrice());
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.nevigateToItemDetail(shopItem);
            }
        });
    }


    @Override
    public int getItemCount() {
        return shopItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_item)
        ImageView imgItem;
        @BindView(R.id.tv_name_item)
        TextView tvNameItem;
        @BindView(R.id.tv_price_item)
        TextView tvPriceItem;
        @BindView(R.id.item_layout)
        LinearLayout itemLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
