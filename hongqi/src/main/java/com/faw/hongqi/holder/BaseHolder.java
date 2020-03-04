package com.faw.hongqi.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.raizlabs.android.dbflow.structure.BaseModel;


public abstract class BaseHolder extends RecyclerView.ViewHolder {

    public BaseHolder(View itemView) {
        super(itemView);
    }
    public abstract void upDate(Context context, BaseModel model, int position);

}
