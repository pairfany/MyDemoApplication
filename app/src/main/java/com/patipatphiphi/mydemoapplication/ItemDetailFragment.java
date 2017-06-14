package com.patipatphiphi.mydemoapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ItemDetailFragment extends Fragment {

    @BindView(R.id.img_product)
    ImageView imgProduct;
    @BindView(R.id.tv_name_product)
    TextView tvNameProduct;
    @BindView(R.id.tv_price_product)
    TextView tvPriceProduct;
    Unbinder unbinder;
    private ShopItem shopItem;
    private Context mContext;

    // TODO: Rename and change types and number of parameters
    public static ItemDetailFragment newInstance(ShopItem shopItem) {
        ItemDetailFragment fragment = new ItemDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("ShopItem", shopItem);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restoreFromBundle(savedInstanceState);
    }
    private void restoreFromBundle(Bundle saveInstanceState) {
        if (saveInstanceState != null) {
            shopItem = saveInstanceState.getParcelable("ShopItem");
        } else {
            shopItem = getArguments().getParcelable("ShopItem");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        mContext = getActivity();
        initView();
        return view;
    }
    private void initView(){
        imgProduct.setBackground(ContextCompat.getDrawable(mContext,shopItem.getImg()));
        tvNameProduct.setText(shopItem.getName());
        tvPriceProduct.setText(shopItem.getPrice());
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
