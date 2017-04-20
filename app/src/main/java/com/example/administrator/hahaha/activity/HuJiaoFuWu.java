package com.example.administrator.hahaha.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.hahaha.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/18.
 */

public class HuJiaoFuWu extends Activity {
    @Bind(R.id.home_hjfw_fanhui)
    ImageView homeHjfwFanhui;
    @Bind(R.id.home_hjfw_qrfb)
    Button homeHjfwQrfb;
    @Bind(R.id.home_hjfw_sjxz)
    TextView homeHjfwSjxz;
    @Bind(R.id.home_hjfw_dzxz)
    TextView homeHjfwDzxz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_hjfw);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.home_hjfw_fanhui, R.id.home_hjfw_qrfb, R.id.home_hjfw_sjxz, R.id.home_hjfw_dzxz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_hjfw_fanhui:
                Intent intent = new Intent(HuJiaoFuWu.this, Mainactivity.class);
                startActivity(intent);
                break;
            case R.id.home_hjfw_qrfb:
                break;
            case R.id.home_hjfw_sjxz:
                break;
            case R.id.home_hjfw_dzxz:
                Intent intent1 = new Intent(HuJiaoFuWu.this, DiZhiGuanLi.class);
                startActivity(intent1);
                break;
        }
    }
}
