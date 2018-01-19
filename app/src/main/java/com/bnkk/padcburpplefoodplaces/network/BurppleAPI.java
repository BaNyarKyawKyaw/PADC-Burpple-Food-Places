package com.bnkk.padcburpplefoodplaces.network;

import com.bnkk.padcburpplefoodplaces.network.responses.GetFeaturedResponse;
import com.bnkk.padcburpplefoodplaces.network.responses.GetGuidesResponse;
import com.bnkk.padcburpplefoodplaces.network.responses.GetPromotionsResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by E5-575G on 1/18/2018.
 */

public interface BurppleAPI {

    @FormUrlEncoded
    @POST("v1/getFeatured.php")
    Call<GetFeaturedResponse> loadFeatured(
            @Field("access_token") String accessToken,
            @Field("page") int pageIndex);

    @FormUrlEncoded
    @POST("v1/getPromotions.php")
    Call<GetPromotionsResponse> loadPromotions(
            @Field("access_token") String accessToken,
            @Field("page") int pageIndex);

    @FormUrlEncoded
    @POST("v1/getGuides.php")
    Call<GetGuidesResponse> loadGuides(
            @Field("access_token") String accessToken,
            @Field("page") int pageIndex);
}
