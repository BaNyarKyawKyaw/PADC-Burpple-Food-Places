package com.bnkk.padcburpplefoodplaces.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bnkk.padcburpplefoodplaces.R;
import com.bnkk.padcburpplefoodplaces.viewholders.PromotionsViewHolder;

/**
 * Created by E5-575G on 1/5/2018.
 */

public class PromotionsAdapter extends RecyclerView.Adapter<PromotionsViewHolder> {

    private LayoutInflater mLayoutInflater;

    public PromotionsAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public PromotionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View promotionItemView = mLayoutInflater.inflate(R.layout.view_item_promotions, parent, false);
        return new PromotionsViewHolder(promotionItemView);
    }

    @Override
    public void onBindViewHolder(PromotionsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
