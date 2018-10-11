package com.bnkk.padcburpplefoodplaces.persistence;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import com.bnkk.padcburpplefoodplaces.BurppleApp;

/**
 * Created by E5-575G on 1/19/2018.
 */

public class BurppleContract {

    public static final String CONTENT_AUTHORITY = BurppleApp.class.getPackage().getName();
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_FEATURED = "featured";
    public static final String PATH_PROMOTIONS = "promotions";
    public static final String PATH_PROMOTIONS_TERMS = "promotions_terms";
    public static final String PATH_GUIDES = "guides";
    public static final String PATH_SHOP = "shop";

    public static class FeatruredEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_FEATURED).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FEATURED;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FEATURED;

        public static final String TABLE_NAME = PATH_FEATURED;

        public static final String COLUMN_FEATURED_ID = "featured_id";
        public static final String COLUMN_FEATURED_IMAGE = "featured_image";
        public static final String COLUMN_FEATURED_TITLE = "featured_title";
        public static final String COLUMN_FEATURED_DESC = "featured_desc";
        public static final String COLUMN_FEATURED_TAG = "featured_tag";

        public static Uri buildContentUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static class PromotionsEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PROMOTIONS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROMOTIONS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROMOTIONS;

        public static final String TABLE_NAME = PATH_PROMOTIONS;

        public static final String COLUMN_PROMOTION_ID = "promotion_id";
        public static final String COLUMN_PROMOTION_IMAGE = "promotion_image";
        public static final String COLUMN_PROMOITON_TITLE = "promotion_title";
        public static final String COLUMN_PROMOTION_UNTIL = "promotion_until";
        public static final String COLUMN_PROMOTION_SHOP_ID = "promotion_shop_id";
        public static final String COLUMN_PROMOTION_EXCLUSIVE = "promotion_exclusive";

        public static Uri buildContentUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static class PromotionTermsEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PROMOTIONS_TERMS).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROMOTIONS_TERMS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROMOTIONS_TERMS;

        public static final String TABLE_NAME = PATH_PROMOTIONS_TERMS;

        public static final String COLUMN_PROMOTION_ID = "promotion_id";
        public static final String COLUMN_PROMOTION_TERMS = "promotion_terms";

        public static Uri buildContentUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static class GuidesEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_GUIDES).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GUIDES;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GUIDES;

        public static final String TABLE_NAME = PATH_GUIDES;

        public static final String COLUMN_GUIDE_ID = "guide_id";
        public static final String COLUMN_GUIDE_IMAGE = "guide_image";
        public static final String COLUMN_GUIDE_TITLE = "guide_title";
        public static final String COLUMN_GUIDE_DESC = "guide_desc";

        public static Uri buildContentUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static class ShopEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_SHOP).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHOP;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHOP;

        public static final String TABLE_NAME = PATH_SHOP;

        public static final String COLUMN_SHOP_ID = "shop_id";
        public static final String COLUMN_SHOP_NAME = "shop_name";
        public static final String COLUMN_SHOP_AREA = "shop_area";

        public static Uri buildContentUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
