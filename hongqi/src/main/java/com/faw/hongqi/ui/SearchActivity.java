package com.faw.hongqi.ui;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.faw.hongqi.R;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class SearchActivity extends Base_Act{
    ListView listView;
    ImageView image_back,image_searching;
    EditText edit_search;
    private SimpleAdapter adapter;
    SharedPreferences sp;
    List<Map<String,String>> lists;
    private String TAG_USER_DATA = "data";
    SharedPreferences.Editor editor;
    List<String> list_str;
    TextView text_clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        listView = findViewById(R.id.list_search_history);
        //搜索记录封装列表list
        lists = new ArrayList<>();
        list_str = new ArrayList<>();
        //搜索记录暂存对象
        sp = getSharedPreferences(TAG_USER_DATA, Context.MODE_PRIVATE); //
        editor = sp.edit();
        image_back = findViewById(R.id.image_search_back);
        image_searching = findViewById(R.id.image_searching);
        edit_search = findViewById(R.id.edit_search);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        text_clear = (TextView)findViewById(R.id.text_clearRecord);
        //清空记录
        text_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();
                lists.clear();
                adapter.notifyDataSetChanged();
            }
        });
        //搜索记录列表适配器
        adapter = new SimpleAdapter(this,lists,R.layout.item_search_history
                ,new String[]{"text"}
                ,new int[]{R.id.text_search_history});
        listView.setAdapter(adapter);
        //搜索记录点击事件，自动输入到输入框
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (list_str.get(position) != null){
                    edit_search.setText(list_str.get(position));
                }
            }
        });
        //输入框监听事件
        edit_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    String search = edit_search.getText().toString().trim();
                    if (!TextUtils.isEmpty(search)){
                        if (edit_search.getText() != null && !edit_search.getText().toString().equals("")){
                            //判断重复
                            if (!getIsHave(edit_search.getText().toString())){
                                for (int k = 9 ; k >= 0 ; k--){
                                    String account = sp.getString("history"+k, "");
                                    if (account != null && !account.equals("")){
                                        int z = k+1;
                                        editor.putString("history"+z,account);
                                        editor.apply();
                                    }
                                }
                                editor.putString("history"+0,edit_search.getText().toString());
                                editor.apply(); // 提交保存,commit同步写入，有返回值，但是会造成调用它的线程阻塞，apply异步写入，无返回值！
                            }
                            JSONObject jsonObject = new JSONObject();
                            try {
                                jsonObject.put("productId","87fd7829-e449-48f1-93f7-63a92b76bc84");
                                jsonObject.put("title",edit_search.getText().toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Intent intent = new Intent();
                            intent.setClass(SearchActivity.this,SearchResultAct.class);
//                            intent.putExtra("searchresult",jsonObject.toString());
                            intent.putExtra("searchresult",edit_search.getText().toString());
                            startActivity(intent);
                        }
                    }
                    return true;
                }
                return false;
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        list_str.clear();
        lists.clear();
        //导入搜索记录暂存数据
        for(int n = 0 ; n < 10 ; n++){
            String account = sp.getString("history"+n, "");
            if (account != null && !account.equals("")){
                list_str.add(account);
            }
        }
        for (int k = 0 ; k < list_str.size();k++){
            Map<String,String> map = new HashMap<>();
            map.put("text",list_str.get(k));
            lists.add(map);
        }
        adapter.notifyDataSetChanged();
    }
    //记录是否已经存在
    public boolean getIsHave(String s){
        boolean ishave = false;
        if (s != null){
            for (int k = 0 ; k < list_str.size() ; k++){
                if (list_str.get(k).equals(s)){
                    ishave = true;
                }
            }
        }else {
            ishave = true;
        }
        return ishave;
    }
}