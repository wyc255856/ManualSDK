package com.faw.hongqi.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.faw.hongqi.R;
import com.faw.hongqi.adaptar.GeneralAdapter;
import com.faw.hongqi.model.VersionUpdateModel;

import java.util.ArrayList;
import java.util.List;

public class C229SelectCarModelActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private List<String> list = new ArrayList();
    private VersionUpdateModel model;

    @Override
    protected void initData() {
        setContentView(R.layout.activity_c229_select_car_model);
        recyclerView = findViewById(R.id.select_car_model_list);
        model = (VersionUpdateModel) getIntent().getSerializableExtra("data");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < model.getType_list().size(); i++) {
            list.add(model.getType_list().get(i).getContent_desc());
        }

        recyclerView.setAdapter(new GeneralAdapter(this, list));
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initWidgetActions() {

    }

    @Override
    boolean isHasTitle() {
        return false;
    }
}
