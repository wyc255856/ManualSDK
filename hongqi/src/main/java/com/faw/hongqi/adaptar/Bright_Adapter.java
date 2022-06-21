package com.faw.hongqi.adaptar;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.faw.hongqi.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class Bright_Adapter extends RecyclerView.Adapter<Bright_Adapter.ViewHolder>{
    Context context;
    JSONArray jsonArray;
    Bright_onclick1 bright_onclick1;
    public Bright_Adapter(Context context , JSONArray jsonArray, Bright_onclick1 bright_onclick1){
        this.context = context;
        this.jsonArray = jsonArray;
        this.bright_onclick1 = bright_onclick1;
    }
    @Override
    public Bright_Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_info, viewGroup, false);
        return new Bright_Adapter.ViewHolder(view);
    }
    @Override
    public void onViewRecycled(Bright_Adapter.ViewHolder holder) {
        super.onViewRecycled(holder);
    }
    @Override
    public void onBindViewHolder(final Bright_Adapter.ViewHolder viewHolder, final int i) {
//        viewHolder.textView.setText(Html.fromHtml(list.get(i).getInfo()));
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            viewHolder.textView.setText(Html.fromHtml(jsonObject.getString("textcontent")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bright_onclick1.brightonItemClick1(i);
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
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_item_over);
        }
    }
    public interface Bright_onclick1{
        void brightonItemClick1(int position);
    }
}