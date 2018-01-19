package com.bnkk.padcburpplefoodplaces;

import android.app.Application;

import com.bnkk.padcburpplefoodplaces.data.models.BurppleModel;

/**
 * Created by E5-575G on 1/5/2018.
 */

public class BfpApp extends Application {

    public static final String LOG_TAG = "BfpApp";


    @Override
    public void onCreate() {
        super.onCreate();
        BurppleModel.getObjInstance().startLoadingFeatured();
        BurppleModel.getObjInstance().startLoadingPromotions();
        BurppleModel.getObjInstance().startLoadingGuides();
    }
}
