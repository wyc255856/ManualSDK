package com.faw.hongqi.adaptar;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.faw.hongqi.R;
import com.faw.hongqi.bean.BeginnersBean;
import java.util.List;
public class BeginnersAdapter extends BaseAdapter {
    Context context;
    List<BeginnersBean> list;
    public BeginnersAdapter(Context context, List<BeginnersBean> list) {
        // TODO Auto-generated constructor stub
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {   // 循环多少次，我有多少项目就循环多少次
        // TODO Auto-generated method stub
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    @Override
    public View getView(int position, View view, ViewGroup arg2) {
        // TODO Auto-generated method stub
        view=LayoutInflater.from(context).inflate(R.layout.item_beginners, null);
        TextView text=(TextView)view.findViewById(R.id.text_item_beginners);
        ImageView image=(ImageView)view.findViewById(R.id.image_item_beginners_1);
        BeginnersBean beginnersBean = list.get(position);
        text.setText(beginnersBean.getName());
        Glide.with(context).load(list.get(position).getImageurl()).into(image);
        return view;
    }
}
