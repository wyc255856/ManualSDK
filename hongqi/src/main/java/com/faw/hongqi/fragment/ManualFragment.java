package com.faw.hongqi.fragment;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.faw.hongqi.R;
import com.faw.hongqi.adaptar.SortAdapter;
import com.faw.hongqi.dbutil.DBUtil;
import com.faw.hongqi.event.BaseEvent;
import com.faw.hongqi.event.SecondaryOnclickEvent;
import com.faw.hongqi.model.CategoryModel;
import com.faw.hongqi.model.CategoryModel_Table;
import com.faw.hongqi.model.NewsListModel;
import com.faw.hongqi.model.NewsModel;
import com.faw.hongqi.model.NewsModel_Table;
import com.faw.hongqi.util.Constant;
import com.faw.hongqi.util.LogUtil;
import com.faw.hongqi.util.PhoneUtil;
import com.faw.hongqi.widget.CheckListener;
import com.faw.hongqi.widget.ItemHeaderDecoration;
import com.faw.hongqi.widget.RvListener;
import com.raizlabs.android.dbflow.sql.language.CursorResult;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class ManualFragment extends BaseFragment implements CheckListener {

    List<CategoryModel> list = new ArrayList<>();
    List<NewsListModel> newsList = new ArrayList<>();
    /////
    private RecyclerView rvSort;
    private SortAdapter mSortAdapter;
    private SortDetailFragment mSortDetailFragment;
    private LinearLayoutManager mLinearLayoutManager;
    private int targetPosition;//点击左边某一个具体的item的位置
    private boolean isMoved;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_c229_mauna;
    }

    public void createFragment() {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        mSortDetailFragment = new SortDetailFragment(newsList, list);
        mSortDetailFragment.setListener(this);
        fragmentTransaction.add(R.id.lin_fragment, mSortDetailFragment);
        fragmentTransaction.commit();
    }

    private void initData1() {
        createFragment();
        List<String> lists = new ArrayList<>();
        //初始化左侧列表数据
        for (int i = 0; i < list.size(); i++) {
            lists.add(list.get(i).getCatname());
        }
        mSortAdapter = new SortAdapter(mContext, lists, new RvListener() {
            @Override
            public void onItemClick(int id, int position) {
                if (mSortDetailFragment != null) {
                    isMoved = false;
                    targetPosition = position;
                    setChecked(position, true);
                }
            }
        });
        rvSort.setAdapter(mSortAdapter);

    }

    private void setChecked(int position, boolean isLeft) {
        Log.d("p-------->", String.valueOf(position));
        if (isLeft) {
            mSortAdapter.setCheckedPosition(position);
            //此处的位置需要根据每个分类的集合来进行计算
            int count = 0;
            for (int i = 0; i < position; i++) {
                count += newsList.get(i).getRECORDS().size();
            }
            count += position;
            mSortDetailFragment.setData(count);
            ItemHeaderDecoration.setCurrentTag(String.valueOf(targetPosition));//凡是点击左边，将左边点击的位置作为当前的tag
        } else {
            if (isMoved) {
                isMoved = false;
            } else
                mSortAdapter.setCheckedPosition(position);
            ItemHeaderDecoration.setCurrentTag(String.valueOf(position));//如果是滑动右边联动左边，则按照右边传过来的位置作为tag

        }
        moveToCenter(position);


    }

    @Override
    public void check(int position, boolean isScroll) {
        setChecked(position, isScroll);
    }

    //将当前选中的item居中
    private void moveToCenter(int position) {
        //将点击的position转换为当前屏幕上可见的item的位置以便于计算距离顶部的高度，从而进行移动居中
        View childAt = rvSort.getChildAt(position - mLinearLayoutManager.findFirstVisibleItemPosition());
        if (childAt != null) {
            int y = (childAt.getTop() - (rvSort.getHeight() / 2) + PhoneUtil.dip2px(getActivity(), 30f));
            rvSort.smoothScrollBy(0, y);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void initData() {
        EventBus.getDefault().register(this);

        DBUtil.getManuaCategoryList(new QueryTransaction.QueryResultCallback() {
            @Override
            public void onQueryResult(@NonNull QueryTransaction transaction, @NonNull CursorResult tResult) {
                list = tResult.toList();
                LogUtil.logError("list size = " + list.size());
                ((Activity) mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initList();
                    }
                });

                tResult.close();//关闭资源
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView(View view) {
        rvSort = view.findViewById(R.id.rv_sort);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        rvSort.setLayoutManager(mLinearLayoutManager);
    }

    int dyCount = 0;

    @Override
    protected void initWidgetActions() {

    }

    @Override
    public void refreshData() {

    }

    //遍历二级级目录的index
    int newIndex = 0;
    //记录查询所需时间的起始时间
    long startTime = 0;

    private void initList() {
        if (Constant.CAR_NAME.equals("c229")) {
            //2022.7.28
            if (list.size() == 0){
                list.addAll(DBUtil.getlist());
            }

            list = list.subList(0, list.size());
        } else if (Constant.CAR_NAME.equals("e115")) {
            list = list.subList(0, list.size());

        }
//        secondaryListView.setDataList(list, SecondaryOnclickEvent.MANUAL);
        startTime = System.currentTimeMillis();
        getFastNewsList();

    }

    //是否禁止监听scoller事件
    private boolean isBanScorller = false;
    private int oldScollerDistance = 0;

    /**
     * 处理左边一级目录点击事件
     *
     * @param event
     */
    @Subscribe
    public void onEvent(BaseEvent event) {
        if (event instanceof SecondaryOnclickEvent) {
            SecondaryOnclickEvent secondaryOnclickEvent = (SecondaryOnclickEvent) event;
            if (SecondaryOnclickEvent.MANUAL == secondaryOnclickEvent.getType()) {
//                Toast.makeText(mContext, "点击了" + secondaryOnclickEvent.getIndex(), Toast.LENGTH_SHORT).show();
                LogUtil.logError("点击了 = " + +secondaryOnclickEvent.getIndex());
                //禁止监听scroller事件500毫秒
                isBanScorller = true;
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        isBanScorller = false;
                    }
                }.start();
                if (secondaryOnclickEvent.getIndex() == 0) {
                    dyCount = 0;
                } else {
                    dyCount = scrollerUpIndexs.get(secondaryOnclickEvent.getIndex() - 1);
                }

//                recyclerView.scrollToPosition(secondaryOnclickEvent.getIndex());
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 获取二级目录
     */
    private void getFastNewsList() {


        CategoryModel categoryModel = list.get(newIndex);

        SQLite.select().from(NewsModel.class).where(NewsModel_Table.catid.eq(categoryModel.getCatid()))
                .and(Constant.getCurrentIntProperty(mContext).eq(1))
                .async().queryResultCallback(
                new QueryTransaction.QueryResultCallback<NewsModel>() {
                    @Override
                    public void onQueryResult(@NonNull QueryTransaction<NewsModel> transaction,
                                              @NonNull CursorResult<NewsModel> tResult) {
                        NewsListModel newsListModel = new NewsListModel();
                        newsListModel.setRECORDS(tResult.toList());
                        newsList.add(newsListModel);
                        newIndex++;
                        if (newIndex < list.size()) {
                            getFastNewsList();
                        } else {
                            ((Activity) mContext).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    onDone();
                                }
                            });

                        }


                        tResult.close();//关闭资源
                    }
                }).execute();


    }

    //记录每段内容的所在y轴坐标
    private List<Integer> scrollerUpIndexs = new ArrayList<>();

    //当结束通过一级标签遍历二级目录
    private void onDone() {
        LogUtil.logError("查询栏目数据耗时" + (System.currentTimeMillis() - startTime) + "毫秒");
        LogUtil.logError("查询栏目数据长度 = " + newsList.size());
//        mAdapter.refreshData(newsList);
        int downIndex = 0;
//        List<Integer> lines = new ArrayList<>();
        for (int i = 0; i < newsList.size(); i++) {
            NewsListModel newsListModel = newsList.get(i);
            int newsSize = newsListModel.getRECORDS().size();
            int lineCount = Constant.IS_PHONE ? 4 : 4;
            int lineNum = 0;
            if (newsSize % lineCount == 0) {
                lineNum = newsSize / lineCount;
            } else {
                lineNum = (newsSize / lineCount) + 1;
            }
            downIndex += lineNum * PhoneUtil.dip2px(mContext, 240f);
            LogUtil.logError("downIndex = " + downIndex);
            scrollerUpIndexs.add(downIndex);
        }
        initData1();
    }
}
