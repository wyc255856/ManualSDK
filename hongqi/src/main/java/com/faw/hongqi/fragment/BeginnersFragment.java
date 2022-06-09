package com.faw.hongqi.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.faw.hongqi.R;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
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

public class BeginnersFragment extends Fragment implements View.OnClickListener{
    RelativeLayout rela_jrqd_,rela_cz_,rela_js_,rela_gn_,rela_zc_;
    TextView text_jrqd,text_cz,text_js,text_gn,text_zc;
    GridView gridView;
    private SimpleAdapter adapter;
    List<Map<String,String>> list;
    String[] s = {"安全须知","仪表组","组合仪表","防盗系统","多功能显示屏","废气注意事项","智能进入和启动","全景天窗"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beginners, container, false);
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
        for (int k = 0 ; k < s.length;k++){
            Map<String,String> map = new HashMap<>();
            map.put("text",s[k]);
            list.add(map);
        }
        adapter = new SimpleAdapter(getContext(),list,R.layout.item_beginners
                ,new String[]{"text"}
                ,new int[]{R.id.text_item_beginners});
        gridView.setAdapter(adapter);
        getHttp();
        return view;
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rela_jrqd) {
            setGoo(rela_jrqd_,text_jrqd);
        }
        if (v.getId() == R.id.rela_cz) {
            setGoo(rela_cz_,text_cz);
        }
        if (v.getId() == R.id.rela_js) {
            setGoo(rela_js_,text_js);
        }
        if (v.getId() == R.id.rela_gn) {
            setGoo(rela_gn_,text_gn);
        }
        if (v.getId() == R.id.rela_zc) {
            setGoo(rela_zc_,text_zc);
        }
    }
    public void setGoo(RelativeLayout rela,TextView text){
        if (rela.getVisibility() != View.VISIBLE){
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
    public void getHttp(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
//                .url(HTTP_Adss.HUIXINGURL + "/api/Account/Login?userName="+edit_name.getText().toString()+"&password="+edit_password.getText().toString())
//                .url("http://10.10.0.135:10088/car/model/listModelByPhone?productId=5d27d49c-6aff-4cba-9aa4-d73af83a3a4c")
                .url("https://fawivi-gw-public-uat.faw.cn:63443/car/model/listModelByPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("报错----", e.toString());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {//回调的方法执行在子线程。
                    String str = response.body().string();
                    Log.e("str----", str);
                }
            }
        });
    }
}