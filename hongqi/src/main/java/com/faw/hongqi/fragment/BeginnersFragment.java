package com.faw.hongqi.fragment;

import static com.faw.hongqi.fragment.OverviewFragment.Loge;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.faw.hongqi.R;
import com.faw.hongqi.adaptar.BeginnersAdapter;
import com.faw.hongqi.bean.BeginnersBean;
import com.faw.hongqi.ui.InfoActivity;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class BeginnersFragment extends Fragment implements View.OnClickListener {
    RelativeLayout rela_jrqd_, rela_cz_, rela_js_, rela_gn_, rela_zc_;
    TextView text_jrqd, text_cz, text_js, text_gn, text_zc;
    GridView gridView;
    private SimpleAdapter adapter;
    List<Map<String, String>> list;
    List<BeginnersBean> beginnersBeanList;
    String[] s = {"安全须知", "仪表组", "组合仪表", "防盗系统", "多功能显示屏", "废气注意事项", "智能进入和启动", "全景天窗"};
    String beginnersary;
    JSONArray jsonArray;
    BeginnersAdapter beginnersAdapter;
    int n = 0;
    public static final BeginnersFragment newInstance_geginners(String jsonArray) {
        BeginnersFragment fragment = new BeginnersFragment();
        Bundle bundle = new Bundle();
        bundle.putString("jsonArray", jsonArray);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beginners, container, false);
        Log.e("length----", "----");
        beginnersBeanList = new ArrayList<>();
        beginnersAdapter = new BeginnersAdapter(getContext(),beginnersBeanList);
        beginnersary = getArguments().getString("jsonArray");
        try {
            jsonArray = new JSONArray(beginnersary);
            Log.e("length----", String.valueOf(jsonArray.length()));
            jsonArray.getJSONObject(0).getJSONArray("sonContentlist");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        view.findViewById(R.id.rela_jrqd).setOnClickListener(this);
        view.findViewById(R.id.rela_cz).setOnClickListener(this);
        view.findViewById(R.id.rela_js).setOnClickListener(this);
        view.findViewById(R.id.rela_gn).setOnClickListener(this);
        view.findViewById(R.id.rela_zc).setOnClickListener(this);
        rela_jrqd_ = view.findViewById(R.id.rela_jrqd_);
        rela_cz_ = view.findViewById(R.id.rela_cz_);
        rela_js_ = view.findViewById(R.id.rela_js_);
        rela_gn_ = view.findViewById(R.id.rela_gn_);
        rela_zc_ = view.findViewById(R.id.rela_zc_);
        text_jrqd = view.findViewById(R.id.text_jrqd);
        text_cz = view.findViewById(R.id.text_cz);
        text_js = view.findViewById(R.id.text_js);
        text_gn = view.findViewById(R.id.text_gn);
        text_zc = view.findViewById(R.id.text_zc);
        gridView = view.findViewById(R.id.gridview_item_beginners);
        list = new ArrayList<>();

        try {
            set_list(jsonArray.getJSONObject(0).getJSONArray("sonContentlist"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        gridView.setAdapter(beginnersAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String ss = "";
                try {
                    ss = jsonArray.getJSONObject(n).getJSONArray("sonContentlist").getJSONObject(position).getJSONArray("carContentTemplate").toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent();
                intent.setClass(getActivity(), InfoActivity.class);
                Bundle bundle = new Bundle();        //创建bundle对象
                bundle.putString("info",ss); //(String型)
                intent.putExtras(bundle);        //通过intent绑定Bundle
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rela_jrqd) {
            n = 0;
            beginnersBeanList.clear();
            setGoo(rela_jrqd_, text_jrqd);
            try {
                set_list(jsonArray.getJSONObject(0).getJSONArray("sonContentlist"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            beginnersAdapter.notifyDataSetChanged();
        }
        if (v.getId() == R.id.rela_cz) {
            n = 1;
            beginnersBeanList.clear();
            setGoo(rela_cz_, text_cz);
            try {
                set_list(jsonArray.getJSONObject(1).getJSONArray("sonContentlist"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            beginnersAdapter.notifyDataSetChanged();
        }
        if (v.getId() == R.id.rela_js) {
            n = 2;
            beginnersBeanList.clear();
            setGoo(rela_js_, text_js);
            try {
                set_list(jsonArray.getJSONObject(2).getJSONArray("sonContentlist"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            beginnersAdapter.notifyDataSetChanged();
        }
        if (v.getId() == R.id.rela_gn) {
            n = 3;
            beginnersBeanList.clear();
            setGoo(rela_gn_, text_gn);
            try {
                set_list(jsonArray.getJSONObject(3).getJSONArray("sonContentlist"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            beginnersAdapter.notifyDataSetChanged();
        }
        if (v.getId() == R.id.rela_zc) {
            n = 4;
            beginnersBeanList.clear();
            setGoo(rela_zc_, text_zc);
            try {
                set_list(jsonArray.getJSONObject(4).getJSONArray("sonContentlist"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            beginnersAdapter.notifyDataSetChanged();
        }
    }

    public void setGoo(RelativeLayout rela, TextView text) {
        if (rela.getVisibility() != View.VISIBLE) {
            rela_jrqd_.setVisibility(View.GONE);
            rela_cz_.setVisibility(View.GONE);
            rela_js_.setVisibility(View.GONE);
            rela_gn_.setVisibility(View.GONE);
            rela_zc_.setVisibility(View.GONE);
            rela.setVisibility(View.VISIBLE);
            text_jrqd.setVisibility(View.VISIBLE);
            text_cz.setVisibility(View.VISIBLE);
            text_js.setVisibility(View.VISIBLE);
            text_gn.setVisibility(View.VISIBLE);
            text_zc.setVisibility(View.VISIBLE);
            text.setVisibility(View.GONE);
        }
    }

    public void set_list(JSONArray jsonArray){
        for (int k = 0 ; k < jsonArray.length() ; k++){
            BeginnersBean beginnersBean = new BeginnersBean();
            try {
                beginnersBean.setName(jsonArray.getJSONObject(k).getString("title"));
                beginnersBean.setImageurl(jsonArray.getJSONObject(k).getString("picturePath"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            beginnersBeanList.add(beginnersBean);
        }
    }
}