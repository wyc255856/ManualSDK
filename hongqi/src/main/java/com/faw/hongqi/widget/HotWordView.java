package com.faw.hongqi.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.faw.hongqi.R;
import com.faw.hongqi.dbutil.DBUtil;
import com.faw.hongqi.model.HotWord;


import java.util.ArrayList;
import java.util.List;

public class HotWordView extends LinearLayout {
    private Activity mContext;
    private LinearLayout hot_word_layout;
    private List<HotWord> list = new ArrayList<>();

    public HotWordView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public HotWordView(Context context) {
        super(context);
        initView(context);
    }

    @SuppressLint("WrongViewCast")
    private void initView(Context context) {
        // TODO Auto-generated method stub
        this.mContext = (Activity) context;
        LayoutInflater.from(context).inflate(R.layout.view_hot_word,
                this, true);
        hot_word_layout = findViewById(R.id.hot_word_layout);
        initWord();
    }


    public void initWord() {
        hot_word_layout.removeAllViews();

                    list = DBUtil.getHotWordList(mContext);

                mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (final HotWord hotWord : list) {
                            HotWordItemView hotWordItemView = new HotWordItemView(mContext);
                            hotWordItemView.setText(hotWord.getWord());
                            hotWordItemView.setOnClickListener(new OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (onHotWordOnClickListener != null) {
                                        onHotWordOnClickListener.onClickItem(hotWord.getWord());
                                    }
                                }
                            });
                            hot_word_layout.addView(hotWordItemView);
                        }
                    }
                });

    }

    private OnHotWordOnClickListener onHotWordOnClickListener;


    public void setOnHotWordOnClickListener(OnHotWordOnClickListener onHotWordOnClickListener) {
        this.onHotWordOnClickListener = onHotWordOnClickListener;
    }

    public interface OnHotWordOnClickListener {
        void onClickItem(String word);
    }

}
