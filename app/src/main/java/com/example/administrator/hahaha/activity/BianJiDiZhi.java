package com.example.administrator.hahaha.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.administrator.hahaha.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/19 0019.
 */

public class BianJiDiZhi extends Activity {

    @Bind(R.id.home_bjdz_fanhui)
    ImageView homeBjdzFanhui;
    @Bind(R.id.home_bjdz_xingming)
    EditText homeBjdzXingming;
    @Bind(R.id.home_bjdz_shoujihao)
    TextView homeBjdzShoujihao;
    @Bind(R.id.home_bjdz_dizhi)
    EditText homeBjdzDizhi;
    @Bind(R.id.home_bjdz_switch)
    Switch homeBjdzSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_bianjidizhi);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.home_bjdz_fanhui, R.id.home_bjdz_shoujihao, R.id.home_bjdz_switch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_bjdz_fanhui:
                Intent intentntent=new Intent(BianJiDiZhi.this,DiZhiGuanLi.class);
                startActivity(intentntent);
                break;
            case R.id.home_bjdz_shoujihao:
                Intent intentntent1=new Intent(BianJiDiZhi.this,GengHuanShouJiHao.class);
                startActivity(intentntent1);
                break;
            case R.id.home_bjdz_switch:
                break;
        }
    }
}
