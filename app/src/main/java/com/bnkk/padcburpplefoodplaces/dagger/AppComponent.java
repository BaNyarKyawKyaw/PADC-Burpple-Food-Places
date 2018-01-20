package com.bnkk.padcburpplefoodplaces.dagger;

import com.bnkk.padcburpplefoodplaces.BfpApp;
import com.bnkk.padcburpplefoodplaces.activities.MainActivity;
import com.bnkk.padcburpplefoodplaces.data.models.BurppleModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by E5-575G on 1/20/2018.
 */

@Component(modules = {AppModule.class, NetworkModule.class})
@Singleton
public interface AppComponent {

    void inject(BfpApp bfpApp);

    void inject(BurppleModel burppleModel);

    void inject(MainActivity mainActivity);
}
