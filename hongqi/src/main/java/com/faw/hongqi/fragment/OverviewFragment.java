package com.faw.hongqi.fragment;
import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.faw.hongqi.R;
import com.faw.hongqi.adaptar.OverAdapter;
import com.faw.hongqi.adaptar.Over_Adapter;
import com.faw.hongqi.bean.Over_Bean;
import com.faw.hongqi.bean.Over_info;
import com.faw.hongqi.ui.HomeActivity;
import com.faw.hongqi.view.PagingScrollHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OverviewFragment extends Fragment implements OverAdapter.Over_onclick
        , PagingScrollHelper.onPageChangeListener, Over_Adapter.Over_onclick1 {
    RecyclerView recyclerView;
    OverAdapter overAdapter;
    List<Over_Bean> list_overbean;
    List<Over_Bean> list_overBean;
    ImageView image_title;
    JSONArray jsonary;
    RecyclerView recy_text;
    Over_Adapter over_adapter;
    List<Over_info> list_info;
    PagingScrollHelper scrollHelper = new PagingScrollHelper();
    private LinearLayoutManager hLinearLayoutManager = null;
    private DividerItemDecoration hDividerItemDecoration = null;
    private RecyclerView.ItemDecoration lastItemDecoration = null;
    String ary;
    List<Map<String,String>> lists;
    List<String> list_str;
    TextView text_over_title;
    public static final OverviewFragment newInstance_over(String jsonArray) {
        OverviewFragment fragment = new OverviewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("jsonArray", jsonArray);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        ary = getArguments().getString("jsonArray");
        try {
            JSONArray jsonArray = new JSONArray(ary);
            for (int k = 0 ; k < jsonArray.length() ; k++){
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        list_overbean = new ArrayList<>();
        list_overBean = new ArrayList<>();
        list_info = new ArrayList<>();
        lists = new ArrayList<>();
        list_str = new ArrayList<>();
        text_over_title = (TextView)view.findViewById(R.id.text_over_title);
        recyclerView = view.findViewById(R.id.recy_over);
        recy_text = view.findViewById(R.id.recy_over_text);
        image_title = view.findViewById(R.id.image_title);
        overAdapter = new OverAdapter(getContext(), list_overbean, this);
        over_adapter = new Over_Adapter(getContext(), list_info, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(overAdapter);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置布局管理器
        recy_text.setLayoutManager(layoutManager1);
        recy_text.setAdapter(over_adapter);

        RecyclerView.LayoutManager layoutManager_ = null;
        RecyclerView.ItemDecoration itemDecoration = null;
        scrollHelper.setUpRecycleView(recy_text);
        scrollHelper.setOnPageChangeListener(this);
        layoutManager_ = hLinearLayoutManager;
        itemDecoration = hDividerItemDecoration;
        if (layoutManager_ != null) {
            recy_text.setLayoutManager(layoutManager_);
            recy_text.removeItemDecoration(lastItemDecoration);
            recy_text.addItemDecoration(itemDecoration);
            scrollHelper.updateLayoutManger();
            scrollHelper.scrollToPosition(0);
            lastItemDecoration = itemDecoration;
        }
        recy_text.setHorizontalScrollBarEnabled(true);
        //获取总页数,采用这种方法才能获得正确的页数。否则会因为RecyclerView.State 缓存问题，页数不正确。
        recy_text.post(new Runnable() {
            @Override
            public void run() {
//                tv_page_total.setText("共" + scrollHelper.getPageCount() + "页");
            }
        });
//        getHttp();
        getArray(ary,0);
        if (list_overBean != null && list_overBean.size() > 0){
            text_over_title.setText(list_overBean.get(0).getName());
        }
        return view;
    }
    public static void Loge(String tag, String msg) {  //信息太长,分段打印
        //因为String的length是字符数量不是字节数量所以为了防止中文字符过多，
        //  把4*1024的MAX字节打印长度改为2001字符数
        int max_str_length = 2001 - tag.length();
        //大于4000时
        while (msg.length() > max_str_length) {
            Log.e(tag, msg.substring(0, max_str_length));
            msg = msg.substring(max_str_length);
        }
        //剩余部分
        Log.e(tag, msg);
    }
    public void getArray(String jsonary,int k) {
        JSONArray jsonArray1;
        try {
            jsonArray1 = new JSONArray(jsonary);
            for (int l = 0; l < jsonArray1.length(); l++) {
            }
            JSONObject json = jsonArray1.getJSONObject(k).getJSONArray("sonContentlist").getJSONObject(0);
            JSONArray jsonArray2 = json.getJSONArray("carContentTemplate");
            setList_info(jsonArray2);
            setView(json, jsonArray1,k);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    public void setView(final JSONObject jsonObject, JSONArray jsonArray,int n) {
        jsonary = jsonArray;
        new Thread(new Runnable() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String urlImage = null;
                        try {
                            urlImage = jsonObject.getString("picturePath");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            Glide.with(getContext()).load(urlImage).into(image_title);
                        }catch (NullPointerException e){
                        }
                    }
                });
            }
        }).start();
        try {
            list_overbean.clear();
            for (int k = 0; k < jsonArray.length(); k++) {
                Over_Bean over_bean = new Over_Bean();
                over_bean.setName(jsonArray.getJSONObject(k).getJSONArray("sonContentlist").getJSONObject(0).getString("title"));
                over_bean.setImage_o(jsonArray.getJSONObject(k).getJSONArray("sonContentlist").getJSONObject(0).getString("picturePathTwo"));
                over_bean.setImage_u(jsonArray.getJSONObject(k).getJSONArray("sonContentlist").getJSONObject(0).getString("picturePathThree"));
                if (k == 0 ){
                    over_bean.setIsup(true);
                }

                if (k == n) {
                    over_bean.setIsup(true);
                } else {
                    over_bean.setIsup(false);
                }

                list_overbean.add(over_bean);
//                if (list != null && list.size() > 0){
//                    text_over_title.setText(list.get(0).getName());
//                }
            }
            for (int h = 0 ; h < list_overbean.size() ; h++){
                Log.e("----"+h,list_overbean.get(h).toString());
            }
            list_overBean.addAll(list_overbean);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            overAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }).start();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onItemClick(int position) {
        if (list_overbean != null && list_overbean.size() > 0){
            text_over_title.setText(list_overbean.get(position).getName());
        }else {
            Log.e("list为空----","----");
        }
        list_overbean.clear();
        try {
            for (int k = 0; k < jsonary.length(); k++) {
                Over_Bean over_bean = new Over_Bean();
                if (k == position) {
                    over_bean.setIsup(true);
                } else {
                    over_bean.setIsup(false);
                }
                over_bean.setImage_o(jsonary.getJSONObject(k).getJSONArray("sonContentlist").getJSONObject(0).getString("picturePathTwo"));
                over_bean.setImage_u(jsonary.getJSONObject(k).getJSONArray("sonContentlist").getJSONObject(0).getString("picturePathThree"));
                list_overbean.add(over_bean);
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            overAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }).start();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        getArray(ary,position);

    }

    @Override
    public void onPageChange(int index) {

    }

    @Override
    public void onItemClick1(int position) {
    }
    public void setList_info(JSONArray jsonary) {
        list_info.clear();
        for (int k = 0; k < jsonary.length(); k++) {
            Over_info over_info = new Over_info();
            try {
                over_info.setInfo(jsonary.getJSONObject(k).getString("textcontent"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            list_info.add(over_info);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        over_adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
    }

}