package com.bnkk.padcburpplefoodplaces.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bnkk.padcburpplefoodplaces.R;
import com.bnkk.padcburpplefoodplaces.adapters.BurppleGuidesAdapter;
import com.bnkk.padcburpplefoodplaces.adapters.FeaturedImagesPagerAdapter;
import com.bnkk.padcburpplefoodplaces.adapters.PromotionsAdapter;
import com.bnkk.padcburpplefoodplaces.components.PageIndicatorView;
import com.bnkk.padcburpplefoodplaces.components.SmartScrollListener;
import com.bnkk.padcburpplefoodplaces.data.models.BurppleModel;
import com.bnkk.padcburpplefoodplaces.data.vos.FeaturedVO;
import com.bnkk.padcburpplefoodplaces.events.RestApiEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

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
    private BurppleGuidesAdapter mBurppleGuidesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

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
                        BurppleModel.getObjInstance().loadMorePromotions();
                    }
                });
        rvPromotions.addOnScrollListener(mPromotionsSmartScrollListener);

        rvBurppleGuides.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false));
        mBurppleGuidesAdapter = new BurppleGuidesAdapter(getApplicationContext());
        rvBurppleGuides.setAdapter(mBurppleGuidesAdapter);

        SmartScrollListener mGuidesSmartScrollListener = new SmartScrollListener(
                new SmartScrollListener.OnSmartScrollListener() {
                    @Override
                    public void onListEndReach() {
                        BurppleModel.getObjInstance().loadMoreGuides();
                    }
                });
        rvBurppleGuides.addOnScrollListener(mGuidesSmartScrollListener);

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
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onFeaturedLoaded(RestApiEvent.FeaturedLoadedEvent event) {
        bindData(event.getLoadFeatured());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onPromotionsLoaded(RestApiEvent.PromotionsLoadedEvent event) {
        mPromotionsAdapter.appendNewData(event.getLoadPromotions());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onGuidesLoaded(RestApiEvent.GuidesLoadedEvent event) {
        mBurppleGuidesAdapter.appendNewData(event.getLoadGuides());
    }

    public void bindData(List<FeaturedVO> data) {
        mFeaturedImagesPagerAdapter.setFeatured(data);
    }
}
