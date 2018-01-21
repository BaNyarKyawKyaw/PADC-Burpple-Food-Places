package com.bnkk.padcburpplefoodplaces.network.responses;

import com.bnkk.padcburpplefoodplaces.data.vos.GuidesVO;
import com.bnkk.padcburpplefoodplaces.network.BurppleResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5-575G on 1/18/2018.
 */

public class GetGuidesResponse extends BurppleResponse {

    @SerializedName("featured")
    private List<GuidesVO> guidesList;

    public List<GuidesVO> getGuidesList() {
        if (guidesList == null) {
            guidesList = new ArrayList<>();
        }

        return guidesList;
    }
}
