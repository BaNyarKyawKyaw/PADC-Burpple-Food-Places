package com.bnkk.padcburpplefoodplaces.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bnkk.padcburpplefoodplaces.R;
import com.bnkk.padcburpplefoodplaces.data.vos.GuidesVO;
import com.bumptech.glide.Glide;

import butterknife.BindView;

/**
 * Created by E5-575G on 1/5/2018.
 */

public class BurppleGuidesViewHolder extends BaseViewHolder<GuidesVO> {

    @BindView(R.id.iv_burpple_guide)
    ImageView ivBurppleGuide;

    public BurppleGuidesViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(GuidesVO data) {
        if (data != null) {

            if (data.getBurppleGuideImage() != null) {
                Glide
                        .with(ivBurppleGuide.getContext())
                        .load(data.getBurppleGuideImage())
                        .into(ivBurppleGuide);
            }
        }
    }
}
