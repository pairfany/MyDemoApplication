package com.patipatphiphi.mydemoapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by patipat_phi on 6/13/2017 AD.
 */

public class ShopItem implements Parcelable{
    private String name;
    private String price;
    private int img;

    public ShopItem(String name,String price,int img){
            this.name = name;
            this.price = price;
            this.img = img;
    }

    protected ShopItem(Parcel in) {
        name = in.readString();
        price = in.readString();
        img = in.readInt();
    }

    public static final Creator<ShopItem> CREATOR = new Creator<ShopItem>() {
        @Override
        public ShopItem createFromParcel(Parcel in) {
            return new ShopItem(in);
        }

        @Override
        public ShopItem[] newArray(int size) {
            return new ShopItem[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(price);
        dest.writeInt(img);
    }
}
