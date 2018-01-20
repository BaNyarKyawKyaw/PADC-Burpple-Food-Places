package com.bnkk.padcburpplefoodplaces.data.vos;

import android.content.ContentValues;
import android.database.Cursor;

import com.bnkk.padcburpplefoodplaces.persistence.BurppleContract;
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

    public ContentValues parseToContentValues() {
        ContentValues contentValues = new ContentValues();

        contentValues.put(BurppleContract.ShopEntry.COLUMN_SHOP_ID, burppleShopId);
        contentValues.put(BurppleContract.ShopEntry.COLUMN_SHOP_NAME, burppleShopName);
        contentValues.put(BurppleContract.ShopEntry.COLUMN_SHOP_AREA, burppleShopArea);

        return contentValues;
    }

    public static ShopVO parseFromCursor(Cursor cursor) {
        ShopVO shop = new ShopVO();

        shop.burppleShopId = cursor.getString(cursor.getColumnIndex(BurppleContract.ShopEntry.COLUMN_SHOP_ID));
        shop.burppleShopName = cursor.getString(cursor.getColumnIndex(BurppleContract.ShopEntry.COLUMN_SHOP_NAME));
        shop.burppleShopArea = cursor.getString(cursor.getColumnIndex(BurppleContract.ShopEntry.COLUMN_SHOP_AREA));

        return shop;
    }
}
