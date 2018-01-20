package com.bnkk.padcburpplefoodplaces.dagger;

import com.bnkk.padcburpplefoodplaces.network.BurppleDataAgent;
import com.bnkk.padcburpplefoodplaces.network.BurppleDataAgentImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by E5-575G on 1/20/2018.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public BurppleDataAgent provideBurppleDataAgent() {
        return new BurppleDataAgentImpl();
    }
}
