package com.bnkk.padcburpplefoodplaces.events;

import android.content.Context;

import com.bnkk.padcburpplefoodplaces.data.vos.FeaturedVO;
import com.bnkk.padcburpplefoodplaces.data.vos.GuidesVO;
import com.bnkk.padcburpplefoodplaces.data.vos.PromotionsVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5-575G on 1/18/2018.
 */

public class RestApiEvent {

    public static class EmptyResponseEvent {

    }

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static class FeaturedLoadedEvent {
        private int loadedPageIndex;
        private List<FeaturedVO> loadFeatured;
        private Context context;

        public FeaturedLoadedEvent(int loadedPageIndex, List<FeaturedVO> loadFeatured, Context context) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadFeatured = loadFeatured;
            this.context = context;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<FeaturedVO> getLoadFeatured() {
            if (loadFeatured == null) {
                loadFeatured = new ArrayList<>();
            }

            return loadFeatured;
        }

        public Context getContext() {
            return context;
        }
    }

    public static class PromotionsLoadedEvent {
        private int loadedPageIndex;
        private List<PromotionsVO> loadPromotions;
        private Context context;

        public PromotionsLoadedEvent(int loadedPageIndex, List<PromotionsVO> loadPromotions, Context context) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadPromotions = loadPromotions;
            this.context = context;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<PromotionsVO> getLoadPromotions() {
            if (loadPromotions == null) {
                loadPromotions = new ArrayList<>();
            }

            return loadPromotions;
        }

        public Context getContext() {
            return context;
        }
    }

    public static class GuidesLoadedEvent {
        private int loadedPageIndex;
        private List<GuidesVO> loadGuides;
        private Context context;

        public GuidesLoadedEvent(int loadedPageIndex, List<GuidesVO> loadGuides, Context context) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadGuides = loadGuides;
            this.context = context;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<GuidesVO> getLoadGuides() {
            if (loadGuides == null) {
                loadGuides = new ArrayList<>();
            }

            return loadGuides;
        }

        public Context getContext() {
            return context;
        }
    }
}
