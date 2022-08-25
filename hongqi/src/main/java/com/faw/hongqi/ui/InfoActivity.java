package com.faw.hongqi.ui;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.faw.hongqi.R;
import com.faw.hongqi.adaptar.InfoAdapter;
import com.faw.hongqi.view.PagingScrollHelper;
import org.json.JSONArray;
import org.json.JSONException;
public class InfoActivity extends Base_Act implements InfoAdapter.Info_onclick ,PagingScrollHelper.onPageChangeListener {
    RecyclerView recyclerView;
    PagingScrollHelper scrollHelper = new PagingScrollHelper();
    private LinearLayoutManager hLinearLayoutManager = null;
    private DividerItemDecoration hDividerItemDecoration = null;
    private RecyclerView.ItemDecoration lastItemDecoration = null;
    InfoAdapter infoAdapter;
    JSONArray jsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        findViewById(R.id.rela_chooes_type).setVisibility(View.GONE);
        findViewById(R.id.image_search).setVisibility(View.GONE);
        findViewById(R.id.image_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(InfoActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        Bundle bundle = this.getIntent().getExtras();
        //通过key得到value
        String title = bundle.getString("info");
        try {
            jsonArray = new JSONArray(title);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerView = (RecyclerView)findViewById(R.id.recy_info_text);
        infoAdapter = new InfoAdapter(this,jsonArray,this);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager1);
        recyclerView.setAdapter(infoAdapter);
        RecyclerView.LayoutManager layoutManager_ = null;
        RecyclerView.ItemDecoration itemDecoration = null;
        scrollHelper.setUpRecycleView(recyclerView);
        scrollHelper.setOnPageChangeListener(this);
        layoutManager_ = hLinearLayoutManager;
        itemDecoration = hDividerItemDecoration;
        if (layoutManager_ != null) {
            recyclerView.setLayoutManager(layoutManager_);
            recyclerView.removeItemDecoration(lastItemDecoration);
            recyclerView.addItemDecoration(itemDecoration);
            scrollHelper.updateLayoutManger();
            scrollHelper.scrollToPosition(0);
            lastItemDecoration = itemDecoration;
        }
        recyclerView.setHorizontalScrollBarEnabled(true);
        //获取总页数,采用这种方法才能获得正确的页数。否则会因为RecyclerView.State 缓存问题，页数不正确。
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
            }
        });
    }
    @Override
    public void infoItemClick1(int position) {
    }
    @Override
    public void onPageChange(int index) {
    }
}