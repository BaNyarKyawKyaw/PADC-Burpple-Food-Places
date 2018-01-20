package com.bnkk.padcburpplefoodplaces.network;

import android.content.Context;

/**
 * Created by E5-575G on 1/18/2018.
 */

public interface BurppleDataAgent {

    void loadFeatured(String accessToken, int pageNo, Context context);

    void loadPromotions(String accessToken, int pageNo, Context context);

    void loadGuides(String accessToken, int pageNo, Context context);
}
