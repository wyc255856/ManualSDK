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
import android.widget.RelativeLayout;
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
import com.faw.hongqi.util.LogUtil;

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
public class HomeActivity<IS_PRO> extends Base_Act implements View.OnClickListener {
    //底部导航栏样式横线
    View view_gl, view_ld, view_rm, view_sc;
    //底部导航栏文字
    TextView text_gl, text_ld, text_rm, text_sc;
    //4个fragment
    OverviewFragment overviewFragment;
    BrightFragment brightFragment;
    BeginnersFragment beginnersFragment;
    ShouCeFragment shouCeFragment;
    // Fragment管理类
    FragmentManager fm;
    FragmentTransaction ft;
    RelativeLayout rela_choose;
    RelativeLayout load;
    //车型选择列表弹窗
    Dialog dialog_choose;
    //车型列表
    ListView listView;
    SimpleAdapter simpleAdapter, adapter;
    List<Choose_Bean> list_choose;
    List<Map<String, String>> list_cars;
    List<String> list_carTypes;
    JSONArray jsonArray;
    String productId;
    TextView text_chooseType;
    // pro环境
    String url_pro = "https://fawivi-gw-public.faw.cn:63443/car";
    //    String url_pro = "https://fawivi-static-public.faw.cn:63443/car";
    //uat环境
    String url_uat = "https://fawivi-gw-public-uat.faw.cn:63443/car";
    //获取内容地址
    String str_url_info = Constant.IS_PRO ? url_pro + "/column/listAllPhone" : url_uat + "/column/listAllPhone";
    //    String str_url1 = "http://10.10.0.132:10088/car/column/listAllPhone";
//    String str_url = "http://10.10.0.132:10088/car/model/listModelByPhone";
    //获取车型地址
    String str_url_phone = Constant.IS_PRO ? url_pro + "/model/listModelByPhone" : url_uat + "/model/listModelByPhone";
    //    String str_url = "http://www.e-guides.faw.cn/c229plus_admin/index.php?m=home&c=index&a=get_car_info&car_name=C229";
//    String url = "http://115.28.72.235:10088/car/column/listAllPhone";
    String clientId = Constant.IS_PRO ? Constant.CLIENT_ID_PRO : Constant.CLIENT_ID_UAT;
    String timeStamp = String.valueOf(System.currentTimeMillis());
    String quretStrc100 = "productId=87fd7829-e449-48f1-93f7-63a92b76bc84";
    String quretStrc095 = "productId=309b716a-704d-42cc-8566-f77f0de9ca8c";
    String str_sign = "";

    String key = Constant.IS_PRO ? Constant.KEY_PRO : Constant.KEY_UAT;
    String base64str = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    //Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8))
    //初始设置
    public void init() {
//        textView = findViewById(R.id.text_c);
        //根据判断更换信息
        if (Constant.CAR_TYPE.equals("C095")) {
            productId = productIdc095;
//            textView.setText("C095");
            str_sign = clientId + quretStrc095 + timeStamp;
        } else {
            str_sign = clientId + quretStrc100 + timeStamp;
            productId = productIdc100;
//            textView.setText("C100");
        }
        rela_choose = (RelativeLayout) findViewById(R.id.rela_chooes_type);
        load = (RelativeLayout) findViewById(R.id.load);
        text_chooseType = (TextView) findViewById(R.id.text_choosecartype);
        base64str = Base64.getEncoder().encodeToString(str_sign.getBytes(StandardCharsets.UTF_8));
        list_choose = new ArrayList<>();
        list_carTypes = new ArrayList<>();
        list_cars = new ArrayList<>();
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
        getByPhoneHttp();
    }

    private boolean btn_load = true;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rela_gl) {
            if (btn_load) {
                return;
            }
            setGone(view_gl, text_gl);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, overviewFragment);
            ft.commit();
            rela_choose.setVisibility(View.VISIBLE);
        }
        if (v.getId() == R.id.rela_ld) {

            if (btn_load) {
                return;
            }
            setGone(view_ld, text_ld);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, brightFragment);
            ft.commit();
//            rela_choose.setVisibility(View.GONE);
        }
        if (v.getId() == R.id.rela_rm) {
            if (btn_load) {
                return;
            }
            setGone(view_rm, text_rm);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, beginnersFragment);
            ft.commit();
//            rela_choose.setVisibility(View.GONE);
        }
        if (v.getId() == R.id.rela_sc) {
            if (btn_load) {
                return;
            }
            setGone(view_sc, text_sc);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, shouCeFragment);
            ft.commit();
