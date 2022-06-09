package com.faw.hongqi.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.faw.hongqi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShouCeFragment extends Fragment implements View.OnClickListener {
    ListView listView;
    private SimpleAdapter adapter;
    List<Map<String,String>> lists;
    String[] s = {"安全须知","仪表组","组合仪表","防盗系统","多功能显示屏","废气注意事项","智能进入和启动","全景天窗"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shouce, container, false);
        listView = view.findViewById(R.id.list_shouce);
        lists = new ArrayList<>();
        for (int k = 0 ; k < s.length;k++){
            Map<String,String> map = new HashMap<>();
            map.put("text",s[k]);
            lists.add(map);
        }
        adapter = new SimpleAdapter(getContext(),lists,R.layout.item_shouce_list
                ,new String[]{"text"}
                ,new int[]{R.id.text_item_shouce});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
        return view;
    }
    @Override
    public void onClick(View v) {
    }
}