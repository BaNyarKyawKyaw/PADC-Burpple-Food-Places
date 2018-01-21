package com.bnkk.padcburpplefoodplaces.network.responses;

import com.bnkk.padcburpplefoodplaces.data.vos.PromotionsVO;
import com.bnkk.padcburpplefoodplaces.network.BurppleResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5-575G on 1/18/2018.
 */

public class GetPromotionsResponse extends BurppleResponse {

    @SerializedName("promotions")
    private List<PromotionsVO> promotionsList;

    public List<PromotionsVO> getPromotionsList() {
        if (promotionsList == null) {
            promotionsList = new ArrayList<>();
        }

        return promotionsList;
    }
}
