package com.faw.hongqi.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.faw.hongqi.R;
import com.faw.hongqi.ui.HomeActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class OverviewFragment extends Fragment implements HomeActivity.ChooseType {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        getHttp();
        return view;
    }
    public void getHttp(){
//        String modelId = "dd75bfe0-f0e2-4010-95e4-c7e304c98b00";
        String modelId = "216b4583-bf69-4cdc-b8cd-5c07e74b2a3f";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
//                .url(HTTP_Adss.HUIXINGURL + "/api/Account/Login?userName="+edit_name.getText().toString()+"&password="+edit_password.getText().toString())
                .url("http://10.10.0.135:10088/car/column/listAllPhone?productId=5d27d49c-6aff-4cba-9aa4-d73af83a3a4c&modelId="+modelId)
                .url("https://fawivi-gw-public-uat.faw.cn:63443/car/column/listAllPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId="+modelId)
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
                String s;
                for (int k = 0 ; k < jsonArray.length() ; k++){
                    js = jsonArray.getJSONObject(k);
                    s = js.getString("columnName");
                    if (s != null && s.equals("车型概览")){
//                    if (s != null && s.equals("快速入门")){
                        Log("----",js.toString());
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void choose() {
        Log.e("点击事件----","----");
    }
}