package com.example.administrator.hahaha.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.administrator.hahaha.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/19 0019.
 */

public class DiZhiGuanLi extends Activity {
    @Bind(R.id.home_dzgl_fanhui)
    ImageView homeDzglFanhui;
    @Bind(R.id.home_dzgl_xinzeng)
    FrameLayout homeDzglXinzeng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_dzgl);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.home_dzgl_fanhui, R.id.home_dzgl_xinzeng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_dzgl_fanhui:
                Intent intent = new Intent(DiZhiGuanLi.this, HuJiaoFuWu.class);
                startActivity(intent);
                break;
            case R.id.home_dzgl_xinzeng:
                Intent intent1 = new Intent(DiZhiGuanLi.this, BianJiDiZhi.class);
                startActivity(intent1);
                break;
        }
    }
}
