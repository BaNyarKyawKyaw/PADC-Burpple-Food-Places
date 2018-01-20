package com.bnkk.padcburpplefoodplaces.mvp.views;

import android.content.Context;

import com.bnkk.padcburpplefoodplaces.data.vos.FeaturedVO;
import com.bnkk.padcburpplefoodplaces.data.vos.GuidesVO;
import com.bnkk.padcburpplefoodplaces.data.vos.PromotionsVO;

import java.util.List;

/**
 * Created by E5-575G on 1/20/2018.
 */

public interface MainView {

    void displayFeatured(List<FeaturedVO> featuredList);

    void displayPromotion(List<PromotionsVO> promotionsList);

    void displayGuides(List<GuidesVO> guidesList);

    Context getContext();
}
