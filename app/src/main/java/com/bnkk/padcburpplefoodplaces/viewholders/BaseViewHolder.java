package com.bnkk.padcburpplefoodplaces.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by E5-575G on 1/5/2018.
 */

public abstract class BaseViewHolder<W> extends RecyclerView.ViewHolder {

    protected W mData;

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void setData(W data);
}
