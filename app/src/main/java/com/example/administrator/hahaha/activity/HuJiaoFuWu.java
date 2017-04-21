package com.example.administrator.hahaha.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.example.administrator.hahaha.R;
import com.example.administrator.hahaha.bean.MobileBean;
import com.example.administrator.hahaha.gongju.OptionsPicke;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
    private static final String TAG = "HuJiaoFuWu";

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
                ArrayList<String> strs1 = new ArrayList<String>();
                strs1.add("今天");
                strs1.add("明天");
                strs1.add("后天");
                ArrayList<ArrayList<String>> strs2 = new ArrayList<ArrayList<String>>();
                ArrayList<String> l1 = new ArrayList<>();
                ArrayList<String> l2 = new ArrayList<>();
                ArrayList<String> l3 = new ArrayList<>();
                for (int a = 0; a <10 ; a++) {
                    l1.add(a+"点");
                    l2.add(a+"点");
                    l3.add(a+"点");
                }
                strs2.add(l1);
                strs2.add(l2);
                strs2.add(l3);
                ArrayList<ArrayList<ArrayList<String>>> strs3 = new ArrayList<ArrayList<ArrayList<String>>>();
                ArrayList<ArrayList<String>> ll1 = new ArrayList<>();
                ArrayList<ArrayList<String>> ll2 = new ArrayList<>();
                ArrayList<ArrayList<String>> ll3 = new ArrayList<>();
                ArrayList<String> l4 = new ArrayList<>();
                ArrayList<String> l5 = new ArrayList<>();
                ArrayList<String> l6 = new ArrayList<>();
                for (int i = 0; i <= 24; i++) {
                    l4.add(i + "点");
                    l5.add(i + "点");
                    l6.add(i + "点");
                }
                ll1.add(l4);
                ll2.add(l5);
                ll3.add(l6);
                strs3.add(ll1);
                strs3.add(ll2);
                strs3.add(ll3);
                OptionsPickerView pickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {

                    }
                }).build();
                pickerView.setPicker(strs1, strs2, strs3);
                pickerView.show();


                break;
            case R.id.home_hjfw_dzxz:
                Intent intent1 = new Intent(HuJiaoFuWu.this, DiZhiGuanLi.class);
                startActivity(intent1);
                break;
        }
    }
}
