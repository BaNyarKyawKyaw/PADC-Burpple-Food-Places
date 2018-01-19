package com.bnkk.padcburpplefoodplaces.viewItems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bnkk.padcburpplefoodplaces.R;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5-575G on 1/19/2018.
 */

public class FeaturedImagesViewItem extends FrameLayout {

    @BindView(R.id.iv_featured_img)
    ImageView ivFeaturedImg;

    public FeaturedImagesViewItem(@NonNull Context context) {
        super(context);
    }

    public FeaturedImagesViewItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FeaturedImagesViewItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setData(String imgUrl) {
        Glide
                .with(ivFeaturedImg.getContext())
                .load(imgUrl)
                .into(ivFeaturedImg);
    }
}
