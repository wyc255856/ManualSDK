package com.faw.hongqi.ui;

import com.faw.hongqi.R;
import com.faw.hongqi.model.VersionUpdateModel;
import com.faw.hongqi.util.LogUtil;
import com.faw.hongqi.util.NetWorkCallBack;
import com.faw.hongqi.util.PhoneUtil;
import com.faw.hongqi.util.SharedpreferencesUtil;
import com.google.gson.Gson;
import static com.faw.hongqi.ui.C229MainActivity.goC229MainActivity;


/**
 * welcome，免责声明
 */
public class C229WelcomeActivity extends BaseActivity {

    @Override
    protected void initData() {
        setContentView(R.layout.activity_welcome);
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
        if("".equals(SharedpreferencesUtil.getVersionCode(C229WelcomeActivity.this))){
            new Thread() {
                @Override
                public void run() {
                    PhoneUtil.requestGet("http://www.haoweisys.com/hs5_admin/index.php?m=home&c=index&a=get_first_version", new NetWorkCallBack() {
                        @Override
                        public void onSuccess(Object data) {
                            model = new Gson().fromJson((String) data, VersionUpdateModel.class);
                            LogUtil.logError("error  = 1111111");
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    goC229MainActivity(C229WelcomeActivity.this, "update",model);
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
        }else{
            goC229MainActivity(C229WelcomeActivity.this, "Unupdate",model);
            finish();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
