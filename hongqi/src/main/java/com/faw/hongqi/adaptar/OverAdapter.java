package com.faw.hongqi.adaptar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.faw.hongqi.R;
import com.faw.hongqi.bean.Over_Bean;

import java.util.List;

public class OverAdapter  extends RecyclerView.Adapter<OverAdapter.ViewHolder>{
    Context context;
    List<Over_Bean> list;
    Over_onclick over_onclick;
    public OverAdapter(Context context , List<Over_Bean> list, Over_onclick over_onclick){
        this.context = context;
        this.list = list;
        this.over_onclick = over_onclick;
    }
    @Override
    public OverAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_over, viewGroup, false);
        return new OverAdapter.ViewHolder(view);
    }
    @Override
    public void onViewRecycled(OverAdapter.ViewHolder holder) {
        super.onViewRecycled(holder);
    }
    @Override
    public void onBindViewHolder(final OverAdapter.ViewHolder viewHolder, int i) {
        viewHolder.text_name.setText(list.get(i).getName());
        Glide.with(context).load(list.get(i).getImage_o()).into(viewHolder.image_oice);
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
        private TextView text_name;
        private ImageView image_oice;
        public ViewHolder(View itemView) {
            super(itemView);
            text_name = (TextView) itemView.findViewById(R.id.text_item_over);
            image_oice = (ImageView) itemView.findViewById(R.id.image_item_over);
        }
    }
    public interface Over_onclick{
        void onItemClick(int position);
    }
}
