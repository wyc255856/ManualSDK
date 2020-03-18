package com.faw.hongqi.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

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

    @Override
    protected void initData() {
        setContentView(R.layout.activity_welcome);
//        requestWritePermission();
        isUpdate();
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
    int permissionCheck = PackageManager.PERMISSION_GRANTED;
    private static final int WRITE_PERMISSION = 0x01;
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    private void requestWritePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_PERMISSION);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == WRITE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                Log.d("tag", "Write Permission Failed");
                Toast.makeText(this, "You must allow permission write external storage to your mobile device.", Toast.LENGTH_SHORT).show();
                DBUtil.getAllNews(new TransactionListener() {
                    @Override
                    public void onResultReceived(Object result) {

                    }

                    @Override
                    public boolean onReady(BaseTransaction transaction) {
                        return false;
                    }

                    @Override
                    public boolean hasResult(BaseTransaction transaction, Object result) {
                        LogUtil.logError("result = "+result);
                        List<NewsModel> list= (List<NewsModel>) result;

                        for(NewsModel newsModel:list){
                            LogUtil.logError("catid = "+newsModel.getCatid());
                        }
                        return false;
                    }
                });

//                finish();
            }
        }
    }
}
