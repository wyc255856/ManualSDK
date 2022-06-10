package com.faw.hongqi.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.faw.hongqi.R;
import com.faw.hongqi.adaptar.OverAdapter;
import com.faw.hongqi.bean.Over_Bean;
import com.faw.hongqi.ui.HomeActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class OverviewFragment extends Fragment implements HomeActivity.ChooseType , OverAdapter.Over_onclick {
    RecyclerView recyclerView;
    OverAdapter overAdapter;
    List<Over_Bean> list;
    ImageView image_title;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        list = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recy_over);
        image_title = view.findViewById(R.id.image_title);
        overAdapter = new OverAdapter(getContext(),list,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(overAdapter);
        getHttp();
        return view;
    }
    public void getHttp(){
//        String modelId = "dd75bfe0-f0e2-4010-95e4-c7e304c98b00";
        String modelId = "216b4583-bf69-4cdc-b8cd-5c07e74b2a3f";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
//                .url(HTTP_Adss.HUIXINGURL + "/api/Account/Login?userName="+edit_name.getText().toString()+"&password="+edit_password.getText().toString())
//                .url("http://10.10.0.135:10088/car/column/listAllPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId="+modelId)
                .url("http://115.28.72.235:10088/car/column/listAllPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId="+modelId)
//                .url("https://fawivi-gw-public-uat.faw.cn:63443/car/column/listAllPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId="+modelId)
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
//                    Log("str----", str);
                    JSONObject json;
                    JSONArray jsonArray;
                    try {
                        json = new JSONObject(str);
                        jsonArray = json.getJSONArray("rows");
                        if (jsonArray != null && jsonArray.length() != 0){
//                            Log("str----", jsonArray.get(0).toString());
                            getArray(jsonArray);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
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
    public void getArray(JSONArray jsonArray){
        if (jsonArray != null && jsonArray.length() != 0){
            try {
                JSONObject js;
                JSONArray jsonArray1;
                String s;
                for (int k = 0 ; k < jsonArray.length() ; k++){
                    js = jsonArray.getJSONObject(k);
                    s = js.getString("columnName");
                    if (s != null && s.equals("车型概览")){
//                    if (s != null && s.equals("快速入门")){
                        jsonArray1 = js.getJSONArray("sonList");
                        Log("----",jsonArray1.toString());
                        Log("----",String.valueOf(jsonArray1.length()));
                        for (int l = 0 ; l < jsonArray1.length() ; l++){
                            Log("逐条----"+l,jsonArray1.getJSONObject(l).toString());
                            Log("层级----",jsonArray1.getJSONObject(l).getJSONArray("sonContentlist").getJSONObject(0).toString());
                        }
                        JSONObject json = jsonArray1.getJSONObject(1).getJSONArray("sonContentlist").getJSONObject(0);
                        setView(json,jsonArray1);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void setView(final JSONObject jsonObject,JSONArray jsonArray){
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
                        Glide.with(getContext()).load(urlImage).into(image_title);
                    }
                });
            }
        }).start();
        try {
            for (int k = 0 ; k < jsonArray.length() ; k++){
                Over_Bean over_bean = new Over_Bean();
                over_bean.setName(jsonArray.getJSONObject(k).getJSONArray("sonContentlist").getJSONObject(0).getString("title"));
                over_bean.setImage_o(jsonArray.getJSONObject(k).getJSONArray("sonContentlist").getJSONObject(0).getString("picturePathTwo"));
                over_bean.setImage_u(jsonArray.getJSONObject(k).getJSONArray("sonContentlist").getJSONObject(0).getString("picturePathThree"));
                list.add(over_bean);
            }
            overAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void choose() {
        Log.e("点击事件----","----");
    }

    @Override
    public void onItemClick(int position) {

    }
    //Glide.with(mContext).load(fileName).into(imageView);
}