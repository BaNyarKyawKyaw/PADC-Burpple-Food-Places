package com.bnkk.padcburpplefoodplaces.data.models;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.bnkk.padcburpplefoodplaces.BfpApp;
import com.bnkk.padcburpplefoodplaces.data.vos.FeaturedVO;
import com.bnkk.padcburpplefoodplaces.data.vos.GuidesVO;
import com.bnkk.padcburpplefoodplaces.data.vos.PromotionsVO;
import com.bnkk.padcburpplefoodplaces.data.vos.ShopVO;
import com.bnkk.padcburpplefoodplaces.events.RestApiEvent;
import com.bnkk.padcburpplefoodplaces.network.BurppleDataAgent;
import com.bnkk.padcburpplefoodplaces.persistence.BurppleContract;
import com.bnkk.padcburpplefoodplaces.utils.AppConstants;
import com.bnkk.padcburpplefoodplaces.utils.ConfigUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by E5-575G on 1/18/2018.
 */

public class BurppleModel {

    @Inject
    BurppleDataAgent mDataAgent;

    @Inject
    ConfigUtils mConfigUtils;

    public BurppleModel(Context context) {
        EventBus.getDefault().register(this);

        BfpApp bfpApp = (BfpApp) context.getApplicationContext();
        bfpApp.getAppComponent().inject(this);
    }

    public void startLoadingFeatured(Context context) {
        mDataAgent.loadFeatured(AppConstants.ACCESS_TOKEN,
                mConfigUtils.loadFeaturedPageIndex(),
                context);
    }

    public void loadMoreFeatured(Context context) {
        mDataAgent.loadFeatured(AppConstants.ACCESS_TOKEN,
                mConfigUtils.loadFeaturedPageIndex() + 1,
                context);
    }

    public void startLoadingPromotions(Context context) {
        mDataAgent.loadPromotions(AppConstants.ACCESS_TOKEN,
                mConfigUtils.loadPromotionPageIndex(),
                context);
    }

    public void loadMorePromotions(Context context) {
        mDataAgent.loadPromotions(AppConstants.ACCESS_TOKEN,
                mConfigUtils.loadPromotionPageIndex() + 1,
                context);
    }

    public void startLoadingGuides(Context context) {
        mDataAgent.loadGuides(AppConstants.ACCESS_TOKEN,
                mConfigUtils.loadGuidesPageIndex(),
                context);
    }

    public void loadMoreGuides(Context context) {
        mDataAgent.loadGuides(AppConstants.ACCESS_TOKEN,
                mConfigUtils.loadGuidesPageIndex(),
                context);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onFeaturedLoaded(RestApiEvent.FeaturedLoadedEvent event) {

        mConfigUtils.saveFeaturedPageIndex(event.getLoadedPageIndex() + 1);

        //Logic for saving data in Persistence Layer
        ContentValues[] featuredCVs = new ContentValues[event.getLoadFeatured().size()];

        for (int index = 0; index < featuredCVs.length; index++) {
            FeaturedVO featureds = event.getLoadFeatured().get(index);
            featuredCVs[index] = featureds.parseToContentValues();
        }

        int insertedFeatured = event.getContext().getContentResolver().bulkInsert(BurppleContract.FeatruredEntry.CONTENT_URI,
                featuredCVs);
        Log.d(BfpApp.LOG_TAG, "insertedFeatured : " + insertedFeatured);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onPromotionsLoaded(RestApiEvent.PromotionsLoadedEvent event) {

        mConfigUtils.savePromotionPageIndex(event.getLoadedPageIndex() + 1);

        //Logic for saving data in Persistence Layer
        ContentValues[] promotionsCVs = new ContentValues[event.getLoadPromotions().size()];
        List<ContentValues> shopCVList = new ArrayList<>();
        List<ContentValues> promotionTermsCVList = new ArrayList<>();

        for (int index = 0; index < promotionsCVs.length; index++) {
            PromotionsVO promotions = event.getLoadPromotions().get(index);
            promotionsCVs[index] = promotions.parseToContentValues();

            ShopVO shop = promotions.getBurpplePromotionShop();
            shopCVList.add(shop.parseToContentValues());

            for (String promotionTerms : promotions.getBurpplePromotionTerms()) {
                ContentValues promotionTermsCV = new ContentValues();
                promotionTermsCV.put(BurppleContract.PromotionTermsEntry.COLUMN_PROMOTION_ID, promotions.getBurpplePromotionId());
                promotionTermsCV.put(BurppleContract.PromotionTermsEntry.COLUMN_PROMOTION_TERMS, promotionTerms);
                promotionTermsCVList.add(promotionTermsCV);
            }
        }

        int insertedShops = event.getContext().getContentResolver().bulkInsert(BurppleContract.ShopEntry.CONTENT_URI,
                shopCVList.toArray(new ContentValues[0]));
        Log.d(BfpApp.LOG_TAG, "insertedShops : " + insertedShops);

        int insertedPromotionTerms = event.getContext().getContentResolver().bulkInsert(BurppleContract.PromotionTermsEntry.CONTENT_URI,
                promotionTermsCVList.toArray(new ContentValues[0]));
        Log.d(BfpApp.LOG_TAG, "insertedPromotionTerms : " + insertedPromotionTerms);

        int insertedPromotions = event.getContext().getContentResolver().bulkInsert(BurppleContract.PromotionsEntry.CONTENT_URI,
                promotionsCVs);
        Log.d(BfpApp.LOG_TAG, "insertedPromotions : " + insertedPromotions);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onGuidesLoaded(RestApiEvent.GuidesLoadedEvent event) {

        mConfigUtils.saveGuidesPageIndex(event.getLoadedPageIndex() + 1);

        //Logic for saving data in Persistence Layer
        ContentValues[] guidesCVs = new ContentValues[event.getLoadGuides().size()];

        for (int index = 0; index < guidesCVs.length; index++) {
            GuidesVO guides = event.getLoadGuides().get(index);
            guidesCVs[index] = guides.parseToContentValues();
        }

        int insertedGuides = event.getContext().getContentResolver().bulkInsert(BurppleContract.GuidesEntry.CONTENT_URI,
                guidesCVs);
        Log.d(BfpApp.LOG_TAG, "insertedGuides : " + insertedGuides);
    }
}
