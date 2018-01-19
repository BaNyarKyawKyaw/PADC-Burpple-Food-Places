package com.bnkk.padcburpplefoodplaces.network;

/**
 * Created by E5-575G on 1/18/2018.
 */

public interface BurppleDataAgent {

    void loadFeatured(String accessToken, int pageNo);

    void loadPromotions(String accessToken, int pageNo);

    void loadGuides(String accessToken, int pageNo);
}
