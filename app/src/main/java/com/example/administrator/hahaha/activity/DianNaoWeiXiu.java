package com.example.administrator.hahaha.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bigkoo.pickerview.OptionsPickerView;
import com.example.administrator.hahaha.R;
import com.example.administrator.hahaha.bean.MobileBean;
import com.example.administrator.hahaha.gongju.Y;


import org.xutils.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/18.
 */

public class DianNaoWeiXiu extends Activity {


    @Bind(R.id.home_dnwx_fanhui)
    ImageView homeDnwxFanhui;
    @Bind(R.id.home_dnwx_btqr)
    Button homeDnwxBtqr;
    @Bind(R.id.home_dnwx_pinpai)
    TextView homeDnwxPinpai;
    @Bind(R.id.home_dnwx_leixing)
    TextView homeDnwxLeixing;
    @Bind(R.id.home_dnwx_xinghao)
    TextView homeDnwxXinghao;
    @Bind(R.id.home_dnwx_guzhang)
    TextView homeDnwxGuzhang;
    private List<MobileBean> list;
    int aa = -1;
    int bb = -1;
    int cc = -1;
    private List<MobileBean> list1;
    private List<MobileBean> list2;
    private List<MobileBean> list3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_dnwx);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.home_dnwx_fanhui, R.id.home_dnwx_btqr, R.id.home_dnwx_pinpai, R.id.home_dnwx_leixing, R.id.home_dnwx_xinghao, R.id.home_dnwx_guzhang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_dnwx_fanhui:
                Intent intent = new Intent(DianNaoWeiXiu.this, Mainactivity.class);
                startActivity(intent);
                break;
            case R.id.home_dnwx_btqr:
                Intent intent1 = new Intent(DianNaoWeiXiu.this, HuJiaoFuWu.class);
                startActivity(intent1);
                break;
            case R.id.home_dnwx_pinpai:
                Toast.makeText(this, "jinlaile", Toast.LENGTH_SHORT).show();
                RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/findComputerBrand");
                Y.get(params, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if ((Y.getRespCode(result))) {
                            list = JSON.parseArray(Y.getData(result), MobileBean.class);
                            OptionsPickerView pickerView = new OptionsPickerView.Builder(DianNaoWeiXiu.this, new OptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                    homeDnwxPinpai.setText(list.get(options1).getName());
                                    aa = options1;//当前选择的索引
                                }
                            }).build();
                            //把lists 进行转换
                            List<String> strs = new ArrayList<String>();
                            for (MobileBean mb : list) {
                                strs.add(mb.getName());
                            }
                            pickerView.setPicker(strs, null, null);
                            pickerView.show();
                        } else {
                            Y.t("解析失败");

                        }
                    }
                });

                break;
            case R.id.home_dnwx_leixing:
                RequestParams params1 = new RequestParams("http://221.207.184.124:7071/yxg/findComputerCategory");
                params1.addBodyParameter("pid", "" + list.get(aa).getId());
                Y.get(params1, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if ((Y.getRespCode(result))) {
                            list1 = JSON.parseArray(Y.getData(result), MobileBean.class);
                            OptionsPickerView pickerView = new OptionsPickerView.Builder(DianNaoWeiXiu.this, new OptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                    homeDnwxLeixing.setText(list1.get(options1).getName());
                                    aa = options1;//当前选择的索引
                                }
                            }).build();
                            //把lists 进行转换
                            List<String> strs = new ArrayList<String>();
                            for (MobileBean mb : list1) {
                                strs.add(mb.getName());
                            }
                            pickerView.setPicker(strs, null, null);
                            pickerView.show();
                        } else {
                            Y.t("解析失败");

                        }
                    }
                });

                break;
            case R.id.home_dnwx_xinghao:
                RequestParams params2 = new RequestParams("http://221.207.184.124:7071/yxg/findByComputerModel");
                params2.addBodyParameter("pid", "" + list.get(aa).getId());
                params2.addBodyParameter("category", "" + list1.get(aa).getId());
                Y.get(params2, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if ((Y.getRespCode(result))) {
                            list2 = JSON.parseArray(Y.getData(result), MobileBean.class);
                            OptionsPickerView pickerView = new OptionsPickerView.Builder(DianNaoWeiXiu.this, new OptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                    homeDnwxXinghao.setText(list2.get(options1).getName());
                                    aa = options1;//当前选择的索引
                                }
                            }).build();
                            //把lists 进行转换
                            List<String> strs = new ArrayList<String>();
                            for (MobileBean mb : list2) {
                                strs.add(mb.getName());
                            }
                            pickerView.setPicker(strs, null, null);
                            pickerView.show();
                        } else {
                            Y.t("解析失败");

                        }
                    }
                });


                break;
            case R.id.home_dnwx_guzhang:
                RequestParams params3 = new RequestParams("http://221.207.184.124:7071/yxg/findPhoneFault");
                Y.get(params3, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if ((Y.getRespCode(result))) {
                            list3 = JSON.parseArray(Y.getData(result), MobileBean.class);
                            OptionsPickerView pickerView = new OptionsPickerView.Builder(DianNaoWeiXiu.this, new OptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                    homeDnwxGuzhang.setText(list3.get(options1).getName());
                                    aa = options1;//当前选择的索引
                                }
                            }).build();
                            //把lists 进行转换
                            List<String> strs = new ArrayList<String>();
                            for (MobileBean mb : list3) {
                                strs.add(mb.getName());
                            }
                            pickerView.setPicker(strs, null, null);
                            pickerView.show();
                        } else {
                            Y.t("解析失败");

                        }
                    }
                });
                break;
        }
    }
}
