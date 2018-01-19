package com.bnkk.padcburpplefoodplaces.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bnkk.padcburpplefoodplaces.R;
import com.bnkk.padcburpplefoodplaces.data.vos.PromotionsVO;
import com.bumptech.glide.Glide;

import butterknife.BindView;

/**
 * Created by E5-575G on 1/5/2018.
 */

public class PromotionsViewHolder extends BaseViewHolder<PromotionsVO> {

    @BindView(R.id.iv_promotion_img)
    ImageView ivPromotionImg;

    @BindView(R.id.tv_promotion_title)
    TextView tvPromotionTitle;

    @BindView(R.id.tv_promotion_duration)
    TextView tvPromotionDuration;

    @BindView(R.id.tv_shop_name)
    TextView tvShopName;

    @BindView(R.id.tv_shop_area)
    TextView tvShopArea;

    public PromotionsViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(PromotionsVO data) {
        if (data != null) {

            if (data.getBurpplePromotionImage() != null) {
                Glide
                        .with(ivPromotionImg.getContext())
                        .load(data.getBurpplePromotionImage())
                        .into(ivPromotionImg);
            }

            if (data.getBurpplePromotionTitle() != null) {
                tvPromotionTitle.setText(data.getBurpplePromotionTitle());
            }

            if (data.getBurpplePromotionUntil() != null) {
                tvPromotionDuration.setText(data.getBurpplePromotionUntil());
            }

            if (data.getBurpplePromotionShop() != null) {
                tvShopName.setText(data.getBurpplePromotionShop().getBurppleShopName());
                tvShopArea.setText(data.getBurpplePromotionShop().getBurppleShopArea());
            }
        }
    }
}
