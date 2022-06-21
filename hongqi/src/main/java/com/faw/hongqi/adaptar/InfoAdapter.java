package com.faw.hongqi.adaptar;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.faw.hongqi.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder>{
    Context context;
    JSONArray jsonArray;
    Info_onclick info_onclick;
    public InfoAdapter(Context context , JSONArray jsonArray, Info_onclick info_onclick){
        this.context = context;
        this.jsonArray = jsonArray;
        this.info_onclick = info_onclick;
    }
    @Override
    public InfoAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_over_, viewGroup, false);
        return new InfoAdapter.ViewHolder(view);
    }
    @Override
    public void onViewRecycled(InfoAdapter.ViewHolder holder) {
        super.onViewRecycled(holder);
    }
    @Override
    public void onBindViewHolder(final InfoAdapter.ViewHolder viewHolder, final int i) {
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            viewHolder.textView.setText(Html.fromHtml(jsonObject.getString("textcontent")));//imgpath
            if (jsonObject.getString("imgpath") != null && !jsonObject.getString("imgpath").equals("")){
                Glide.with(context).load(jsonObject.getString("imgpath")).into(viewHolder.imageView);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_onclick.infoItemClick1(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        Log.e("jsonarray----",String.valueOf(jsonArray.length()));
        return jsonArray.length();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_item_over);
            imageView = (ImageView) itemView.findViewById(R.id.image_info);
        }
    }
    public interface Info_onclick{
        void infoItemClick1(int position);
    }
}