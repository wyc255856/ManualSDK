package com.faw.hongqi.adaptar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.faw.hongqi.R;
import com.faw.hongqi.bean.Over_Bean;
import java.util.List;
public class OverAdapter extends RecyclerView.Adapter<OverAdapter.ViewHolder>{
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
    public void onBindViewHolder(final OverAdapter.ViewHolder viewHolder, final int i) {
        if (list.get(i).isIsup()){
            Glide.with(context).load(list.get(i).getImage_u()).into(viewHolder.image_oice);
        }else {
            Glide.with(context).load(list.get(i).getImage_o()).into(viewHolder.image_oice);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                over_onclick.onItemClick(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        Log.e("list有多少----",String.valueOf(list.size()));
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_oice;
        public ViewHolder(View itemView) {
            super(itemView);
            image_oice = (ImageView) itemView.findViewById(R.id.image_item_over);
        }
    }
    public interface Over_onclick{
        void onItemClick(int position);
    }
}