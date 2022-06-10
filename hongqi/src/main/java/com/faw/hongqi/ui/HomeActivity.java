package com.faw.hongqi.ui;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.text.PrecomputedTextCompat;
import android.text.PrecomputedText;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeActivity extends Base_Act implements View.OnClickListener{
    View view_gl,view_ld,view_rm,view_sc;
    TextView text_gl,text_ld,text_rm,text_sc;
    OverviewFragment overviewFragment;
    BrightFragment brightFragment;
    BeginnersFragment beginnersFragment;
    ShouCeFragment shouCeFragment;
    FragmentManager fm;
    FragmentTransaction ft;
    ChooseType chooseType;
    Dialog dialog_choose;
    ListView listView;
    List<Map<String,String>> list;
    SimpleAdapter simpleAdapter;
    List<Choose_Bean> list_choose;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }
    public void init(){
        list_choose = new ArrayList<>();
        list = new ArrayList<>();
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
        overviewFragment = new OverviewFragment();
        chooseType = new OverviewFragment();
        brightFragment = new BrightFragment();
        beginnersFragment = new BeginnersFragment();
        shouCeFragment = new ShouCeFragment();
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.fragment_main, overviewFragment);
        ft.commit();

//        setW();
//        getHttp();
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rela_gl) {
            setGone(view_gl,text_gl);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, overviewFragment);
            ft.commit();
        }
        if (v.getId() == R.id.rela_ld) {
            setGone(view_ld,text_ld);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, brightFragment);
            ft.commit();
        }
        if (v.getId() == R.id.rela_rm) {
            setGone(view_rm,text_rm);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, beginnersFragment);
            ft.commit();
        }
        if (v.getId() == R.id.rela_sc) {
            setGone(view_sc,text_sc);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, shouCeFragment);
            ft.commit();
        }
        if (v.getId() == R.id.image_search){
            Intent intent = new Intent();
            intent.setClass(HomeActivity.this,SearchActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.rela_chooes_type){
            chooseType.choose();
            Log.e("list_choose----",String.valueOf(list_choose.size()));
            Log.e("list----",String.valueOf(list.size()));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    dialog_choose.show();
//                    simpleAdapter.notifyDataSetChanged();
                }
            }).start();
        }
    }
    public void setGone(View view,TextView text){
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
    public interface ChooseType{
        void choose();
    }

    public void setWindeo(){
        AlertDialog.Builder dg = new AlertDialog.Builder(HomeActivity.this);
        View view = View.inflate(this,R.layout.window_chooes,null);
        listView = (ListView)view.findViewById(R.id.list_choose);
        setList(getData());
        dg.setView(view);
        dialog_choose = dg.create();
        dialog_choose.show();
    }
    public void setList(final List<Map<String,String>> list){
        simpleAdapter = new SimpleAdapter(this,list,R.layout.item_choose_list,new String[]{"choose"},new int[]{R.id.text_item_choose});
        if (listView != null){
            listView.setAdapter(simpleAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(
                        AdapterView<?> parent,
                        View view, int position, long id) {
                    Log.e("----",list.get(position)
                            .get("choose"));
//                    text_jiayouyuan.setText(list.get(position).get("jiayouyuan"));
                    if (dialog_choose != null) {
                        dialog_choose.dismiss();
                    }
                }
            });
        }
    }
    private List<Map<String,String>> getData(){
        list.clear();
        for(int i=0;i<list_choose.size();i++){
            Map<String,String>map=new HashMap<>();
            map.put("choose",list_choose.get(i).getModelName());                  //显示的文字信息
            list.add(map);
        }
        return list;
    }

    public void getHttp(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
//                .url(HTTP_Adss.HUIXINGURL + "/api/Account/Login?userName="+edit_name.getText().toString()+"&password="+edit_password.getText().toString())
                .url("http://10.10.0.135:10088/car/model/listModelByPhone?productId=5d27d49c-6aff-4cba-9aa4-d73af83a3a4c")
//                .url("https://fawivi-gw-public-uat.faw.cn:63443/car/model/listModelByPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84")
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
                    if (str != null){
                        JSONArray jsonArray;
                        try {
                            JSONObject jsonObject = new JSONObject(str);
                            jsonArray = jsonObject.getJSONArray("rows");
                            if (jsonArray != null){
                                setListArray(jsonArray);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
    public void setListArray(JSONArray jsonArray){
        for(int k = 0 ; k < jsonArray.length() ; k++){
            Choose_Bean bean = new Choose_Bean();
            try {
                bean.setModelName(jsonArray.getJSONObject(k).getString("modelName"));
                bean.setModelId(jsonArray.getJSONObject(k).getString("modelId"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            list_choose.add(bean);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setWindeo();
                        simpleAdapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
    }

    public void setW(){
        WindowManager wmManager=(WindowManager) getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
        wmParams.type = WindowManager.LayoutParams.TYPE_PHONE; // 设置window type
        wmParams.format = PixelFormat.RGBA_8888; // 设置图片格式，效果为背景透明
        wmParams.flags= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        wmParams.gravity = Gravity.RIGHT| Gravity. CENTER_VERTICAL; // 调整悬浮窗口至右侧中间
        wmParams.x = 0;// 以屏幕左上角为原点，设置x、y初始值
        wmParams.y = 0;
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;// 设置悬浮窗口长宽数据
        wmParams.height =WindowManager.LayoutParams.WRAP_CONTENT;
//        View view = View.inflate(this,R.layout.window_chooes,null);
        View mWindowView = LayoutInflater.from(getApplication()).inflate(R.layout.window_chooes, null);
//        wmManager.removeView(mWindowView);
        wmManager.addView(mWindowView,wmParams);
    }
}