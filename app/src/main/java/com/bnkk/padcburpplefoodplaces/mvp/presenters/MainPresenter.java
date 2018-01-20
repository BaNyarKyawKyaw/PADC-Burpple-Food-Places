package com.bnkk.padcburpplefoodplaces.mvp.presenters;

import android.content.Context;
import android.database.Cursor;

import com.bnkk.padcburpplefoodplaces.BfpApp;
import com.bnkk.padcburpplefoodplaces.data.models.BurppleModel;
import com.bnkk.padcburpplefoodplaces.data.vos.FeaturedVO;
import com.bnkk.padcburpplefoodplaces.data.vos.GuidesVO;
import com.bnkk.padcburpplefoodplaces.data.vos.PromotionsVO;
import com.bnkk.padcburpplefoodplaces.mvp.views.MainView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by E5-575G on 1/20/2018.
 */

public class MainPresenter extends BasePresenter<MainView> {

    @Inject
    BurppleModel mModel;

    private static final int PROMOTION_LOADER = 1000;
    private static final int FEATURED_LOADER = 2000;
    private static final int GUIDES_LOADER = 3000;

    @Override
    public void onCreate(MainView view) {
        super.onCreate(view);
        BfpApp bfpApp = (BfpApp) mView.getContext();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public void onPromotionListEndReach(Context context) {
        mModel.loadMorePromotions(context);
    }

    public void onGuidesListEndReach(Context context) {
        mModel.loadMoreGuides(context);
    }

    public void onDataLoaded(Context context, Cursor data, android.support.v4.content.Loader<Cursor> loader) {

        if (loader.getId() == PROMOTION_LOADER) {
            if (data != null && data.moveToFirst()) {

                List<PromotionsVO> promotionsList = new ArrayList<>();
                do {
                    PromotionsVO promotions = PromotionsVO.parseFromCursor(context, data);
                    promotionsList.add(promotions);
                } while (data.moveToNext());

                mView.displayPromotion(promotionsList);
            } else {
                mModel.startLoadingPromotions(context);
            }
        }

        if (loader.getId() == GUIDES_LOADER) {
            if (data != null && data.moveToFirst()) {

                List<GuidesVO> guidesList = new ArrayList<>();
                do {
                    GuidesVO promotions = GuidesVO.parseFromCursor(data);
                    guidesList.add(promotions);
                } while (data.moveToNext());

                mView.displayGuides(guidesList);
            } else {
                mModel.startLoadingGuides(context);
            }
        }

        if (loader.getId() == FEATURED_LOADER) {
            if (data != null && data.moveToFirst()) {

                List<FeaturedVO> featuredList = new ArrayList<>();
                do {
                    FeaturedVO featured = FeaturedVO.parseFromCursor(data);
                    featuredList.add(featured);
                } while (data.moveToNext());

                mView.displayFeatured(featuredList);
            } else {
                mModel.startLoadingFeatured(context);
            }
        }
    }
}
