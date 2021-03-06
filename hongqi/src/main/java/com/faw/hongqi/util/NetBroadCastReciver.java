package com.faw.hongqi.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.faw.hongqi.event.BroadCastEvent;

import org.greenrobot.eventbus.EventBus;

public class NetBroadCastReciver extends BroadcastReceiver {

    /**
     * 只有当网络改变的时候才会 经过广播。
     */
    @Override
    public void onReceive(Context context, Intent intent) {

        //此处是主要代码，
        //如果是在开启wifi连接和有网络状态下
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            if (NetworkInfo.State.CONNECTED == info.getState()) {
                //连接状态 处理自己的业务逻辑
//                EventBus.getDefault().post(new BroadCastEvent(SharePrefrence.BooleanBroadCast));
//                Toast.makeText(context, "网络链接成功", Toast.LENGTH_SHORT).show();
            } else {
                EventBus.getDefault().post(new BroadCastEvent());
//                Toast.makeText(context, "网络链接失败", Toast.LENGTH_SHORT).show();
            }
        }


    }

}
