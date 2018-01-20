package com.bnkk.padcburpplefoodplaces.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by E5-575G on 1/19/2018.
 */

public class BurppleDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "burpple.db";
    private static final int DB_VERSION = 1;

    private static final String SQL_CREATE_FEATURED = "CREATE TABLE " + BurppleContract.FeatruredEntry.TABLE_NAME + " (" +
            BurppleContract.FeatruredEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            BurppleContract.FeatruredEntry.COLUMN_FEATURED_ID + " VARCHAR(5), " +
            BurppleContract.FeatruredEntry.COLUMN_FEATURED_IMAGE + " TEXT, " +
            BurppleContract.FeatruredEntry.COLUMN_FEATURED_TITLE + " TEXT, " +
            BurppleContract.FeatruredEntry.COLUMN_FEATURED_DESC + " TEXT, " +
            BurppleContract.FeatruredEntry.COLUMN_FEATURED_TAG + " TEXT, " +

            " UNIQUE (" + BurppleContract.FeatruredEntry.COLUMN_FEATURED_ID + ") ON CONFLICT REPLACE" +
            ");";

    private static final String SQL_CREATE_PROMOTIONS = "CREATE TABLE " + BurppleContract.PromotionsEntry.TABLE_NAME + " (" +
            BurppleContract.PromotionsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            BurppleContract.PromotionsEntry.COLUMN_PROMOTION_ID + " VARCHAR(5), " +
            BurppleContract.PromotionsEntry.COLUMN_PROMOTION_IMAGE + " TEXT, " +
            BurppleContract.PromotionsEntry.COLUMN_PROMOITON_TITLE + " TEXT, " +
            BurppleContract.PromotionsEntry.COLUMN_PROMOTION_UNTIL + " TEXT, " +
            BurppleContract.PromotionsEntry.COLUMN_PROMOTION_SHOP_ID + " VARCHAR(5), " +
            BurppleContract.PromotionsEntry.COLUMN_PROMOTION_EXCLUSIVE + " BOOLEAN, " +

            " UNIQUE (" + BurppleContract.PromotionsEntry.COLUMN_PROMOTION_ID + ") ON CONFLICT REPLACE" +
            ");";

    private static final String SQL_CREATE_PROMOTION_TERMS = "CREATE TABLE " + BurppleContract.PromotionTermsEntry.TABLE_NAME + " (" +
            BurppleContract.PromotionTermsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            BurppleContract.PromotionTermsEntry.COLUMN_PROMOTION_ID + " VARCHAR(5), " +
            BurppleContract.PromotionTermsEntry.COLUMN_PROMOTION_TERMS + " TEXT, " +

            " UNIQUE (" + BurppleContract.PromotionTermsEntry.COLUMN_PROMOTION_TERMS + ") ON CONFLICT REPLACE" +
            ");";

    private static final String SQL_CREATE_GUIDES = "CREATE TABLE " + BurppleContract.GuidesEntry.TABLE_NAME + " (" +
            BurppleContract.GuidesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            BurppleContract.GuidesEntry.COLUMN_GUIDE_ID + " VARCHAR(5), " +
            BurppleContract.GuidesEntry.COLUMN_GUIDE_IMAGE + " TEXT, " +
            BurppleContract.GuidesEntry.COLUMN_GUIDE_TITLE + " TEXT, " +
            BurppleContract.GuidesEntry.COLUMN_GUIDE_DESC + " TEXT, " +

            " UNIQUE (" + BurppleContract.GuidesEntry.COLUMN_GUIDE_ID + ") ON CONFLICT REPLACE" +
            ");";

    private static final String SQL_CREATE_SHOP = "CREATE TABLE " + BurppleContract.ShopEntry.TABLE_NAME + " (" +
            BurppleContract.ShopEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            BurppleContract.ShopEntry.COLUMN_SHOP_ID + " VARCHAR(5), " +
            BurppleContract.ShopEntry.COLUMN_SHOP_NAME + " TEXT, " +
            BurppleContract.ShopEntry.COLUMN_SHOP_AREA + " TEXT, " +

            " UNIQUE (" + BurppleContract.ShopEntry.COLUMN_SHOP_ID + ") ON CONFLICT REPLACE" +
            ");";

    public BurppleDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_FEATURED);
        db.execSQL(SQL_CREATE_PROMOTIONS);
        db.execSQL(SQL_CREATE_PROMOTION_TERMS);
        db.execSQL(SQL_CREATE_GUIDES);
        db.execSQL(SQL_CREATE_SHOP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + BurppleContract.FeatruredEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BurppleContract.PromotionsEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BurppleContract.PromotionTermsEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BurppleContract.GuidesEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BurppleContract.ShopEntry.TABLE_NAME);

        onCreate(db);
    }
}
