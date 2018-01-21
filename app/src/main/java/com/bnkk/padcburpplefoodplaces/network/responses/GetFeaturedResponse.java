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

    @SerializedName("featured")
    private List<FeaturedVO> featuredList;

    public List<FeaturedVO> getFeaturedList() {
        if (featuredList == null) {
            featuredList = new ArrayList<>();
        }

        return featuredList;
    }
}
