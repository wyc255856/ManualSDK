package com.faw.hongqi.ui;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.faw.hongqi.R;
import com.faw.hongqi.adaptar.PlanePagerAdapter;
import com.faw.hongqi.dbutil.DBUtil;
import com.faw.hongqi.fragment.BaseFragment;
import com.faw.hongqi.fragment.ContentFragment;
import com.faw.hongqi.model.ContentItemModel;
import com.faw.hongqi.model.NewsModel;
import com.faw.hongqi.util.Constant;
import com.faw.hongqi.widget.CirclePageIndicator;
//import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;


public class C229ContentActivity extends BaseActivity {

    ViewPager viewPager;
    TextView title;
    CirclePageIndicator circleView;
    PlanePagerAdapter adapter;
    ArrayList<BaseFragment> _dataList = new ArrayList<>();

    @Override
    protected void initData() {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_c229_content);
        changeModelToList();
        circleView = findViewById(R.id.circleView);
        viewPager = findViewById(R.id.viewpager);
        title = findViewById(R.id.tv_title_content);
        for (int i = 0; i < data_list.size(); i++) {
            ContentItemModel contentItemModel = data_list.get(i);
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", contentItemModel);
            ContentFragment contentFragment = new ContentFragment();
            contentFragment.setArguments(bundle);
            _dataList.add(contentFragment);

        }
        adapter = new PlanePagerAdapter((this).getSupportFragmentManager(), _dataList);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setCurrentItem(0);
    }

    @Override
    protected void initWidgetActions() {
        if (_dataList.size() == 1) {
            circleView.setVisibility(View.GONE);
        } else {
            circleView.setVisibility(View.VISIBLE);
        }
        circleView.setViewPager(viewPager);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                exitAPP();

            }
        });
        title.setText(newsModel.getTitle());
    }

    @Override
    boolean isHasTitle() {
        return true;
    }

    List<ContentItemModel> data_list = new ArrayList<>();
    NewsModel newsModel;

    private void changeModelToList() {
        newsModel = (NewsModel) getIntent().getSerializableExtra("data");
        //第一组
        if (newsModel.getTemplate1() != -1) {
//            String image = newsModel.getImage1();
//            String content = newsModel.getContent1();
//            String[] split_image = image.split(",");
//            String[] split_content = content.split(",");
//            for (int i = 0; i < split_image.length; i++) {
//                ContentItemModel contentItemMode = new ContentItemModel();
//                contentItemMode.setImage(split_image[i]);
//                contentItemMode.setContent(split_content[i]);
//                contentItemMode.setTemplate(newsModel.getTemplate1());
//                contentItemMode.setVideo(newsModel.getVideo1());
//                data_list.add(contentItemMode);
//            }
            ContentItemModel contentItemMode = new ContentItemModel();
            contentItemMode.setImage(newsModel.getImage1());
            contentItemMode.setContent(newsModel.getContent1_app());
            contentItemMode.setTemplate(newsModel.getTemplate1());
            contentItemMode.setVideo(newsModel.getVideo1());
            data_list.add(contentItemMode);
        }
        //第二组
        if (newsModel.getTemplate2() != -1) {
            ContentItemModel contentItemMode = new ContentItemModel();
            contentItemMode.setImage(newsModel.getImage2());
            contentItemMode.setContent(newsModel.getContent2_app());
            contentItemMode.setTemplate(newsModel.getTemplate2());
            contentItemMode.setVideo(newsModel.getVideo2());
            data_list.add(contentItemMode);
        }
        //第三组
        if (newsModel.getTemplate3() != -1) {
            ContentItemModel contentItemMode = new ContentItemModel();
            contentItemMode.setImage(newsModel.getImage3());
            contentItemMode.setContent(newsModel.getContent3_app());
            contentItemMode.setTemplate(newsModel.getTemplate3());
            contentItemMode.setVideo(newsModel.getVideo3());
            data_list.add(contentItemMode);
        }
        //第四组
        if (newsModel.getTemplate4() != -1) {
            ContentItemModel contentItemMode = new ContentItemModel();
            contentItemMode.setImage(newsModel.getImage4());
            contentItemMode.setContent(newsModel.getContent4_app());
            contentItemMode.setTemplate(newsModel.getTemplate4());
            contentItemMode.setVideo(newsModel.getVideo4());
            data_list.add(contentItemMode);
        }
        //第五组
        if (newsModel.getTemplate5() != -1) {
            ContentItemModel contentItemMode = new ContentItemModel();
            contentItemMode.setImage(newsModel.getImage5());
            contentItemMode.setContent(newsModel.getContent5_app());
            contentItemMode.setTemplate(newsModel.getTemplate5());
            contentItemMode.setVideo(newsModel.getVideo5());
            data_list.add(contentItemMode);
        }
        //第六组
        if (newsModel.getTemplate6() != -1) {
            ContentItemModel contentItemMode = new ContentItemModel();
            contentItemMode.setImage(newsModel.getImage6());
            contentItemMode.setContent(newsModel.getContent6_app());
            contentItemMode.setTemplate(newsModel.getTemplate6());
            contentItemMode.setVideo(newsModel.getVideo6());
            data_list.add(contentItemMode);
        }
        //第七组
        if (newsModel.getTemplate7() != -1) {
            ContentItemModel contentItemMode = new ContentItemModel();
            contentItemMode.setImage(newsModel.getImage7());
            contentItemMode.setContent(newsModel.getContent7_app());
            contentItemMode.setTemplate(newsModel.getTemplate7());
            contentItemMode.setVideo(newsModel.getVideo7());
            data_list.add(contentItemMode);
        }
        //第八组
        if (newsModel.getTemplate8() != -1) {
            ContentItemModel contentItemMode = new ContentItemModel();
            contentItemMode.setImage(newsModel.getImage8());
            contentItemMode.setContent(newsModel.getContent8_app());
            contentItemMode.setTemplate(newsModel.getTemplate8());
            contentItemMode.setVideo(newsModel.getVideo8());
            data_list.add(contentItemMode);
        }
        //第九组
        if (newsModel.getTemplate9() != -1) {
            ContentItemModel contentItemMode = new ContentItemModel();
            contentItemMode.setImage(newsModel.getImage9());
            contentItemMode.setContent(newsModel.getContent9_app());
            contentItemMode.setTemplate(newsModel.getTemplate9());
            contentItemMode.setVideo(newsModel.getVideo9());
            data_list.add(contentItemMode);
        }
        //第十组
        if (newsModel.getTemplate10() != -1) {
            ContentItemModel contentItemMode = new ContentItemModel();
            contentItemMode.setImage(newsModel.getImage10());
            contentItemMode.setContent(newsModel.getContent10_app());
            contentItemMode.setTemplate(newsModel.getTemplate10());
            contentItemMode.setVideo(newsModel.getVideo10());
            data_list.add(contentItemMode);
        }
    }

    public static void goContentActivity(Context context, NewsModel newsModel) {
//        if (Constant.TEST) {
//            newsModel = DBUtil.getTestModel(context);
//        }
        Intent intent = new Intent(context, C229ContentActivity.class);
        intent.putExtra("data", newsModel);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.in,
                R.anim.out);

    }

    private void exitAPP() {
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.AppTask> appTaskList = activityManager.getAppTasks();
        for (ActivityManager.AppTask appTask : appTaskList) {
            appTask.finishAndRemoveTask();
        }
    }
}
