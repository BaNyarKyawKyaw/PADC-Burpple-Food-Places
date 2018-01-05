package com.bnkk.padcburpplefoodplaces.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.bnkk.padcburpplefoodplaces.R;
import com.bnkk.padcburpplefoodplaces.adapters.BurppleGuidesAdapter;
import com.bnkk.padcburpplefoodplaces.adapters.HighLightImagesPagerAdapter;
import com.bnkk.padcburpplefoodplaces.adapters.NewTrendingAdapter;
import com.bnkk.padcburpplefoodplaces.adapters.PromotionsAdapter;
import com.bnkk.padcburpplefoodplaces.components.PageIndicatorView;

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

    @BindView(R.id.rv_new_trending)
    RecyclerView rvNewTrending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        HighLightImagesPagerAdapter mHighLightImagesPagerAdapter = new HighLightImagesPagerAdapter(getApplicationContext());
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

        rvPromotions.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        PromotionsAdapter mPromotionsAdapter = new PromotionsAdapter(getApplicationContext());
        rvPromotions.setAdapter(mPromotionsAdapter);

        rvBurppleGuides.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        BurppleGuidesAdapter mBurppleGuidesAdapter = new BurppleGuidesAdapter(getApplicationContext());
        rvBurppleGuides.setAdapter(mBurppleGuidesAdapter);

        rvNewTrending.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        NewTrendingAdapter mNewTrendingAdapter = new NewTrendingAdapter(getApplicationContext());
        rvNewTrending.setAdapter(mNewTrendingAdapter);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        /*
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        */

        return super.onOptionsItemSelected(item);
    }
}
