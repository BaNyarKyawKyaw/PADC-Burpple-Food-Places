package com.bnkk.padcburpplefoodplaces.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bnkk.padcburpplefoodplaces.R;
import com.bnkk.padcburpplefoodplaces.data.vos.GuidesVO;
import com.bnkk.padcburpplefoodplaces.viewholders.BurppleGuidesViewHolder;

/**
 * Created by E5-575G on 1/5/2018.
 */

public class BurppleGuidesAdapter extends BaseRecyclerAdapter<BurppleGuidesViewHolder, GuidesVO> {

    public BurppleGuidesAdapter(Context context) {
        super(context);
    }

    @Override
    public BurppleGuidesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View BurppleGuidesItemView = mLayoutInflater.inflate(R.layout.view_item_burpple_guides, parent, false);
        return new BurppleGuidesViewHolder(BurppleGuidesItemView);
    }
}
