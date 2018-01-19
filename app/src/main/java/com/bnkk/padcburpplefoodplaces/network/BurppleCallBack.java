package com.bnkk.padcburpplefoodplaces.network;

import com.bnkk.padcburpplefoodplaces.events.RestApiEvent;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by E5-575G on 1/18/2018.
 */

public abstract class BurppleCallBack<T extends BurppleResponse> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        RestApiEvent.ErrorInvokingAPIEvent errorEvent = new RestApiEvent.ErrorInvokingAPIEvent(t.getMessage());
        EventBus.getDefault().post(errorEvent);
    }
}
