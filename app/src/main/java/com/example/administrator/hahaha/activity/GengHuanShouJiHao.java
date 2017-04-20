package com.example.administrator.hahaha.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.hahaha.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/20 0020.
 */

public class GengHuanShouJiHao extends Activity {
    @Bind(R.id.home_ghsjh_fanhui)
    ImageView homeGhsjhFanhui;
    @Bind(R.id.home_ghsjh_shoujihao)
    EditText homeGhsjhShoujihao;
    @Bind(R.id.home_ghsjh_qr)
    Button homeGhsjhQr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_ghsjh);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.home_ghsjh_fanhui, R.id.home_ghsjh_qr})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_ghsjh_fanhui:
                Intent intentntent1=new Intent(GengHuanShouJiHao.this,BianJiDiZhi.class);
                startActivity(intentntent1);
                break;
            case R.id.home_ghsjh_qr:
                break;
        }
    }
}
