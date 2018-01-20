package com.bnkk.padcburpplefoodplaces.data.vos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.bnkk.padcburpplefoodplaces.persistence.BurppleContract;
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

    public ContentValues parseToContentValues() {
        ContentValues contentValues = new ContentValues();

        contentValues.put(BurppleContract.PromotionsEntry.COLUMN_PROMOTION_ID, burpplePromotionId);
        contentValues.put(BurppleContract.PromotionsEntry.COLUMN_PROMOTION_IMAGE, burpplePromotionImage);
        contentValues.put(BurppleContract.PromotionsEntry.COLUMN_PROMOITON_TITLE, burpplePromotionTitle);
        contentValues.put(BurppleContract.PromotionsEntry.COLUMN_PROMOTION_UNTIL, burpplePromotionUntil);
        contentValues.put(BurppleContract.PromotionsEntry.COLUMN_PROMOTION_SHOP_ID, burpplePromotionShop.getBurppleShopId());
        contentValues.put(BurppleContract.PromotionsEntry.COLUMN_PROMOTION_EXCLUSIVE, isBurppleExclusive);

        return contentValues;
    }

    public static PromotionsVO parseFromCursor(Context context, Cursor cursor) {
        PromotionsVO promotions = new PromotionsVO();

        promotions.burpplePromotionId = cursor.getString(cursor.getColumnIndex(BurppleContract.PromotionsEntry.COLUMN_PROMOTION_ID));
        promotions.burpplePromotionImage = cursor.getString(cursor.getColumnIndex(BurppleContract.PromotionsEntry.COLUMN_PROMOTION_IMAGE));
        promotions.burpplePromotionTitle = cursor.getString(cursor.getColumnIndex(BurppleContract.PromotionsEntry.COLUMN_PROMOITON_TITLE));
        promotions.burpplePromotionUntil = cursor.getString(cursor.getColumnIndex(BurppleContract.PromotionsEntry.COLUMN_PROMOTION_UNTIL));
        promotions.isBurppleExclusive = cursor.getColumnIndex(BurppleContract.PromotionsEntry.COLUMN_PROMOTION_EXCLUSIVE) == 1;

        promotions.burpplePromotionShop = ShopVO.parseFromCursor(cursor);
        promotions.burpplePromotionTerms = loadPromotionTermsInPromotions(context, promotions.burpplePromotionId);

        return promotions;
    }

    private static List<String> loadPromotionTermsInPromotions(Context context, String promotionId) {
        Cursor promotionTermsInPromotionsCursor = context.getContentResolver().query(BurppleContract.PromotionTermsEntry.CONTENT_URI,
                null,
                BurppleContract.PromotionTermsEntry.COLUMN_PROMOTION_ID + " = ?", new String[]{promotionId},
                null);

        if (promotionTermsInPromotionsCursor != null && promotionTermsInPromotionsCursor.moveToFirst()) {
            List<String> promotionTermsInPromotions = new ArrayList<>();
            do {
                promotionTermsInPromotions.add(
                        promotionTermsInPromotionsCursor.getString(
                                promotionTermsInPromotionsCursor.getColumnIndex(BurppleContract.PromotionTermsEntry.COLUMN_PROMOTION_TERMS)));
            } while (promotionTermsInPromotionsCursor.moveToNext());
            promotionTermsInPromotionsCursor.close();
            return promotionTermsInPromotions;
        }
        return null;
    }
}
