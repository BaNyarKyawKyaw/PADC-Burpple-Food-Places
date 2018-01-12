package com.bnkk.padcburpplefoodplaces.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bnkk.padcburpplefoodplaces.R;
import com.bnkk.padcburpplefoodplaces.adapters.BurppleGuidesAdapter;
import com.bnkk.padcburpplefoodplaces.adapters.HighLightImagesPagerAdapter;
import com.bnkk.padcburpplefoodplaces.adapters.PromotionsAdapter;
import com.bnkk.padcburpplefoodplaces.components.PageIndicatorView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        final HighLightImagesPagerAdapter mHighLightImagesPagerAdapter = new HighLightImagesPagerAdapter(getApplicationContext());
        vpHighLightImages.setAdapter(mHighLightImagesPagerAdapter);

        vpHighLightImages.setOffscreenPageLimit(mHighLightImagesPagerAdapter.getCount());

        pivHighLightImages.setNumPage(mHighLightImagesPagerAdapter.getCount());
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
            int NUM_PAGES = mHighLightImagesPagerAdapter.getCount();
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

        rvPromotions.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        PromotionsAdapter mPromotionsAdapter = new PromotionsAdapter(getApplicationContext());
        rvPromotions.setAdapter(mPromotionsAdapter);

        rvBurppleGuides.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        BurppleGuidesAdapter mBurppleGuidesAdapter = new BurppleGuidesAdapter(getApplicationContext());
        rvBurppleGuides.setAdapter(mBurppleGuidesAdapter);

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
}
