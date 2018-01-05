package com.bnkk.padcburpplefoodplaces.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bnkk.padcburpplefoodplaces.R;
import com.bnkk.padcburpplefoodplaces.viewholders.NewTrendingViewHolder;

/**
 * Created by E5-575G on 1/5/2018.
 */

public class NewTrendingAdapter extends RecyclerView.Adapter<NewTrendingViewHolder> {

    private LayoutInflater mLayoutInflater;

    public NewTrendingAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NewTrendingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View newTrendingItem = mLayoutInflater.inflate(R.layout.view_item_new_trending, parent, false);
        return new NewTrendingViewHolder(newTrendingItem);
    }

    @Override
    public void onBindViewHolder(NewTrendingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
