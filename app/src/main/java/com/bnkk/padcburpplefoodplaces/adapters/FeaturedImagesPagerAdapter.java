package com.bnkk.padcburpplefoodplaces.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bnkk.padcburpplefoodplaces.R;
import com.bnkk.padcburpplefoodplaces.data.vos.FeaturedVO;
import com.bnkk.padcburpplefoodplaces.viewItems.FeaturedImagesViewItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5-575G on 1/5/2018.
 */

public class FeaturedImagesPagerAdapter extends PagerAdapter {

    private LayoutInflater mLayoutInflater;
    private List<FeaturedVO> mFeatured;

    public FeaturedImagesPagerAdapter(Context context) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        mFeatured = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mFeatured.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        FeaturedImagesViewItem itemView = (FeaturedImagesViewItem) mLayoutInflater.inflate(R.layout.view_item_featured_image, container, false);

        if (mFeatured.get(position).getBurppleFeaturedImage() != null) {
            itemView.setData(mFeatured.get(position).getBurppleFeaturedImage());
        }
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public void setFeatured(List<FeaturedVO> featured) {
        mFeatured = featured;
        notifyDataSetChanged();
    }
}
