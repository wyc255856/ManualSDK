package com.faw.hongqi.ui;

import static com.faw.hongqi.fragment.OverviewFragment.Loge;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;

import com.faw.hongqi.R;
import com.faw.hongqi.model.VersionUpdateModel;
import com.faw.hongqi.util.Constant;
import com.faw.hongqi.util.LoadAndUnzipUtil;
import com.faw.hongqi.util.LogUtil;
import com.faw.hongqi.util.NetWorkCallBack;
import com.faw.hongqi.util.PhoneUtil;
import com.google.gson.Gson;


/**
 * welcome，免责声明
 */
public class C229WelcomeActivity extends BaseActivity {

    public int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 2000;
    public View manua_mzsm;
    int time = 6;
    TextView next;



//    String str_url = "http://www.e-guides.faw.cn/c229plus_admin/index.php?m=home&c=index&a=get_car_info&car_name=C229";
    String str_url = "http://www.e-guides.faw.cn/hongqih9_admin/index.php?m=home&c=index&a=get_car_info&car_name=C229";
    private RelativeLayout rl_load_faile;
    private RelativeLayout rl_re;
    private RelativeLayout rl_can;

    @Override
    protected void initData() {
        setContentView(R.layout.activity_welcome);
        rl_load_faile = findViewById(R.id.rl_load_faile);
        rl_re = findViewById(R.id.rl_re);
        rl_can = findViewById(R.id.rl_can);
        rl_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        rl_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isUpdate();
            }
        });
        if (ContextCompat.checkSelfPermission(C229WelcomeActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestWritePermission();
        } else {
            isUpdate();
        }

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



//    String  str = HQExtendsProxy.getInstance(C229WelcomeActivity.this).getVehicleCfg();


    private void isUpdate() {
        //http://www.haoweisys.com/hongqih9_admin/index.php?m=home&c=index&a=get_car_info&car_name=E115
        //传大写E115 C229
        final String url;
        if ("C229".equals(Constant.CAR_TYPE)){
            url = str_url;
        }else {
            url = ("E115".equals(Constant.CAR_TYPE)) ? "http://www.e-guides.faw.cn/e115plus_admin/index.php?m=home&c=index&a=get_car_info&car_name=E115" : Constant.BASE_URL + "hongqih9_admin/index.php?m=home&c=index&a=get_car_info&car_name=" + Constant.CAR_TYPE;
        }
//                                                                                                                                                              http://www.e-guides.faw.cn/c229plus_admin/index.php?m=home&c=index&a=get_car_info&car_name=C229
        //        if("E115".equals(Constant.CAR_TYPE)){
//            final String url = "http://www.e-guides.faw.cn/e115plus_admin/index.php?m=home&c=index&a=get_car_info&car_name=E115";
//        }else{
//            url = Constant.BASE_URL + "hongqih9_admin/index.php?m=home&c=index&a=get_car_info&car_name=" + Constant.CAR_TYPE;
//        }


        //        if ("".equals(SharedpreferencesUtil.getVersionCode(C229WelcomeActivity.this))) {
        new Thread() {
            @Override
            public void run() {
                PhoneUtil.requestGet(url, new NetWorkCallBack() {
                    @Override
                    public void onSuccess(Object data) {
                        model = new Gson().fromJson((String) data, VersionUpdateModel.class);
                        Loge("下载数据----",model.toString());
                        LogUtil.logError("error  = 1111111");
                        runOnUiThread(new Runnable() {
                            public void run() {
                                if ("C235".equals(model.getCar_name())) {
                                    /*
                                     category_url = 'http://www.e-guides.faw.cn/hongqih9_admin/category.json',
	                                 news_url = 'http://www.e-guides.faw.cn/hongqih9_admin/news.json',
	                                 zip_url = 'http://www.e-guides.faw.cn/HONGQIH9/standard/c229-36images.zip',
	                                 game_web_url = 'http://www.e-guides.faw.cn/HONGQIH9/standard/web_mobile',
	                                 trim_web_url = 'http://www.e-guides.faw.cn/HONGQIH9/standard/pano_2',
                                    * */
                                    Constant.GAME_WEB_URL = model.getGame_web_url();//互动程序
                                }
                                Constant.TRIM_WEB_URL = model.getTrim_web_url();//内饰360
                                Constant.CAR_NAME = model.getCar_name().toLowerCase();//E115 - e115
                                Constant.ZIP_VERSION = model.getVersion();//36张图版本
                                Constant.ZIP_URL = model.getZip_url();//36张图
                                LoadAndUnzipUtil.startDownloadNews(C229WelcomeActivity.this, model.getNews_url(), model);
                                LoadAndUnzipUtil.startDownloadCategory(C229WelcomeActivity.this, model.getCategory_url());
                                rl_load_faile.setVisibility(View.GONE);
                            }
                        });
                    }

                    @Override
                    public void onFail(Object error) {
                        LogUtil.logError("error  = " + error);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        rl_load_faile.setVisibility(View.VISIBLE);
                                    }
                                });
                            }
                        }).start();
                    }
                });
            }
        }.start();
//        } else {
//            goC229MainActivity(C229WelcomeActivity.this, "Unupdate", model);
//            finish();
//        }

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
            handler.removeMessages(100001);
            handler.removeMessages(10000);
            handler.removeMessages(0);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private static final int WRITE_PERMISSION = 0x01;

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == WRITE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                isUpdate();
            } else {
                finish();
            }
        }
    }

    private void requestWritePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_PERMISSION);
            }
        }
    }
}
