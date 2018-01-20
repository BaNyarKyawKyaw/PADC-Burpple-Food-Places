package com.bnkk.padcburpplefoodplaces.dagger;

import android.content.Context;

import com.bnkk.padcburpplefoodplaces.BfpApp;
import com.bnkk.padcburpplefoodplaces.data.models.BurppleModel;
import com.bnkk.padcburpplefoodplaces.mvp.presenters.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by E5-575G on 1/20/2018.
 */

@Module
public class AppModule {

    private BfpApp mApp;

    public AppModule(BfpApp application) {
        mApp = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mApp.getApplicationContext();
    }

    @Provides
    @Singleton
    public BurppleModel provideBurppleModel(Context context) {
        return new BurppleModel(context);
    }

    @Provides
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }
}
