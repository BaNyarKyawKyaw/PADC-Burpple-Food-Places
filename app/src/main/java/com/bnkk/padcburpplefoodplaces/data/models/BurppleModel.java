package com.bnkk.padcburpplefoodplaces.data.models;

import com.bnkk.padcburpplefoodplaces.data.vos.FeaturedVO;
import com.bnkk.padcburpplefoodplaces.data.vos.GuidesVO;
import com.bnkk.padcburpplefoodplaces.data.vos.PromotionsVO;
import com.bnkk.padcburpplefoodplaces.events.RestApiEvent;
import com.bnkk.padcburpplefoodplaces.network.BurppleDataAgent;
import com.bnkk.padcburpplefoodplaces.network.BurppleDataAgentImpl;
import com.bnkk.padcburpplefoodplaces.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by E5-575G on 1/18/2018.
 */

public class BurppleModel {

    private static BurppleModel sObjInstance;

    private BurppleDataAgent mDataAgent;

    private List<FeaturedVO> mFeatured;
    private List<PromotionsVO> mPromotions;
    private List<GuidesVO> mGuides;

    private int mFeaturedPageIndex = 1;
    private int mPromotionsPageIndex = 1;
    private int mGuidesPageIndex = 1;

    private BurppleModel() {
        mDataAgent = BurppleDataAgentImpl.getObjectInstance();

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    public static BurppleModel getObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new BurppleModel();
        }

        return sObjInstance;
    }

    public void startLoadingFeatured() {
        mDataAgent.loadFeatured(AppConstants.ACCESS_TOKEN,
                mFeaturedPageIndex);
    }

    public void loadMoreFeatured() {
        mDataAgent.loadFeatured(AppConstants.ACCESS_TOKEN,
                mFeaturedPageIndex + 1);
    }

    public List<FeaturedVO> getFeatured() {
        return mFeatured;
    }

    public void startLoadingPromotions() {
        mDataAgent.loadPromotions(AppConstants.ACCESS_TOKEN,
                mPromotionsPageIndex);
    }

    public void loadMorePromotions() {
        mDataAgent.loadPromotions(AppConstants.ACCESS_TOKEN,
                mPromotionsPageIndex + 1);
    }

    public List<PromotionsVO> getPromotions() {
        return mPromotions;
    }

    public void startLoadingGuides() {
        mDataAgent.loadGuides(AppConstants.ACCESS_TOKEN,
                mGuidesPageIndex);
    }

    public void loadMoreGuides() {
        mDataAgent.loadGuides(AppConstants.ACCESS_TOKEN,
                mGuidesPageIndex + 1);
    }

    public List<GuidesVO> getGuides() {
        return mGuides;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onFeaturedLoaded(RestApiEvent.FeaturedLoadedEvent event) {
        mFeatured.addAll(event.getLoadFeatured());
        mFeaturedPageIndex = event.getLoadedPageIndex() + 1;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onPromotionsLoaded(RestApiEvent.PromotionsLoadedEvent event) {
        mPromotions.addAll(event.getLoadPromotions());
        mPromotionsPageIndex = event.getLoadedPageIndex() + 1;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onGuidesLoaded(RestApiEvent.GuidesLoadedEvent event) {
        mGuides.addAll(event.getLoadGuides());
        mGuidesPageIndex = event.getLoadedPageIndex() + 1;
    }
}
