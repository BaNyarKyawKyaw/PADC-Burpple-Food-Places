package com.bnkk.padcburpplefoodplaces.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5-575G on 1/18/2018.
 */

public class PromotionsVO {

    @SerializedName("burpple-promotion-id")
    private String burpplePromotionId;

    @SerializedName("burpple-promotion-image")
    private String burpplePromotionImage;

    @SerializedName("burpple-promotion-title")
    private String burpplePromotionTitle;

    @SerializedName("burpple-promotion-until")
    private String burpplePromotionUntil;

    @SerializedName("burpple-promotion-shop")
    private ShopVO burpplePromotionShop;

    @SerializedName("is-burpple-exclusive")
    private Boolean isBurppleExclusive;

    @SerializedName("burpple-promotion-terms")
    private List<String> burpplePromotionTerms;

    public String getBurpplePromotionId() {
        return burpplePromotionId;
    }

    public String getBurpplePromotionImage() {
        return burpplePromotionImage;
    }

    public String getBurpplePromotionTitle() {
        return burpplePromotionTitle;
    }

    public String getBurpplePromotionUntil() {
        return burpplePromotionUntil;
    }

    public ShopVO getBurpplePromotionShop() {
        return burpplePromotionShop;
    }

    public Boolean getBurppleExclusive() {
        return isBurppleExclusive;
    }

    public List<String> getBurpplePromotionTerms() {
        if (burpplePromotionTerms == null) {
            burpplePromotionTerms = new ArrayList<>();
        }

        return burpplePromotionTerms;
    }
}
