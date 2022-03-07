package com.faw.hongqi.ui;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.faw.hongqi.R;
import com.faw.hongqi.adaptar.GeneralAdapter;
import com.faw.hongqi.model.VersionUpdateModel;
import com.faw.hongqi.util.Constant;
import com.faw.hongqi.util.OnRecyclerItemClickListener;
import com.faw.hongqi.util.SharedpreferencesUtil;
import com.liulishuo.filedownloader.util.FileDownloadUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class C229SelectCarModelActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private List<String> list = new ArrayList();
    private List<String> list_id = new ArrayList();
    public static VersionUpdateModel model;
    private GeneralAdapter adapter;
    @Override
    protected void initData() {
        setContentView(R.layout.activity_c229_select_car_model);
        recyclerView = findViewById(R.id.select_car_model_list);
        model = (VersionUpdateModel) getIntent().getSerializableExtra("data");
        adapter = new GeneralAdapter(this,list,list_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < model.getType_list().size(); i++) {
            list.add(model.getType_list().get(i).getContent_desc());
            list_id.add(model.getType_list().get(i).getContent_id());
        }
        recyclerView.setAdapter(adapter);
        String url = FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "horizon"
                + File.separator + "MyFolder" + File.separator + Constant.CAR_NAME + "-36images";
        if (fileIsExists(url)) {
            //
        } else {
            startActivity(new Intent(C229SelectCarModelActivity.this, C229LoadAndUnzipFileActivity.class));
        }
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });
        adapter.setRecyclerItemClickListener(new OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(int Position, List<String> list) {
                        if (list.get(Position).equals("sdss")){
                            SharedpreferencesUtil.setCarModel(C229SelectCarModelActivity.this,"C229_1");
                        }else if (list.get(Position).equals("sdhh")){
                            SharedpreferencesUtil.setCarModel(C229SelectCarModelActivity.this,"C229_2");
                        }else if (list.get(Position).equals("sdzg")){
                            SharedpreferencesUtil.setCarModel(C229SelectCarModelActivity.this,"C229_3");
                        }else if (list.get(Position).equals("sdhh")){
                            SharedpreferencesUtil.setCarModel(C229SelectCarModelActivity.this,"C229_4");
                        }else if (list.get(Position).equals("zdss")){
                            SharedpreferencesUtil.setCarModel(C229SelectCarModelActivity.this,"C229_5");
                        }else if (list.get(Position).equals("zdzg")){
                            SharedpreferencesUtil.setCarModel(C229SelectCarModelActivity.this,"C229_6");
                        }else if (list.get(Position).equals("zdqj")){
                            SharedpreferencesUtil.setCarModel(C229SelectCarModelActivity.this,"C229_7");
                        }

            }
        });
    }

    //    private boolean isTopActivity(){
//        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
//        List<ActivityManager.RunningTaskInfo>  tasksInfo = am.getRunningTasks(1);
//        if(tasksInfo.size() > 0){
//            //应用程序位于堆栈的顶层  com.example.androidtest
//            if("com.haowei.wyc.hongqicare115".equals(tasksInfo.get(0).topActivity.getPackageName())){
//                return true;
//            }
//        }
//        return false;
//    }
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


    private boolean fileIsExists(String filePath) {
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
