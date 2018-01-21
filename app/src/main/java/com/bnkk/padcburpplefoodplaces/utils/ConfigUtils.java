package com.bnkk.padcburpplefoodplaces.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by E5-575G on 1/20/2018.
 */

public class ConfigUtils {

    private static final String KEY_FEATURED_PAGE_INDEX = "KEY_FEATURED_PAGE_INDEX";
    private static final String KEY_PROMOTION_PAGE_INDEX = "KEY_PROMOTION_PAGE_INDEX";
    private static final String KEY_GUIDES_PAGE_INDEX = "KEY_GUIDES_PAGE_INDEX";

    private SharedPreferences mSharedPreferences;

    public ConfigUtils(Context context) {
        mSharedPreferences = context.getSharedPreferences("ConfigUtils", Context.MODE_PRIVATE);
    }

    public void saveFeaturedPageIndex(int pageIndex) {
        mSharedPreferences.edit().putInt(KEY_FEATURED_PAGE_INDEX, pageIndex).apply();
    }

    public int loadFeaturedPageIndex() {
        return mSharedPreferences.getInt(KEY_FEATURED_PAGE_INDEX, 1);
    }

    public void savePromotionPageIndex(int pageIndex) {
        mSharedPreferences.edit().putInt(KEY_PROMOTION_PAGE_INDEX, pageIndex).apply();
    }

    public int loadPromotionPageIndex() {
        return mSharedPreferences.getInt(KEY_PROMOTION_PAGE_INDEX, 1);
    }

    public void saveGuidesPageIndex(int pageIndex) {
        mSharedPreferences.edit().putInt(KEY_GUIDES_PAGE_INDEX, pageIndex).apply();
    }

    public int loadGuidesPageIndex() {
        return mSharedPreferences.getInt(KEY_GUIDES_PAGE_INDEX, 1);
    }
}
