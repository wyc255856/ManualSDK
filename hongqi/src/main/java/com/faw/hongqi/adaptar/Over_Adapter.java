package com.faw.hongqi.adaptar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.faw.hongqi.R;
import com.faw.hongqi.bean.Over_Bean;
import com.faw.hongqi.bean.Over_info;

import java.util.List;

public class Over_Adapter  extends RecyclerView.Adapter<Over_Adapter.ViewHolder>{
    Context context;
    List<Over_info> list;
    Over_onclick1 Over_onclick1;
    public Over_Adapter(Context context , List<Over_info> list, Over_Adapter.Over_onclick1 Over_onclick1){
        this.context = context;
        this.list = list;
        this.Over_onclick1 = Over_onclick1;
    }
    @Override
    public Over_Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_info, viewGroup, false);
        return new Over_Adapter.ViewHolder(view);
    }
    @Override
    public void onViewRecycled(Over_Adapter.ViewHolder holder) {
        super.onViewRecycled(holder);
    }
    @Override
    public void onBindViewHolder(final Over_Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.textView.setText(Html.fromHtml(list.get(i).getInfo()));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Over_onclick1.onItemClick1(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_item_over);
        }
    }
    public interface Over_onclick1{
        void onItemClick1(int position);
    }
}
