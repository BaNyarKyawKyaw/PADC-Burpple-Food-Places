package com.bnkk.padcburpplefoodplaces;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.bnkk.padcburpplefoodplaces.dagger.AppComponent;
import com.bnkk.padcburpplefoodplaces.dagger.AppModule;
import com.bnkk.padcburpplefoodplaces.dagger.DaggerAppComponent;
import com.bnkk.padcburpplefoodplaces.dagger.NetworkModule;
import com.bnkk.padcburpplefoodplaces.data.models.BurppleModel;

import javax.inject.Inject;

/**
 * Created by E5-575G on 1/5/2018.
 */

public class BfpApp extends Application {

    public static final String LOG_TAG = "BfpApp";

    private AppComponent mAppComponent;

    @Inject
    Context mContext;

    @Inject
    BurppleModel mModel;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = initDagger();
        mAppComponent.inject(this);

        Log.d(LOG_TAG, "mContext:" + mContext);

        mModel.startLoadingFeatured(getApplicationContext());
        mModel.startLoadingPromotions(getApplicationContext());
        mModel.startLoadingGuides(getApplicationContext());
    }

    private AppComponent initDagger() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
