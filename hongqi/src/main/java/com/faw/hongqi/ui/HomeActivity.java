package com.faw.hongqi.ui;

import static com.faw.hongqi.fragment.BeginnersFragment.newInstance_geginners;
import static com.faw.hongqi.fragment.BrightFragment.newInstance_bright;
import static com.faw.hongqi.fragment.OverviewFragment.Loge;
import static com.faw.hongqi.fragment.OverviewFragment.newInstance_over;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.faw.hongqi.R;
import com.faw.hongqi.bean.Choose_Bean;
import com.faw.hongqi.fragment.BeginnersFragment;
import com.faw.hongqi.fragment.BrightFragment;
import com.faw.hongqi.fragment.OverviewFragment;
import com.faw.hongqi.fragment.ShouCeFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeActivity extends Base_Act implements View.OnClickListener {
    View view_gl, view_ld, view_rm, view_sc;
    TextView text_gl, text_ld, text_rm, text_sc;
    OverviewFragment overviewFragment;
    BrightFragment brightFragment;
    BeginnersFragment beginnersFragment;
    ShouCeFragment shouCeFragment;
    FragmentManager fm;
    FragmentTransaction ft;
    Dialog dialog_choose;
    ListView listView;
    List<Map<String, String>> list;
    SimpleAdapter simpleAdapter;
    List<Choose_Bean> list_choose;
    List<String> list_str;
    List<Map<String, String>> lists;
    List<String> list_s;
    private SimpleAdapter adapter;
    JSONArray jsonArray;
    WindowManager windowManager;
    View view1;
//    Spinner spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    public void init() {
        list_choose = new ArrayList<>();
        list = new ArrayList<>();
        list_str = new ArrayList<>();
        list_s = new ArrayList<>();
        lists = new ArrayList<>();
        findViewById(R.id.rela_gl).setOnClickListener(this);
        findViewById(R.id.rela_ld).setOnClickListener(this);
        findViewById(R.id.rela_rm).setOnClickListener(this);
        findViewById(R.id.rela_sc).setOnClickListener(this);
        findViewById(R.id.image_search).setOnClickListener(this);
        findViewById(R.id.rela_chooes_type).setOnClickListener(this);
        view_gl = findViewById(R.id.view_gl);
        view_ld = findViewById(R.id.view_ld);
        view_rm = findViewById(R.id.view_rm);
        view_sc = findViewById(R.id.view_sc);
        text_gl = findViewById(R.id.text_gl);
        text_ld = findViewById(R.id.text_ld);
        text_rm = findViewById(R.id.text_rm);
        text_sc = findViewById(R.id.text_sc);
        text_gl.setTextColor(getResources().getColor(R.color.light_blue));
//        spinner = findViewById(R.id.spinner_cartype);
        listView = findViewById(R.id.list_choose);
        getHttpChoose();
//        setww();
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                try {
//                    getHttp(jsonArray.getJSONObject(position).getString("modelId"));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rela_gl) {
            setGone(view_gl, text_gl);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, overviewFragment);
            ft.commit();
        }
        if (v.getId() == R.id.rela_ld) {
            setGone(view_ld, text_ld);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, brightFragment);
            ft.commit();
        }
        if (v.getId() == R.id.rela_rm) {
            setGone(view_rm, text_rm);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, beginnersFragment);
            ft.commit();
        }
        if (v.getId() == R.id.rela_sc) {
            setGone(view_sc, text_sc);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, shouCeFragment);
            ft.commit();
        }
        if (v.getId() == R.id.image_search) {
            Intent intent = new Intent();
            intent.setClass(HomeActivity.this, SearchActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.rela_chooes_type) {
//            chooseType.choose(this,this,list_str);
            if (jsonArray != null && jsonArray.length() != 0) {
                getchooselist(jsonArray);
            }
//            if (windowManager != null && view != null){
//                windowManager.removeView(view);
//            }
            if (listView.getVisibility() == View.VISIBLE){
                listView.setVisibility(View.GONE);
            }else {
                listView.setVisibility(View.VISIBLE);
            }
        }
    }


    public void setSpinner(){
        for (int k = 0; k < jsonArray.length(); k++) {
            try {
                list_s.add(jsonArray.getJSONObject(k).getString("modelName"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        for (int k = 0; k < list_s.size(); k++) {
            Map<String, String> map = new HashMap<>();
            map.put("text", list_s.get(k));
            lists.add(map);
        }
        adapter = new SimpleAdapter(this, lists, R.layout.window_over
                , new String[]{"text"}
                , new int[]{R.id.text_choosecartype});
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        spinner.setAdapter(adapter);
                    }
                });
            }
        }).start();
    }

    public void setGone(View view, TextView text) {
        view_gl.setVisibility(View.GONE);
        view_ld.setVisibility(View.GONE);
        view_rm.setVisibility(View.GONE);
        view_sc.setVisibility(View.GONE);
        view.setVisibility(View.VISIBLE);
        text_gl.setTextColor(getResources().getColor(R.color.text_d));
        text_ld.setTextColor(getResources().getColor(R.color.text_d));
        text_rm.setTextColor(getResources().getColor(R.color.text_d));
        text_sc.setTextColor(getResources().getColor(R.color.text_d));
        text.setTextColor(getResources().getColor(R.color.light_blue));
    }

    public void setList(final List<Map<String, String>> list) {
        simpleAdapter = new SimpleAdapter(this, list, R.layout.item_choose_list, new String[]{"choose"}, new int[]{R.id.text_item_choose});
        if (listView != null) {
            listView.setAdapter(simpleAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    text_jiayouyuan.setText(list.get(position).get("jiayouyuan"));
                    if (dialog_choose != null) {
                        dialog_choose.dismiss();
                    }
                }
            });
        }
    }

    private List<Map<String, String>> getData() {
        list.clear();
        for (int i = 0; i < list_choose.size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("choose", list_choose.get(i).getModelName());                  //显示的文字信息
            list.add(map);
        }
        return list;
    }

    public void getHttp(String modelId) {
//        String modelId = "dd75bfe0-f0e2-4010-95e4-c7e304c98b00";
//        String modelId = "216b4583-bf69-4cdc-b8cd-5c07e74b2a3f";
        Loge("请求地址----", "http://fawivi-gw-public-uat.faw.cn:63443/car/column/listAllPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId=" + modelId);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
//                .url(HTTP_Adss.HUIXINGURL + "/api/Account/Login?userName="+edit_name.getText().toString()+"&password="+edit_password.getText().toString())
                .url("http://10.10.0.134:10088/car/column/listAllPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId=" + modelId)
//                .url("http://fawivi-gw-public-uat.faw.cn:63443/car/column/listAllPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId="+modelId)
//                .url("https://fawivi-gw-public-uat.faw.cn:63443/car/model/listModelByPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Loge("报错----", e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {//回调的方法执行在子线程。
                    String str = response.body().string();
                    Loge("str----", str);
                    JSONObject json;
                    JSONArray jsonArra;
                    try {
                        json = new JSONObject(str);
                        jsonArra = json.getJSONArray("rows");
                        if (jsonArra != null && jsonArra.length() != 0) {
                            getArray(jsonArra);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    public void getHttpChoose() {
//        String modelId = "dd75bfe0-f0e2-4010-95e4-c7e304c98b00";
        String modelId = "216b4583-bf69-4cdc-b8cd-5c07e74b2a3f";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
//                .url(HTTP_Adss.HUIXINGURL + "/api/Account/Login?userName="+edit_name.getText().toString()+"&password="+edit_password.getText().toString())
//                .url("http://10.10.0.135:10088/car/column/listAllPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId="+modelId)
//                .url("http://115.28.72.235:10088/car/column/listAllPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId="+modelId)
//                .url("https://fawivi-gw-public-uat.faw.cn:63443/car/model/listModelByPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84")
                .url("http://10.10.0.134:10088/car/model/listModelByPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Loge("选择车型报错----",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {//回调的方法执行在子线程。
                    String str = response.body().string();
                    JSONObject json;
                    Loge("选择车型----",str);
                    try {
                        json = new JSONObject(str);
                        jsonArray = json.getJSONArray("rows");
                        if (jsonArray != null && jsonArray.length() != 0) {
                            getHttp(jsonArray.getJSONObject(0).getString("modelId"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
//                    setSpinner();
                }
            }
        });
    }

    //  /car/model/listModelByPhone

    public void getchooselist(final JSONArray jsonArray) {
        for (int k = 0; k < jsonArray.length(); k++) {
            try {
                list_s.add(jsonArray.getJSONObject(k).getString("modelName"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
//        view1 = View.inflate(this, R.layout.window_chooes, null);
//        ListView listView = view1.findViewById(R.id.list_choose);

        for (int k = 0; k < list_s.size(); k++) {
            Map<String, String> map = new HashMap<>();
            map.put("text", list_s.get(k));
            lists.add(map);
        }
        adapter = new SimpleAdapter(this, lists, R.layout.window_over
                , new String[]{"text"}
                , new int[]{R.id.text_choosecartype});
        listView.setAdapter(adapter);

//        final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
//                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 0, 0, PixelFormat.TRANSPARENT);
//        layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION;
//        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//        layoutParams.gravity = Gravity.LEFT | Gravity.TOP;
//        windowManager = this.getWindowManager();
//        windowManager.addView(view1, layoutParams);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    getHttp(jsonArray.getJSONObject(position).getString("modelId"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                if (windowManager != null) {
//                    windowManager.removeView(view1);
//                }
                listView.setVisibility(View.GONE);
            }
        });
    }

    public void setww() {
        String jsonstr = null;
        try {
            InputStream inputStream = getAssets().open("hqjson.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            jsonstr = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject json;
        JSONArray jsonArray;
        try {
            json = new JSONObject(jsonstr);
            jsonArray = json.getJSONArray("rows");
            if (jsonArray != null && jsonArray.length() != 0) {
                getArray(jsonArray);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void Log(String tag, String msg) {  //信息太长,分段打印
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

    public void getArray(JSONArray jsonArray) {
        if (jsonArray != null && jsonArray.length() != 0) {
            try {
                JSONObject js;
                JSONArray jsonArray1;
                String s;
                for (int k = 0; k < jsonArray.length(); k++) {
                    js = jsonArray.getJSONObject(k);
                    s = js.getString("columnName");
                    jsonArray1 = js.getJSONArray("sonList");
                    if (s != null && s.equals("车型概览")) {
                        overviewFragment = newInstance_over(jsonArray1.toString());
                        fm = getSupportFragmentManager();
                        ft = fm.beginTransaction();
                        ft.replace(R.id.fragment_main, overviewFragment);
                        try {
                            ft.commit();
                        }catch (IllegalStateException e){
                        }
                    }
                    if (s != null && s.equals("车型亮点")) {
                        brightFragment = newInstance_bright(jsonArray1.toString());
                    }
                    if (s != null && s.equals("快速入门")) {
                        beginnersFragment = newInstance_geginners(jsonArray1.toString());
                    }
                    if (s != null && s.equals("全量手册")) {
                        shouCeFragment = ShouCeFragment.newInstance_shouce(jsonArray1.toString());
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}