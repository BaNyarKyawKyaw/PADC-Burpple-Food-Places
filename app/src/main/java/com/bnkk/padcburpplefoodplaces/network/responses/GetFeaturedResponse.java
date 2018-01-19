package com.bnkk.padcburpplefoodplaces.network.responses;

import com.bnkk.padcburpplefoodplaces.data.vos.FeaturedVO;
import com.bnkk.padcburpplefoodplaces.network.BurppleResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5-575G on 1/18/2018.
 */

public class GetFeaturedResponse extends BurppleResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int page;

    @SerializedName("featured")
    private List<FeaturedVO> featuredList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPage() {
        return page;
    }

    public List<FeaturedVO> getFeaturedList() {
        if (featuredList == null) {
            featuredList = new ArrayList<>();
        }

        return featuredList;
    }
}