//            rela_choose.setVisibility(View.GONE);
        }
        if (v.getId() == R.id.image_search) {
            if (btn_load) {
                return;
            }
            Intent intent = new Intent();
            intent.setClass(HomeActivity.this, SearchActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.rela_chooes_type) {
            if (btn_load) {
                return;
            }
//            chooseType.choose(this,this,list_str);
            if (jsonArray != null && jsonArray.length() != 0) {
                //选择车型现实列表
                getchooselist(jsonArray);
            }
//            if (windowManager != null && view != null){
//                windowManager.removeView(view);
//            }
            if (listView.getVisibility() == View.VISIBLE) {
                listView.setVisibility(View.GONE);
            } else {
                listView.setVisibility(View.VISIBLE);
            }
        }
    }

    //底部导航栏点击效果
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

    //车型选择列表填充
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

    //115.28.72.235
    String productIdc095 = "309b716a-704d-42cc-8566-f77f0de9ca8c";
    String productIdc100 = "87fd7829-e449-48f1-93f7-63a92b76bc84";

    public void getInfoHttp(String modelId) {

                    /*.url(HTTP_Adss.HUIXINGURL + "/api/Account/Login?userName="+edit_name.getText().toString()+"&password="+edit_password.getText().toString())

                    .url("http://115.28.72.235:10088/car/column/listAllPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId=" + modelId)  // 本地测试 C100 获取全部内容

                    .url("http://115.28.72.235:10088/car/column/listAllPhone?productId="+productId+"&modelId=" + modelId)   // 本地测试 C095 获取全部内容

                    .url("http://fawivi-gw-public-uat.faw.cn:63443/car/column/listAllPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId="+modelId)  //UAT 环境获取内容

                    .url("https://fawivi-gw-public-uat.faw.cn:63443/car/model/listModelByPhone?productId=87fd7829-e449-48f1-93f7-63a92b76bc84")     //UAT环境获取车型 */

        String url_info = "";
        String quretStr_info = "";
//        String url_info = str_url1+"?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId="+modelId;
//        String quretStr_info = "modelId="+modelId+"&productId=87fd7829-e449-48f1-93f7-63a92b76bc84";
        if (Constant.CAR_TYPE.equals("C095")) {
            url_info = str_url_info + "?productId=309b716a-704d-42cc-8566-f77f0de9ca8c&modelId=" + modelId;
            quretStr_info = "modelId=" + modelId + "&productId=309b716a-704d-42cc-8566-f77f0de9ca8c";
        } else {
            url_info = str_url_info + "?productId=87fd7829-e449-48f1-93f7-63a92b76bc84&modelId=" + modelId;
            quretStr_info = "modelId=" + modelId + "&productId=87fd7829-e449-48f1-93f7-63a92b76bc84";
        }
        String str_info = clientId + quretStr_info + timeStamp;
        String base64str_info = Base64.getEncoder().encodeToString(str_info.getBytes(StandardCharsets.UTF_8));
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
                }

                @Override
                public void onResponse(Call call, Response response)
                        throws IOException {
                    String res = response.body().string();
                    JSONObject json;
                    JSONArray jsonArra;
                    try {
                        json = new JSONObject(res);
                        jsonArra = json.getJSONArray("rows");
                        if (jsonArra != null && jsonArra.length() != 0) {
                            getArray(jsonArra);
                        }
                        runOnUiThread(new Runnable() {
                            public void run() {
                                load.setVisibility(View.GONE);
                            }

                        });
                        btn_load = false;

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // C095   309b716a-704d-42cc-8566-f77f0de9ca8c;

    //  /car/model/listModelByPhone

    public void getchooselist(final JSONArray jsonArray) {
        for (int k = 0; k < jsonArray.length(); k++) {
            try {
                list_carTypes.add(jsonArray.getJSONObject(k).getString("modelName"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        for (int k = 0; k < list_carTypes.size(); k++) {
            Map<String, String> map = new HashMap<>();
            map.put("text", list_carTypes.get(k));
            list_cars.add(map);
        }
        adapter = new SimpleAdapter(this, list_cars, R.layout.window_over
                , new String[]{"text"}
                , new int[]{R.id.text_choosecartype});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    getInfoHttp(jsonArray.getJSONObject(position).getString("modelId"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listView.setVisibility(View.GONE);
                rela_choose.setVisibility(View.VISIBLE);
                setGone(view_gl, text_gl);
            }
        });
    }

    //log内容过多可使用此方法打印
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

    //获取内容json解析处理
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
                        } catch (IllegalStateException e) {
                        }
                    }
//                    if (s != null && s.equals("车型亮点")) {//返回json没有此项
                    brightFragment = newInstance_bright(jsonArray1.toString());
//                    }
                    if (s != null && s.equals("快速入门")) {
                        beginnersFragment = newInstance_geginners(jsonArray1.toString());
                    }
                    if (s != null && (s.equals("全量手册") || s.equals("手册"))) {
                        shouCeFragment = ShouCeFragment.newInstance_shouce(jsonArray1.toString());
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    //    String base64str = Base64.getEncoder().encodeToString(str.getBytes(Charset.forName("UTF-8")));
    String url1 = "";

    /*str_url+"?productId=87fd7829-e449-48f1-93f7-63a92b76bc84";*/
    //获取车型接口方法
    public void getByPhoneHttp() {
        if (Constant.CAR_TYPE.equals("C095")) {
            url1 = str_url_phone + "?productId=309b716a-704d-42cc-8566-f77f0de9ca8c";
        } else {
            url1 = str_url_phone + "?productId=87fd7829-e449-48f1-93f7-63a92b76bc84";
        }
        Loge("选择车型拼接str----", str_sign);
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
            Call call = build.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("----", e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response)
                        throws IOException {
                    String res = response.body().string();
                    Log.e("获取数据----", res);
                    JSONObject json;
                    try {
                        json = new JSONObject(res);
                        jsonArray = json.getJSONArray("rows");
                        if (jsonArray != null && jsonArray.length() != 0) {
                            getInfoHttp(jsonArray.getJSONObject(0).getString("modelId"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
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