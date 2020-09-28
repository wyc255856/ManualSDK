package com.faw.hongqi.adaptar;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.faw.hongqi.R;
import com.faw.hongqi.holder.RvHolder;
import com.faw.hongqi.util.PhoneUtil;
import com.faw.hongqi.widget.RvListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortAdapter extends RvAdapter<String> {

    private int checkedPosition;

    public void setCheckedPosition(int checkedPosition) {
        this.checkedPosition = checkedPosition;
        notifyDataSetChanged();
    }

    public SortAdapter(Context context, List<String> list, RvListener listener) {
        super(context, list, listener);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_sort_list;
    }

    @Override
    protected RvHolder getHolder(View view, int viewType) {
        return new SortHolder(view, viewType, listener);
    }

    private class SortHolder extends RvHolder<String> {

        private TextView tvName;
        private ImageView iv_left;
        private View mView;

        SortHolder(View itemView, int type, RvListener listener) {
            super(itemView, type, listener);
            this.mView = itemView;
            tvName = (TextView) itemView.findViewById(R.id.tv_sort);
            iv_left = (ImageView) itemView.findViewById(R.id.iv_left);
        }

        @Override
        public void bindHolder(String string, int position) {
            tvName.setText(string);
            if (position == checkedPosition) {
                if (position == 0) {
                    tvName.setTextAppearance(mContext, R.style.text_28_blue);
                    iv_left.setImageResource(R.mipmap.test_head);
                } else if (position == 11) {
                    tvName.setTextAppearance(mContext, R.style.text_28_blue);
                    iv_left.setImageResource(R.mipmap.test_foot_check);
                } else {
                    tvName.setTextAppearance(mContext, R.style.text_28_blue);
                    iv_left.setImageResource(R.mipmap.test_check);
                }
            } else if (checkedPosition > position) {
                if (position == 0) {
                    iv_left.setImageResource(R.mipmap.test_head_check);
                    tvName.setTextAppearance(mContext, R.style.text_28_white);
                } else {
                    iv_left.setImageResource(R.mipmap.test_check_ed);
                    tvName.setTextAppearance(mContext, R.style.text_28_white);
                }
            } else {
                tvName.setTextAppearance(mContext, R.style.text_28_white);
                iv_left.setImageResource(R.mipmap.test);
            }

        }
    }
}
