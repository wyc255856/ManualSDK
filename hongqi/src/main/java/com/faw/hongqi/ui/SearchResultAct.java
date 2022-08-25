package com.faw.hongqi.ui;

import static com.faw.hongqi.fragment.OverviewFragment.Loge;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.faw.hongqi.R;
import com.faw.hongqi.util.Constant;
import com.faw.hongqi.util.HmacSHA256Util;
import com.faw.hongqi.util.LogUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@RequiresApi(api = Build.VERSION_CODES.O)
public class SearchResultAct extends Base_Act {
    //输入搜索框的内容
    String searchresult;
    SimpleAdapter simpleAdapter;
    List<Map<String, String>> lists;
    ListView listView;
    JSONArray jsonArray;
    String clientId = Constant.IS_PRO ? Constant.CLIENT_ID_PRO : Constant.CLIENT_ID_UAT;
    String timeStamp = String.valueOf(System.currentTimeMillis());
    //    String quretStr = "productId=87fd7829-e449-48f1-93f7-63a92b76bc84";
    TextView text_noneinfo;
    String key = Constant.IS_PRO ? Constant.KEY_PRO : Constant.KEY_UAT;
    //    String base64str = Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoucechoose);
        listView = findViewById(R.id.list_dialog_shouce);
        text_noneinfo = (TextView) findViewById(R.id.text_noenInfo);
        Intent intent = getIntent();
        searchresult = intent.getStringExtra("searchresult");
        if (searchresult != null) {
            post_search(searchresult);
        }
    }
    //搜索接口
    public void post_search(String s) {
//        String quretStr_info = "title="+s+"&productId=87fd7829-e449-48f1-93f7-63a92b76bc84";
        String str_info = clientId + timeStamp;
        String base64str_info = Base64.getEncoder().encodeToString(str_info.getBytes(StandardCharsets.UTF_8));
        OkHttpClient build = new OkHttpClient.Builder()
                .sslSocketFactory(createSSLSocketFactory())
                .hostnameVerifier(new TrustAllHostnameVerifier())
                .build();
        final Request request;
       /* RequestBody formBody = new FormBody.Builder()
                .add("productId", "309b716a-704d-42cc-8566-f77f0de9ca8c")
                .add("productId", "5d27d49c-6aff-4cba-9aa4-d73af83a3a4c")//车型
                .build();*/
        RequestBody requestBody = new FormBody.Builder()
                .add("title", s)
                .add("productId", "87fd7829-e449-48f1-93f7-63a92b76bc84").build();
        try {
            request = new Request.Builder()
                    .post(requestBody)
                    .addHeader("timeStamp", timeStamp)
                    .addHeader("clientId", clientId)
                    .addHeader("sign", (HmacSHA256Util.HmacSHA256(base64str_info, key)).toUpperCase())
                    .addHeader("content-Type", "application/json;charset=UTF-8")
                    .addHeader("Connection", "Keep-Alive")
                    .url("https://fawivi-gw-public-uat.faw.cn:63443/car/content/selectByTitle").build();
            Call call = build.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    LogUtil.logError(e.getMessage());
                }
                @Override
                public void onResponse(Call call, Response response)
                        throws IOException {
                    String res = response.body().string();
                   /* CategoryListModel menuListModel = new Gson().fromJson(res, CategoryListModel.class);
                    if (menuListModel != null) {
                        categoryList = menuListModel.getRECORDS();
                        LogUtil.logError("数据长度" + menuListModel.getRECORDS().size());
                    }
                    LogUtil.logError(res + "success");*/
                    try {
                        jsonArray = new JSONObject(res).getJSONArray("rows");
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (jsonArray == null || jsonArray.length() == 0) {
                                            text_noneinfo.setVisibility(View.VISIBLE);
                                        } else {
                                            setLists(jsonArray);
                                            text_noneinfo.setVisibility(View.GONE);
                                        }
                                    }
                                });
                            }
                        }).start();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        text_noneinfo.setVisibility(View.VISIBLE);
                                    }
                                });
                            }
                        }).start();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.logError(e.toString() + "Exception");
        }
    }
    //搜索结果列表录入
    public void setLists(final JSONArray jsonArray) {
        lists = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            Map<String, String> map = new HashMap<>();
            try {
                map.put("result", jsonArray.getJSONObject(i).getString("title"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            lists.add(map);
        }
        simpleAdapter = new SimpleAdapter(SearchResultAct.this, lists, R.layout.item_shouce_list
                , new String[]{"result"}
                , new int[]{R.id.text_item_shouce});
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ss = "";
                try {
                    ss = jsonArray.getJSONObject(position).getJSONArray("carContentTemplate").toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent();
                intent.setClass(SearchResultAct.this, InfoActivity.class);
                Bundle bundle = new Bundle();        //创建bundle对象
                bundle.putString("info", ss); //(String型)
                intent.putExtras(bundle);        //通过intent绑定Bundle
                startActivity(intent);
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listView.setAdapter(simpleAdapter);
                    }
                });
            }
        }).start();
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