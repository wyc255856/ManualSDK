package com.faw.hongqi.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.faw.hongqi.R;
import com.faw.hongqi.adaptar.PtrrvAdapter;
import com.faw.hongqi.dbutil.DBUtil;
import com.faw.hongqi.event.BaseEvent;
import com.faw.hongqi.event.HideKeyboardEvent;
import com.faw.hongqi.holder.SearchHolder;
import com.faw.hongqi.model.CategoryModel;
import com.faw.hongqi.model.NewsModel;
import com.faw.hongqi.util.LogUtil;
import com.faw.hongqi.widget.HotWordView;
import com.lhh.ptrrv.library.PullToRefreshRecyclerView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends BaseFragment {
    EditText search_edit;
    View delete_btn;
    PullToRefreshRecyclerView recyclerView;
    public PtrrvAdapter mAdapter;
    List<NewsModel> newsList = new ArrayList<>();
    public static String WORD = "";
    HotWordView hot_word_view;
    private LinearLayout nothing;

    //    private TagFlowLayout tagFlowLayout;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_c229_search;
    }

    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initView(View view) {
        delete_btn = view.findViewById(R.id.delete_btn);
        search_edit = view.findViewById(R.id.search_edit);
        recyclerView = view.findViewById(R.id.ptrrv);
        mAdapter = new PtrrvAdapter(mContext, R.layout.item_search, SearchHolder.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mAdapter);
        hot_word_view = view.findViewById(R.id.hot_word_view);
        nothing = view.findViewById(R.id.ll_nonthing);
        hot_word_view.setOnHotWordOnClickListener(new HotWordView.OnHotWordOnClickListener() {
            @Override
            public void onClickItem(String word) {
                search_edit.setText(word);
            }
        });
//        tagFlowLayout = view.findViewById(R.id.tagfl);
//        initView();
        //初始化搜索历史/热门搜
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerItemDecoration);
    }


    @Override
    protected void initWidgetActions() {
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_edit.setText("");
                recyclerView.setVisibility(View.GONE);
                hot_word_view.setVisibility(View.VISIBLE);
                hot_word_view.initWord();
            }
        });
        search_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null) {
                    delete_btn.setVisibility(View.VISIBLE);
                    search(s.toString());
                    recyclerView.setVisibility(View.VISIBLE);
                    hot_word_view.setVisibility(View.GONE);
                } else {
                    delete_btn.setVisibility(View.GONE);
                    hot_word_view.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                    nothing.setVisibility(View.GONE);
                }
            }
        });
    }

    List<NewsModel> list;

    private void search(String word) {
        recyclerView.setVisibility(View.VISIBLE);
        hot_word_view.setVisibility(View.GONE);
        if (!"".equals(word)) {
            DBUtil.insertHotWord(word);
            WORD = word;
            list = new ArrayList<>();

            list = DBUtil.searchByWord(mContext, word);
            ((Activity) mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (list.size() == 0) {
                        nothing.setVisibility(View.VISIBLE);
                    }
                    mAdapter.refreshData(list);
                }
            });
        }



        LogUtil.logError("list size = " + list.size());

    }

    public void HideKeyboard(View v) {
        search_edit.requestFocus();
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(search_edit, InputMethodManager.SHOW_IMPLICIT);

    }

    @Subscribe
    public void onEvent(BaseEvent event) {
        if (event instanceof HideKeyboardEvent) {
            HideKeyboard(search_edit);
        }

    }

    @Override
    public void refreshData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
