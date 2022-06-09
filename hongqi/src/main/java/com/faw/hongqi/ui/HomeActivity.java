package com.faw.hongqi.ui;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import com.faw.hongqi.R;
import com.faw.hongqi.fragment.BeginnersFragment;
import com.faw.hongqi.fragment.BrightFragment;
import com.faw.hongqi.fragment.OverviewFragment;
import com.faw.hongqi.fragment.ShouCeFragment;

public class HomeActivity extends Base_Act implements View.OnClickListener{
    View view_gl,view_ld,view_rm,view_sc;
    TextView text_gl,text_ld,text_rm,text_sc;
    OverviewFragment overviewFragment;
    BrightFragment brightFragment;
    BeginnersFragment beginnersFragment;
    ShouCeFragment shouCeFragment;
    FragmentManager fm;
    FragmentTransaction ft;
    ChooseType chooseType;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }
    public void init(){
        findViewById(R.id.rela_gl).setOnClickListener(this);
        findViewById(R.id.rela_ld).setOnClickListener(this);
        findViewById(R.id.rela_rm).setOnClickListener(this);
        findViewById(R.id.rela_sc).setOnClickListener(this);
        findViewById(R.id.image_search).setOnClickListener(this);
        findViewById(R.id.rela_chooes_type).setOnClickListener(this);
        view_gl = findViewById(R.id.view_gl);
        view_ld = findViewById(R.id.view_ld);
        view_rm = findViewById(R.id.view_rm);
        view_sc = findViewById(R.id.view_sc);
        text_gl = findViewById(R.id.text_gl);
        text_ld = findViewById(R.id.text_ld);
        text_rm = findViewById(R.id.text_rm);
        text_sc = findViewById(R.id.text_sc);
        text_gl.setTextColor(getResources().getColor(R.color.light_blue));
        overviewFragment = new OverviewFragment();
        chooseType = new OverviewFragment();
        brightFragment = new BrightFragment();
        beginnersFragment = new BeginnersFragment();
        shouCeFragment = new ShouCeFragment();
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.fragment_main, overviewFragment);
        ft.commit();
        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivityForResult(intent, 1);
            } else {
                //TODO 做你需要的事情
            }
        }
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rela_gl) {
            setGone(view_gl,text_gl);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, overviewFragment);
            ft.commit();
        }
        if (v.getId() == R.id.rela_ld) {
            setGone(view_ld,text_ld);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, brightFragment);
            ft.commit();
        }
        if (v.getId() == R.id.rela_rm) {
            setGone(view_rm,text_rm);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, beginnersFragment);
            ft.commit();
        }
        if (v.getId() == R.id.rela_sc) {
            setGone(view_sc,text_sc);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.replace(R.id.fragment_main, shouCeFragment);
            ft.commit();
        }
        if (v.getId() == R.id.image_search){
            Intent intent = new Intent();
            intent.setClass(HomeActivity.this,SearchActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.rela_chooes_type){
            chooseType.choose();
            setWindeo();
        }
    }
    public void setGone(View view,TextView text){
        view_gl.setVisibility(View.GONE);
        view_ld.setVisibility(View.GONE);
        view_rm.setVisibility(View.GONE);
        view_sc.setVisibility(View.GONE);
        view.setVisibility(View.VISIBLE);
        text_gl.setTextColor(getResources().getColor(R.color.text_d));
        text_ld.setTextColor(getResources().getColor(R.color.text_d));
        text_rm.setTextColor(getResources().getColor(R.color.text_d));
        text_sc.setTextColor(getResources().getColor(R.color.text_d));
        text.setTextColor(getResources().getColor(R.color.light_blue));
    }
    public interface ChooseType{
        void choose();
    }

    public void setWindeo(){
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams layoutParams=new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT
                ,0,0, PixelFormat.TRANSPARENT);
        layoutParams.flags= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE//表示当前Window不需要获取焦点，也不需要获取输入事件，事件会直接传递给下面的view
                |WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL//表示当前Window区域之外的单击事件向下传递，区域内部的事件由自己处理
                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;//window显示在锁屏之上
        layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        //透明层
        layoutParams.format=PixelFormat.TRANSPARENT;//不加这句可能会addView不上去
        LayoutInflater Inflater=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mainview=Inflater.inflate(R.layout.window_chooes,null);
        ListView listView = mainview.findViewById(R.id.list_choose);

        windowManager.addView(mainview,layoutParams);
    }

}