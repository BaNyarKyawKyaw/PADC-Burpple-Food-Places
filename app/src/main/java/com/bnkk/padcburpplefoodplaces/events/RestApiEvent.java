package com.bnkk.padcburpplefoodplaces.events;

import com.bnkk.padcburpplefoodplaces.data.vos.FeaturedVO;
import com.bnkk.padcburpplefoodplaces.data.vos.GuidesVO;
import com.bnkk.padcburpplefoodplaces.data.vos.PromotionsVO;

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

        public FeaturedLoadedEvent(int loadedPageIndex, List<FeaturedVO> loadFeatured) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadFeatured = loadFeatured;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<FeaturedVO> getLoadFeatured() {
            return loadFeatured;
        }
    }

    public static class PromotionsLoadedEvent {
        private int loadedPageIndex;
        private List<PromotionsVO> loadPromotions;

        public PromotionsLoadedEvent(int loadedPageIndex, List<PromotionsVO> loadPromotions) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadPromotions = loadPromotions;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<PromotionsVO> getLoadPromotions() {
            return loadPromotions;
        }
    }

    public static class GuidesLoadedEvent {
        private int loadedPageIndex;
        private List<GuidesVO> loadPromotions;

        public GuidesLoadedEvent(int loadedPageIndex, List<GuidesVO> loadPromotions) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadPromotions = loadPromotions;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<GuidesVO> getLoadGuides() {
            return loadPromotions;
        }
    }
}
