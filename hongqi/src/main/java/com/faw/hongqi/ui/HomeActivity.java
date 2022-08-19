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
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
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
import com.faw.hongqi.util.Constant;
import com.faw.hongqi.util.HmacSHA256Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RequiresApi(api = Build.VERSION_CODES.O)
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
    String productId;

    String str_url1 = "https://fawivi-gw-public-uat.faw.cn:63443/car/column/listAllPhone";
//    String str_url1 = "http://10.10.0.132:10088/car/column/listAllPhone";
    ///car/model/listModelByPhone
//    String str_url = "http://10.10.0.132:10088/car/model/listModelByPhone";
    String str_url = "https://fawivi-gw-public-uat.faw.cn:63443/car/model/listModelByPhone";
//    String str_url = "http://www.e-guides.faw.cn/c229plus_admin/index.php?m=home&c=index&a=get_car_info&car_name=C229";


//    String url = "http://115.28.72.235:10088/car/column/listAllPhone";
    String clientId = Constant.IS_PRO?Constant.CLIENT_ID_PRO:Constant.CLIENT_ID_UAT;
    String timeStamp = String.valueOf(System.currentTimeMillis());
    String quretStr = "productId=87fd7829-e449-48f1-93f7-63a92b76bc84";
    String str = clientId + quretStr + timeStamp;
    String key = Constant.IS_PRO?Constant.KEY_PRO:Constant.KEY_UAT;
    String base64str = Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }
    public void init() {

        if (Constant.CAR_TYPE.equals("C095")){
            productId = productIdc095;
        }else {
            productId = productIdc100;
        }

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
        listView = findViewById(R.id.list_choose);
        getAllNetWorkString();
//        setww();
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
//115.28.72.235
    String productIdc095 = "309b716a-704d-42cc-8566-f77f0de9ca8c";
    String productIdc100 = "87fd7829-e449-48f1-93f7-63a92b76bc84";


    public void getHttp(String modelId) {
//        Log.e("modelID----",modelId);
//    //                .url(HTTP_Adss.HUIXINGURL + "/api/Account/Login?userName="+edit_name.getText().toString()+"&password="+edit_password.getText().toString())
//    //                .url("http://115.28.72.235:10088/car/column/listAllPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId=" + modelId)// C100
//                    .url("http://115.28.72.235:10088/car/column/listAllPhone?productId="+productId+"&modelId=" + modelId)// C095
////                    .url("http://fawivi-gw-public-uat.faw.cn:63443/car/column/listAllPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId="+modelId)
//    //                .url("https://fawivi-gw-public-uat.faw.cn:63443/car/model/listModelByPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84")

        String url_info = str_url1+"?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId="+modelId;
        String quretStr_info = "modelId="+modelId+"&productId=87fd7829-e449-48f1-93f7-63a92b76bc84";
        String str_info = clientId + quretStr_info + timeStamp;
        String base64str_info = Base64.getEncoder().encodeToString(str_info.getBytes(StandardCharsets.UTF_8));

//        Log.e("str_info----",str_info);
        OkHttpClient build = new OkHttpClient.Builder()
                .sslSocketFactory(createSSLSocketFactory())
                .hostnameVerifier(new TrustAllHostnameVerifier())
                .build();
        final Request request;
        try {
            request = new Request.Builder()
                    .get()
                    .addHeader("timeStamp", timeStamp)
                    .addHeader("clientId", clientId)
                    .addHeader("sign", (HmacSHA256Util.HmacSHA256(base64str_info, key)).toUpperCase())
                    .addHeader("content-Type", "application/json;charset=UTF-8")
                    .addHeader("Connection", "Keep-Alive")
                    .url(url_info).build();
            Call call = build.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
//                    Log.e("报错----",e.toString());
                }

                @Override
                public void onResponse(Call call, Response response)
                        throws IOException {
                    String res = response.body().string();
//                    Log.e("info----",res + "success");
                    JSONObject json;
                    JSONArray jsonArra;
                    try {
                        json = new JSONObject(res);
                        jsonArra = json.getJSONArray("rows");
                        if (jsonArra != null && jsonArra.length() != 0) {
                            getArray(jsonArra);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
//            Log.e("Exception----",e.toString());
        }


    }

    // C095   309b716a-704d-42cc-8566-f77f0de9ca8c;

    //  /car/model/listModelByPhone

    public void getchooselist(final JSONArray jsonArray) {
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
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    getHttp(jsonArray.getJSONObject(position).getString("modelId"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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

//                    Loge("jsonarray----"+k+"----",js.toString());
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

//    String base64str = Base64.getEncoder().encodeToString(str.getBytes(Charset.forName("UTF-8")));
    String url1 = str_url+"?productId=87fd7829-e449-48f1-93f7-63a92b76bc84";

    public void getAllNetWorkString() {
        Loge("选择车型拼接str----",str);
        OkHttpClient build = new OkHttpClient.Builder()
                .sslSocketFactory(createSSLSocketFactory())
                .hostnameVerifier(new TrustAllHostnameVerifier())
                .build();
        final Request request;
        try {
            request = new Request.Builder()
                    .get()
                    .addHeader("timeStamp", timeStamp)
                    .addHeader("clientId", clientId)
                    .addHeader("sign", (HmacSHA256Util.HmacSHA256(base64str, key)).toUpperCase())
                    .addHeader("content-Type", "application/json;charset=UTF-8")
                    .addHeader("Connection", "Keep-Alive")
                    .url(url1).build();
//            Log.e("url1----",url1);
            Call call = build.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
//                    Log.e("----",e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response)
                        throws IOException {
                    String res = response.body().string();

                    JSONObject json;
                    try {
                        json = new JSONObject(res);
                        jsonArray = json.getJSONArray("rows");
                        if (jsonArray != null && jsonArray.length() != 0) {
                            getHttp(jsonArray.getJSONObject(0).getString("modelId"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


//                    Log.e("----",res + "success");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
//            Log.e("----",e.toString() + "Exception");
        }
    }

    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }

    }

    private static class TrustAllCerts implements X509TrustManager {

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllCerts()}, new SecureRandom());
            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }

        return ssfFactory;
    }



}