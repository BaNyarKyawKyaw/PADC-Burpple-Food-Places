package com.bnkk.padcburpplefoodplaces.activities;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bnkk.padcburpplefoodplaces.BfpApp;
import com.bnkk.padcburpplefoodplaces.R;
import com.bnkk.padcburpplefoodplaces.adapters.BurppleGuidesAdapter;
import com.bnkk.padcburpplefoodplaces.adapters.FeaturedImagesPagerAdapter;
import com.bnkk.padcburpplefoodplaces.adapters.PromotionsAdapter;
import com.bnkk.padcburpplefoodplaces.components.PageIndicatorView;
import com.bnkk.padcburpplefoodplaces.components.SmartScrollListener;
import com.bnkk.padcburpplefoodplaces.data.models.BurppleModel;
import com.bnkk.padcburpplefoodplaces.data.vos.FeaturedVO;
import com.bnkk.padcburpplefoodplaces.data.vos.GuidesVO;
import com.bnkk.padcburpplefoodplaces.data.vos.PromotionsVO;
import com.bnkk.padcburpplefoodplaces.events.RestApiEvent;
import com.bnkk.padcburpplefoodplaces.mvp.presenters.MainPresenter;
import com.bnkk.padcburpplefoodplaces.mvp.views.MainView;
import com.bnkk.padcburpplefoodplaces.persistence.BurppleContract;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements LoaderManager.LoaderCallbacks<Cursor>, MainView {

    private static final int PROMOTION_LOADER = 1000;
    private static final int FEATURED_LOADER = 2000;
    private static final int GUIDES_LOADER = 3000;

    @BindView(R.id.vp_high_light_images)
    ViewPager vpHighLightImages;

    @BindView(R.id.piv_high_light_images)
    PageIndicatorView pivHighLightImages;

    @BindView(R.id.rv_promotions)
    RecyclerView rvPromotions;

    @BindView(R.id.rv_burpple_guides)
    RecyclerView rvBurppleGuides;

    private FeaturedImagesPagerAdapter mFeaturedImagesPagerAdapter;
    private PromotionsAdapter mPromotionsAdapter;
    private BurppleGuidesAdapter mGuidesAdapter;

    @Inject
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        BfpApp bfpApp = (BfpApp) getApplicationContext();
        bfpApp.getAppComponent().inject(this);

        mPresenter.onCreate(this);

        mFeaturedImagesPagerAdapter = new FeaturedImagesPagerAdapter(getApplicationContext());
        vpHighLightImages.setAdapter(mFeaturedImagesPagerAdapter);

        vpHighLightImages.setOffscreenPageLimit(mFeaturedImagesPagerAdapter.getCount());

        pivHighLightImages.setNumPage(mFeaturedImagesPagerAdapter.getCount());
        vpHighLightImages.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pivHighLightImages.setCurrentPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            int NUM_PAGES = mFeaturedImagesPagerAdapter.getCount();
            int currentPage = 0;

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (currentPage == NUM_PAGES) {
                            currentPage = 0;
                        }
                        vpHighLightImages.setCurrentItem(currentPage++, true);
                    }
                });
            }
        }, 1500, 5000);

        rvPromotions.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false));
        mPromotionsAdapter = new PromotionsAdapter(getApplicationContext());
        rvPromotions.setAdapter(mPromotionsAdapter);

        SmartScrollListener mPromotionsSmartScrollListener = new SmartScrollListener(
                new SmartScrollListener.OnSmartScrollListener() {
                    @Override
                    public void onListEndReach() {
                        BurppleModel burppleModel = new BurppleModel(getApplicationContext());
                        burppleModel.loadMorePromotions(getApplicationContext());
                        //mPresenter.onPromotionListEndReach(getApplicationContext());
                    }
                });
        rvPromotions.addOnScrollListener(mPromotionsSmartScrollListener);

        rvBurppleGuides.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false));
        mGuidesAdapter = new BurppleGuidesAdapter(getApplicationContext());
        rvBurppleGuides.setAdapter(mGuidesAdapter);

        SmartScrollListener mGuidesSmartScrollListener = new SmartScrollListener(
                new SmartScrollListener.OnSmartScrollListener() {
                    @Override
                    public void onListEndReach() {
                        mPresenter.onGuidesListEndReach(getApplicationContext());
                    }
                });
        rvBurppleGuides.addOnScrollListener(mGuidesSmartScrollListener);

        getSupportLoaderManager().initLoader(PROMOTION_LOADER, null, this);
        getSupportLoaderManager().initLoader(FEATURED_LOADER, null, this);
        getSupportLoaderManager().initLoader(GUIDES_LOADER, null, this);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(RestApiEvent.ErrorInvokingAPIEvent event) {
        Snackbar.make(rvPromotions, event.getErrorMsg(), Snackbar.LENGTH_INDEFINITE).show();
        Snackbar.make(rvBurppleGuides, event.getErrorMsg(), Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public android.support.v4.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {

        if (id == PROMOTION_LOADER) {
            return new android.support.v4.content.CursorLoader(getApplicationContext(),
                    BurppleContract.PromotionsEntry.CONTENT_URI,
                    null,
                    null,
                    null,
                    null);
        }

        if (id == GUIDES_LOADER) {
            return new android.support.v4.content.CursorLoader(getApplicationContext(),
                    BurppleContract.GuidesEntry.CONTENT_URI,
                    null,
                    null,
                    null,
                    null);
        }

        if (id == FEATURED_LOADER) {
            return new android.support.v4.content.CursorLoader(getApplicationContext(),
                    BurppleContract.FeatruredEntry.CONTENT_URI,
                    null,
                    null,
                    null,
                    null);
        }
        return null;
    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<Cursor> loader, Cursor data) {
        mPresenter.onDataLoaded(getApplicationContext(), data, loader);
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<Cursor> loader) {

    }

    @Override
    public void displayFeatured(List<FeaturedVO> featuredList) {
        mFeaturedImagesPagerAdapter.setFeatured(featuredList);
    }

    @Override
    public void displayPromotion(List<PromotionsVO> promotionsList) {
        mPromotionsAdapter.appendNewData(promotionsList);
    }

    @Override
    public void displayGuides(List<GuidesVO> guidesList) {
        mGuidesAdapter.appendNewData(guidesList);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
