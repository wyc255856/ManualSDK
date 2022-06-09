package com.faw.hongqi.ui;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.ImageView;
import com.faw.hongqi.R;
public class Base_Act extends FragmentActivity {
    ImageView image_search;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.act_base);
        image_search = findViewById(R.id.image_search);
    }
}