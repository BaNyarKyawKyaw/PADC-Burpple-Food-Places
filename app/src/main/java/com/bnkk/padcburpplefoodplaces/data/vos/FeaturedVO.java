package com.bnkk.padcburpplefoodplaces.data.vos;

import android.content.ContentValues;
import android.database.Cursor;

import com.bnkk.padcburpplefoodplaces.persistence.BurppleContract;
import com.google.gson.annotations.SerializedName;

/**
 * Created by E5-575G on 1/18/2018.
 */

public class FeaturedVO {

    @SerializedName("burpple-featured-id")
    private String burppleFeaturedId;

    @SerializedName("burpple-featured-image")
    private String burppleFeaturedImage;

    @SerializedName("burpple-featured-title")
    private String burppleFeaturedTitle;

    @SerializedName("burpple-featured-desc")
    private String burppleFeaturedDesc;

    @SerializedName("burpple-featured-tag")
    private String burppleFeaturedTag;

    public String getBurppleFeaturedId() {
        return burppleFeaturedId;
    }

    public String getBurppleFeaturedImage() {
        return burppleFeaturedImage;
    }

    public String getBurppleFeaturedTitle() {
        return burppleFeaturedTitle;
    }

    public String getBurppleFeaturedDesc() {
        return burppleFeaturedDesc;
    }

    public String getBurppleFeaturedTag() {
        return burppleFeaturedTag;
    }

    public ContentValues parseToContentValues() {
        ContentValues contentValues = new ContentValues();

        contentValues.put(BurppleContract.FeatruredEntry.COLUMN_FEATURED_ID, burppleFeaturedId);
        contentValues.put(BurppleContract.FeatruredEntry.COLUMN_FEATURED_IMAGE, burppleFeaturedImage);
        contentValues.put(BurppleContract.FeatruredEntry.COLUMN_FEATURED_TITLE, burppleFeaturedTitle);
        contentValues.put(BurppleContract.FeatruredEntry.COLUMN_FEATURED_DESC, burppleFeaturedDesc);
        contentValues.put(BurppleContract.FeatruredEntry.COLUMN_FEATURED_TAG, burppleFeaturedTag);

        return contentValues;
    }

    public static FeaturedVO parseFromCursor(Cursor cursor) {
        FeaturedVO featured = new FeaturedVO();

        featured.burppleFeaturedId = cursor.getString(cursor.getColumnIndex(BurppleContract.FeatruredEntry.COLUMN_FEATURED_ID));
        featured.burppleFeaturedImage = cursor.getString(cursor.getColumnIndex(BurppleContract.FeatruredEntry.COLUMN_FEATURED_IMAGE));
        featured.burppleFeaturedTitle = cursor.getString(cursor.getColumnIndex(BurppleContract.FeatruredEntry.COLUMN_FEATURED_TITLE));
        featured.burppleFeaturedDesc = cursor.getString(cursor.getColumnIndex(BurppleContract.FeatruredEntry.COLUMN_FEATURED_DESC));
        featured.burppleFeaturedTag = cursor.getString(cursor.getColumnIndex(BurppleContract.FeatruredEntry.COLUMN_FEATURED_TAG));

        return featured;
    }
}
