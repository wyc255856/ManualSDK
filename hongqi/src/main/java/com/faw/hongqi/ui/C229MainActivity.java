package com.faw.hongqi.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.faw.hongqi.R;
import com.faw.hongqi.event.BaseEvent;
import com.faw.hongqi.event.BroadCastEvent;
import com.faw.hongqi.event.CancelDownLoadEvent;
import com.faw.hongqi.fragment.BaseFragment;
import com.faw.hongqi.model.VersionModel;
import com.faw.hongqi.model.VersionUpdateModel;
import com.faw.hongqi.util.FragmentUtil;
import com.faw.hongqi.util.LoadAndUnzipUtil;
import com.faw.hongqi.util.LogUtil;
import com.faw.hongqi.util.NetBroadCastReciver;
import com.faw.hongqi.util.NetWorkCallBack;
import com.faw.hongqi.util.PhoneUtil;
import com.faw.hongqi.util.SharedpreferencesUtil;
import com.faw.hongqi.widget.TabView;
import com.google.gson.Gson;
import com.liulishuo.filedownloader.util.FileDownloadUtils;
import android.support.v4.app.FragmentManager;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import java.io.File;
import static com.faw.hongqi.ui.C229LoadAndUnzipFileActivity.goC229LoadAndUnzipFileActivity;

public class C229MainActivity extends BaseActivity {

    private BaseFragment currentFragment;
    private String currentTag;
    TabView tabView;
    View main_layout;
    private VersionModel bean = null;
    private RelativeLayout rl_load_faile;
    private RelativeLayout rl_ok;
    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
        deleteDir(new File(FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "horizon"
                + File.separator + "MyFolder"+"/news.json"));
        deleteDir(new File(FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "horizon"
                + File.separator + "MyFolder"+"/category.json"));
//        VersionUpdateModel model = (VersionUpdateModel) getIntent().getSerializableExtra("model");
//        if ("update".equals(getIntent().getStringExtra("tag"))) {
//            goC229LoadAndUnzipFileActivity(C229MainActivity.this, model);
//
//        } else {
//            final String id = SharedpreferencesUtil.getVersionCode(C229MainActivity.this).replace(".0", "");
//            //增量更新
//            new Thread() {
//                @Override
//                public void run() {
//                    PhoneUtil.requestGet("http://www.haoweisys.com/hongqih9_admin/index.php?m=home&c=index&a=get_new_info&version_no=" + id, new NetWorkCallBack() {
//                        @Override
//                        public void onSuccess(Object data) {
//                            bean = new Gson().fromJson((String) data, VersionModel.class);
//                            if ("".equals(bean.getVersion())) {
//                                //如果相同版本无需更新
//                            } else {
//                                runOnUiThread(new Runnable() {
//                                    public void run() {
//                                        LoadAndUnzipUtil.startDownloadNews(C229MainActivity.this, bean.getNews());
//                                        LoadAndUnzipUtil.startDownloadCategory(C229MainActivity.this, bean.getCategory());
//                                    }
//                                });
//                            }
//                        }
//
//                        @Override
//                        public void onFail(Object error) {
//                            LogUtil.logError("error======" + error.toString());
//                        }
//                    });
//                }
//            }.start();
//        }
    }
    /**
     * 设置网络监听
     */
    private void setBreoadcast() {
        BroadcastReceiver receiver=new NetBroadCastReciver();
        IntentFilter filter=new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_c229_main);
        tabView = findViewById(R.id.tab_view);
        rl_load_faile = findViewById(R.id.rl_load_faile);
        rl_ok = findViewById(R.id.rl_ok);
        setBreoadcast();
        tabView.setTabOnClickListener(new TabView.TabOnClickListener() {
            @Override
            public void onTabClickCallBack(String tag) {
                changeTabs(tag);

            }

        });
        rl_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl_load_faile.setVisibility(View.GONE);
            }
        });
        main_layout = findViewById(R.id.main_layout);
        changeTabs("0");
    }
    public void deleteDir(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();
            if (childFiles == null || childFiles.length == 0) {
                file.delete();
            }
            for (int index = 0; index < childFiles.length; index++) {
                deleteDir(childFiles[index]);
            }
        }
        file.delete();
    }
    @Override
    protected void initWidgetActions() {
        findViewById(R.id.main_back_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    boolean isHasTitle() {
        return true;
    }

    public void changeTabs(String tag) {
        if ("0".equals(tag)) {
            main_layout.setBackgroundResource(R.mipmap.c229_model_bg);
        } else {
            main_layout.setBackgroundResource(R.mipmap.theme1_main_bg);
        }
        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (currentFragment != null && !currentTag.equals(tag)) {
            BaseFragment subViewFragment = null;
            if (fm.findFragmentByTag(tag) != null) {
                subViewFragment = (BaseFragment) fm
                        .findFragmentByTag(tag);
                ft.hide(currentFragment).show(subViewFragment)
                        .commitAllowingStateLoss();
                currentTag = tag;
                currentFragment = subViewFragment;
            } else {
                subViewFragment = FragmentUtil.getFragment(Integer.valueOf(tag));

                if (subViewFragment != null) {
                    ft.hide(currentFragment)
                            .add(R.id.container, subViewFragment, tag)
                            .commitAllowingStateLoss();
                    currentTag = tag;
                    currentFragment = subViewFragment;
                }
            }
        } else if (currentFragment == null) {
            if (currentTag != null && currentTag.equals(tag)) {

            } else {
                BaseFragment subViewFragment = FragmentUtil.getFragment(Integer.valueOf(tag));

                if (subViewFragment != null) {
                    ft.replace(R.id.container, subViewFragment, tag);
                    ft.commit();// 提交
                    currentTag = tag;
                    currentFragment = subViewFragment;
                }
            }
        }
    }
    @Subscribe
    public void onEvent(BaseEvent event) {
        if (event instanceof CancelDownLoadEvent) {
            finish();
        }else if (event instanceof BroadCastEvent){
            rl_load_faile.setVisibility(View.VISIBLE);
        }
    }

    public static void goC229MainActivity(Context context, String tag, VersionUpdateModel model) {
        Intent intent = new Intent(context, C229MainActivity.class);
        intent.putExtra("tag", tag);
        intent.putExtra("model", model);
        context.startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
