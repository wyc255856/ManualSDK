package com.faw.hongqi.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.x;



public abstract class BaseFragment extends Fragment {
    protected String Tag;
    protected Context mContext;
    private boolean injected = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        injected = true;
        mContext = getActivity();
        Tag = mContext.toString();
        View view=inflater.inflate(getLayoutId(),container,false);
        initData();
        initView(view);
        initWidgetActions();

        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract void initWidgetActions();

    public abstract void refreshData();
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!injected) {
            x.view().inject(this, this.getView());
        }
    }

}
