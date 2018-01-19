package com.bnkk.padcburpplefoodplaces.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by E5-575G on 1/18/2018.
 */

public class ShopVO {

    @SerializedName("burpple-shop-id")
    private String burppleShopId;

    @SerializedName("burpple-shop-name")
    private String burppleShopName;

    @SerializedName("burpple-shop-area")
    private String burppleShopArea;

    public String getBurppleShopId() {
        return burppleShopId;
    }

    public String getBurppleShopName() {
        return burppleShopName;
    }

    public String getBurppleShopArea() {
        return burppleShopArea;
    }
}
