package com.bnkk.padcburpplefoodplaces;

import android.app.Application;

import com.bnkk.padcburpplefoodplaces.dagger.AppComponent;
import com.bnkk.padcburpplefoodplaces.dagger.AppModule;
import com.bnkk.padcburpplefoodplaces.dagger.DaggerAppComponent;
import com.bnkk.padcburpplefoodplaces.dagger.NetworkModule;

/**
 * Created by E5-575G on 1/5/2018.
 */

public class BurppleApp extends Application {

    public static final String LOG_TAG = "BurppleApp";

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = initDagger();
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
