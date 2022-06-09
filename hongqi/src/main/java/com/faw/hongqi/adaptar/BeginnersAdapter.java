package com.faw.hongqi.adaptar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.faw.hongqi.R;

import java.util.List;

public class BeginnersAdapter extends RecyclerView.Adapter<BeginnersAdapter.ViewHolder>{
    Context context;
    List<Object> list;
    Dianjiansiji_onclick dianjian_onclick;
    public BeginnersAdapter(Context context , List<Object> list, Dianjiansiji_onclick dianjian_onclick){
        this.context = context;
        this.list = list;
        this.dianjian_onclick = dianjian_onclick;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_beginners, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
    }
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder,int i) {
//        viewHolder.text_siji.setText(list.get(i).getName());
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dianjian_onclick.onItemClick(i);
//            }
//        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_siji;
        public ViewHolder(View itemView) {
            super(itemView);
//            text_siji = (TextView) itemView.findViewById(R.id.text_dianjian_siji);
        }
    }
    public interface Dianjiansiji_onclick{
        void onItemClick(int position);
    }
}
