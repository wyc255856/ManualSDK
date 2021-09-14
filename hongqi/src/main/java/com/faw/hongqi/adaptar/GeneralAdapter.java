package com.faw.hongqi.adaptar;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.faw.hongqi.R;
import com.faw.hongqi.ui.C229MainActivity;
import com.faw.hongqi.ui.C229SelectCarModelActivity;
import com.faw.hongqi.util.OnRecyclerItemClickListener;
import com.faw.hongqi.util.SharedpreferencesUtil;

import java.util.List;

public class GeneralAdapter extends RecyclerView.Adapter<GeneralAdapter.MyViewHolder> {
    Context context;
    List<String> datas;
    List<String> data_id;

    //声明自定义的监听接口
    private OnRecyclerItemClickListener monItemClickListener;

    //提供set方法供Activity或Fragment调用
    public void setRecyclerItemClickListener(OnRecyclerItemClickListener listener){
        monItemClickListener=listener;
    }

    public GeneralAdapter(Context context, List<String> datas,List<String> data_id) {
        this.context = context;
        this.datas = datas;
        this.data_id = data_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.select_car_model_list_item, null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_cat_type);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, C229MainActivity.class));
                    if (monItemClickListener != null) {
                        monItemClickListener.onItemClick(getAdapterPosition(), data_id);
                    }
                }
            });
        }
    }
}
