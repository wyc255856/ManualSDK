package com.faw.hongqi.ui;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.faw.hongqi.R;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ShouCeChooseAct extends Base_Act{
    SimpleAdapter simpleAdapter;
    ListView listView;
    String jsonary;
    List<Map<String,String>> listn;
    int n = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoucechoose);
        listView = findViewById(R.id.list_dialog_shouce);
//        findViewById(R.id.rela_chooes_type).setVisibility(View.GONE);
        findViewById(R.id.image_search).setVisibility(View.GONE);
        listn = new ArrayList<>();
        Bundle bundle = this.getIntent().getExtras();
        //通过key得到value
        jsonary = bundle.getString("info");
        n = bundle.getInt("position");
        JSONArray jsonArr = null;
        try {
            jsonArr = new JSONArray(jsonary).getJSONObject(n).getJSONArray("sonContentlist");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setList(getData(jsonArr));
    }
    public void setList(List<Map<String, String>> list) {
        simpleAdapter = new SimpleAdapter(this, list, R.layout.item_shouce_list, new String[]{"shouce"}, new int[]{R.id.text_item_shouce});
        if (listView != null) {
            listView.setAdapter(simpleAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(ShouCeChooseAct.this, n+"----"+position, Toast.LENGTH_SHORT).show();
                    String ss = "";
                    try {
                        ss = new JSONArray(jsonary).getJSONObject(n).getJSONArray("sonContentlist").getJSONObject(position).getJSONArray("carContentTemplate").toString();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent();
                    intent.setClass(ShouCeChooseAct.this, InfoActivity.class);
                    Bundle bundle = new Bundle();        //创建bundle对象
                    bundle.putString("info",ss); //(String型)
                    intent.putExtras(bundle);        //通过intent绑定Bundle
                    startActivity(intent);

                }
            });
        }
    }
    private List<Map<String, String>> getData(JSONArray jsonArray) {
        listn.clear();
        if (jsonArray != null){
            for(int h = 0 ; h < jsonArray.length() ; h++){
                Map<String, String> map_1 = new HashMap<String, String>();
                try {
                    map_1.put("shouce", jsonArray.getJSONObject(h).getString("title"));                  //显示的文字信息
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listn.add(map_1);
            }
        }
        return listn;
    }
}