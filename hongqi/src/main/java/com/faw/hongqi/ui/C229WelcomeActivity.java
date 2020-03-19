package com.faw.hongqi.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import android.os.Message;
import com.faw.hongqi.R;
import com.faw.hongqi.dbutil.DBUtil;
import com.faw.hongqi.model.NewsModel;
import com.faw.hongqi.model.VersionUpdateModel;
import com.faw.hongqi.util.LogUtil;
import com.faw.hongqi.util.NetWorkCallBack;
import com.faw.hongqi.util.PhoneUtil;
import com.faw.hongqi.util.SharedpreferencesUtil;
import com.google.gson.Gson;
import com.raizlabs.android.dbflow.runtime.transaction.BaseTransaction;
import com.raizlabs.android.dbflow.runtime.transaction.TransactionListener;

import java.util.List;

import static com.faw.hongqi.ui.C229MainActivity.goC229MainActivity;


/**
 * welcome，免责声明
 */
public class C229WelcomeActivity extends BaseActivity {
    public int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 2000;
    public View manua_mzsm;
    int time = 6;
    TextView next;
    @Override
    protected void initData() {
        setContentView(R.layout.activity_welcome);
        goMainActivity();

        isUpdate();
        LogUtil.logError("android.os.Build.VERSION.RELEASE = " + android.os.Build.VERSION.RELEASE);
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
    }

    @Override
    protected void initViews() {

    }
    private void goMainActivity() {
        handler.sendEmptyMessageDelayed(0, 2000);
    }
    @Override
    protected void initWidgetActions() {

    }

    @Override
    boolean isHasTitle() {
        return false;
    }

    private VersionUpdateModel model = null;

    private void isUpdate() {
        if ("".equals(SharedpreferencesUtil.getVersionCode(C229WelcomeActivity.this))) {
            new Thread() {
                @Override
                public void run() {
                    PhoneUtil.requestGet("http://www.haoweisys.com/hongqih9_admin/index.php?m=home&c=index&a=get_first_version", new NetWorkCallBack() {
                        @Override
                        public void onSuccess(Object data) {
                            model = new Gson().fromJson((String) data, VersionUpdateModel.class);
                            LogUtil.logError("error  = 1111111");
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    goC229MainActivity(C229WelcomeActivity.this, "update", model);
                                    finish();
                                }
                            });
                        }

                        @Override
                        public void onFail(Object error) {
                            LogUtil.logError("error  = " + error);
                        }
                    });
                }
            }.start();
        } else {
            goC229MainActivity(C229WelcomeActivity.this, "Unupdate", model);
            finish();
        }

    }
    public boolean onPause = false;

    @Override
    public void onPause() {
        LogUtil.logError("============onPause==============");
        super.onPause();
        onPause = true;
        handler.removeMessages(100001);
        handler.removeMessages(10000);
        handler.removeMessages(0);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(100001);
        handler.removeMessages(10000);
        handler.removeMessages(0);
    }
    @Override
    public void onResume() {
        super.onResume();
        if (onPause) {
            onPause = false;
            handler.sendEmptyMessageDelayed(100001, 1000);
        }
    }
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);

//            boolean isFirst = H5SharedpreferencesUtil.getIsFirst(com.faw.h5.H5ManuaWelecomActivity.this);
//            if (isFirst) {
//                if (msg.what == 0) {
//                    manua_mzsm.setVisibility(View.VISIBLE);
//                    handler.sendEmptyMessage(100001);
//                } else if (msg.what == 10000) {
//                    goNext();
//                } else if (msg.what == 100001) {
//                    if (time == 0) {
//                        goNext();
//                        return;
//                    }
//                    if (time > 3) {
//                        next.setText("剩余" + time + "秒");
//                    } else {
//                        next.setText("剩余" + time + "秒 跳过>");
//                    }
//                    time--;
//                    handler.sendEmptyMessageDelayed(100001, 1000);
//                }
//            } else {
//                goNext();
//            }
        }
    };
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
//
            handler.removeMessages(100001);
            handler.removeMessages(10000);
            handler.removeMessages(0);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
