package com.patipatphiphi.mydemoapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by patipat_phi on 6/12/2017 AD.
 */

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.tv_welcome)
    TextView tvWelcome;
    @BindView(R.id.rv_list_item)
    RecyclerView rvListItem;
    @BindView(R.id.item_detail_frament)
    FrameLayout itemDetailFrament;

    private String user;
    private ShopItem shopItem;
    private List<ShopItem> shopItemList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main_activity);
        ButterKnife.bind(this);
        user = getIntent().getStringExtra("user");
        initShopItem();
        initView();
    }

    private void initShopItem() {
        shopItemList = new ArrayList<>();
        shopItemList.add(new ShopItem("Ball", "100", R.mipmap.ic_launcher));
        shopItemList.add(new ShopItem("Pencil", "5", R.mipmap.ic_launcher));
        shopItemList.add(new ShopItem("Pen", "15", R.mipmap.ic_launcher));
        shopItemList.add(new ShopItem("Paper", "30", R.mipmap.ic_launcher));
        shopItemList.add(new ShopItem("Ink", "10", R.mipmap.ic_launcher));
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvListItem.setLayoutManager(linearLayoutManager);
        ItemAdapter itemAdapter = new ItemAdapter(this, shopItemList,SecondActivity.this);
        rvListItem.setAdapter(itemAdapter);
    }
    public  void nevigateToItemDetail(ShopItem shopItem){
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                                      .replace(itemDetailFrament.getId(),ItemDetailFragment.newInstance(shopItem),"ItemDetailFragment")
                                                      .addToBackStack(null).commit();
    }
}
