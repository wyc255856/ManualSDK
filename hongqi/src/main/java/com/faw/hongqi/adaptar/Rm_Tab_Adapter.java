package com.faw.hongqi.adaptar;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.faw.hongqi.R;
import com.faw.hongqi.bean.RmTabBean;

import java.util.List;
public class Rm_Tab_Adapter extends RecyclerView.Adapter<Rm_Tab_Adapter.ViewHolder> {
    Context context;
    List<RmTabBean> list;
    RmTab_onclick1 rmTab_onclick1;
    public Rm_Tab_Adapter(Context context, List<RmTabBean> list, RmTab_onclick1 rmTab_onclick1) {
        this.context = context;
        this.list = list;
        this.rmTab_onclick1 = rmTab_onclick1;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tab_rm, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
    }
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
            viewHolder.text_1.setText(list.get(i).getTab());
            viewHolder.text_2.setText(list.get(i).getTab());
            if (list.get(i).isClick()){
                viewHolder.r.setVisibility(View.VISIBLE);
            }else {
                viewHolder.r.setVisibility(View.GONE);
            }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rmTab_onclick1.rmtabItemClick1(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_1;
        private RelativeLayout r;
        private TextView text_2;
        public ViewHolder(View itemView) {
            super(itemView);
            text_1 = (TextView) itemView.findViewById(R.id.text_item_tab_rm1);
            text_2 = (TextView) itemView.findViewById(R.id.text_item_tab_rm2);
            r = (RelativeLayout) itemView.findViewById(R.id.rela_item_tab_rm);
        }
    }
    public interface RmTab_onclick1 {
        void rmtabItemClick1(int position);
    }
}