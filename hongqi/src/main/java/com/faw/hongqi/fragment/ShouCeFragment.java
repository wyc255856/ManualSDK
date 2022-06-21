package com.faw.hongqi.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.faw.hongqi.R;
import com.faw.hongqi.ui.ShouCeChooseAct;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ShouCeFragment extends Fragment implements View.OnClickListener {
    ListView listView;
    private SimpleAdapter adapter;
    List<Map<String,String>> lists,listn;
    List<String> list1;
    String jsonary;
    public static final ShouCeFragment newInstance_shouce(String jsonArray) {
        ShouCeFragment fragment = new ShouCeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("jsonArray", jsonArray);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shouce, container, false);
        listView = view.findViewById(R.id.list_shouce);
        listn = new ArrayList<>();
        list1 = new ArrayList<>();
        jsonary = getArguments().getString("jsonArray");
        if (jsonary != null){
            setlist1(jsonary);
        }
        lists = new ArrayList<>();
        for (int k = 0 ; k < list1.size();k++){
            Map<String,String> map = new HashMap<>();
            map.put("text",list1.get(k));
            lists.add(map);
        }
        adapter = new SimpleAdapter(getContext(),lists,R.layout.item_shouce_list
                ,new String[]{"text"}
                ,new int[]{R.id.text_item_shouce});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ShouCeChooseAct.class);
                Bundle bundle = new Bundle();        //创建bundle对象
                bundle.putString("info",jsonary); //(String型)
                bundle.putInt("position",position);
                intent.putExtras(bundle);        //通过intent绑定Bundle
                startActivity(intent);
            }
        });
        return view;
    }
    public void setlist1(String jsonary){
        JSONArray jsonArray;
        try {
            jsonArray = new JSONArray(jsonary);
            for (int n = 0 ; n < jsonArray.length() ; n++){
                list1.add(jsonArray.getJSONObject(n).getString("columnName"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onClick(View v) {
    }
}