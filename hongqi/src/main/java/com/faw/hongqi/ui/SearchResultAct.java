package com.faw.hongqi.ui;
import static com.faw.hongqi.fragment.OverviewFragment.Loge;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.faw.hongqi.R;

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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
public class SearchResultAct extends Base_Act{
    String searchresult;
    SimpleAdapter simpleAdapter;
    List<Map<String,String>> lists;
    ListView listView;
    JSONArray jsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoucechoose);
        listView = findViewById(R.id.list_dialog_shouce);
        Intent intent = getIntent();
        searchresult = intent.getStringExtra("searchresult");
        if (searchresult != null){
            post_1(searchresult);
        }
    }
    private void post_1(String s) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, s);
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("https://fawivi-gw-public-uat.faw.cn:63443/car/content/selectByTitle")
//                .url("https://10.10.0.135:10088/car/content/selectByTitle")
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Loge("搜索报错----",e.toString());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseString = response.body().string();
                try {
                    jsonArray = new JSONObject(responseString).getJSONArray("rows");
                    Loge("搜索----",String.valueOf(jsonArray.length()));
                    Loge("搜索----",jsonArray.toString());
                    setLists(jsonArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void setLists(final JSONArray jsonArray){
        lists = new ArrayList<>();
        for(int i = 0;i < jsonArray.length();i++){
            Map<String,String> map =new HashMap<>();
            try {
                map.put("result",jsonArray.getJSONObject(i).getString("title"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            lists.add(map);
        }
        simpleAdapter = new SimpleAdapter(SearchResultAct.this,lists,R.layout.item_shouce_list
                ,new String[]{"result"}
                ,new int[]{R.id.text_item_shouce});
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
                bundle.putString("info",ss); //(String型)
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
}