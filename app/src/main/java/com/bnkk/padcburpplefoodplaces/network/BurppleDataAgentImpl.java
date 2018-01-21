package com.bnkk.padcburpplefoodplaces.network;

import android.content.Context;

import com.bnkk.padcburpplefoodplaces.events.RestApiEvent;
import com.bnkk.padcburpplefoodplaces.network.responses.GetFeaturedResponse;
import com.bnkk.padcburpplefoodplaces.network.responses.GetGuidesResponse;
import com.bnkk.padcburpplefoodplaces.network.responses.GetPromotionsResponse;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by E5-575G on 1/18/2018.
 */

public class BurppleDataAgentImpl implements BurppleDataAgent {

    private BurppleAPI burppleAPI;

    public BurppleDataAgentImpl() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/burpple-food-places/apis/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        burppleAPI = retrofit.create(BurppleAPI.class);
    }

    @Override
    public void loadFeatured(String accessToken, int pageNo, final Context context) {
        Call<GetFeaturedResponse> loadFeaturedCall = burppleAPI.loadFeatured(accessToken, pageNo);
        loadFeaturedCall.enqueue(new BurppleCallBack<GetFeaturedResponse>() {
            @Override
            public void onResponse(Call<GetFeaturedResponse> call, Response<GetFeaturedResponse> response) {
                super.onResponse(call, response);
                GetFeaturedResponse getFeaturedResponse = response.body();
                if (getFeaturedResponse != null
                        && getFeaturedResponse.getFeaturedList().size() > 0) {
                    RestApiEvent.FeaturedLoadedEvent featuredLoadedEvent = new RestApiEvent.FeaturedLoadedEvent(
                            getFeaturedResponse.getPage(), getFeaturedResponse.getFeaturedList(), context);
                    EventBus.getDefault().post(featuredLoadedEvent);
                }
            }
        });
    }

    @Override
    public void loadPromotions(String accessToken, int pageNo, final Context context) {
        Call<GetPromotionsResponse> loadPromotionsCall = burppleAPI.loadPromotions(accessToken, pageNo);
        loadPromotionsCall.enqueue(new BurppleCallBack<GetPromotionsResponse>() {
            @Override
            public void onResponse(Call<GetPromotionsResponse> call, Response<GetPromotionsResponse> response) {
                super.onResponse(call, response);
                GetPromotionsResponse getPromotionsResponse = response.body();
                if (getPromotionsResponse != null
                        && getPromotionsResponse.getPromotionsList().size() > 0) {
                    RestApiEvent.PromotionsLoadedEvent promotionsLoadedEvent = new RestApiEvent.PromotionsLoadedEvent(
                            getPromotionsResponse.getPage(), getPromotionsResponse.getPromotionsList(), context);
                    EventBus.getDefault().post(promotionsLoadedEvent);
                }
            }
        });
    }

    @Override
    public void loadGuides(String accessToken, int pageNo, final Context context) {
        Call<GetGuidesResponse> loadGuidesCall = burppleAPI.loadGuides(accessToken, pageNo);
        loadGuidesCall.enqueue(new BurppleCallBack<GetGuidesResponse>() {
            @Override
            public void onResponse(Call<GetGuidesResponse> call, Response<GetGuidesResponse> response) {
                super.onResponse(call, response);
                GetGuidesResponse getGuidesResponse = response.body();
                if (getGuidesResponse != null
                        && getGuidesResponse.getGuidesList().size() > 0) {
                    RestApiEvent.GuidesLoadedEvent guidesLoadedEvent = new RestApiEvent.GuidesLoadedEvent(
                            getGuidesResponse.getPage(), getGuidesResponse.getGuidesList(), context);
                    EventBus.getDefault().post(guidesLoadedEvent);
                }
            }
        });
    }
}
