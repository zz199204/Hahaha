package com.example.administrator.hahaha.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

public class JiaDianWeiXiu extends Activity {
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.home_jdwx_fanhui)
    ImageView homeJdwxFanhui;
    @Bind(R.id.home_jdwx_btqr)
    Button homeJdwxBtqr;
    @Bind(R.id.home_jdwx_pinpai)
    TextView homeJdwxPinpai;
    @Bind(R.id.home_jdwx_leixing)
    TextView homeJdwxLeixing;
    @Bind(R.id.home_jdwx_xinghao)
    TextView homeJdwxXinghao;
    @Bind(R.id.home_jdwx_guzhang)
    TextView homeJdwxGuzhang;
    private List<MobileBean> list;
    int aa = -1;
    private List<MobileBean> list1;
    private List<MobileBean> list2;
    private List<MobileBean> list3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_jdwx);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.home_jdwx_fanhui, R.id.home_jdwx_btqr, R.id.home_jdwx_pinpai, R.id.home_jdwx_leixing, R.id.home_jdwx_xinghao, R.id.home_jdwx_guzhang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_jdwx_fanhui:
                Intent intent = new Intent(JiaDianWeiXiu.this, Mainactivity.class);
                startActivity(intent);
                break;
            case R.id.home_jdwx_btqr:
                Intent intent1 = new Intent(JiaDianWeiXiu.this, HuJiaoFuWu.class);
                startActivity(intent1);
                break;
            case R.id.home_jdwx_pinpai:
                RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/findByApplianceBrand");
                Y.get(params, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if ((Y.getRespCode(result))) {
                            list = JSON.parseArray(Y.getData(result), MobileBean.class);
                            OptionsPickerView pickerView = new OptionsPickerView.Builder(JiaDianWeiXiu.this, new OptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                    homeJdwxPinpai.setText(list.get(options1).getName());
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
            case R.id.home_jdwx_leixing:
                RequestParams params1 = new RequestParams("http://221.207.184.124:7071/yxg/findApplianceCategory");
                params1.addBodyParameter("pid", "" + list.get(aa).getId());
                Y.get(params1, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if ((Y.getRespCode(result))) {
                            list1 = JSON.parseArray(Y.getData(result), MobileBean.class);
                            OptionsPickerView pickerView = new OptionsPickerView.Builder(JiaDianWeiXiu.this, new OptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                    homeJdwxLeixing.setText(list1.get(options1).getName());
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
            case R.id.home_jdwx_xinghao:
                RequestParams params2 = new RequestParams("http://221.207.184.124:7071/yxg/findByApplianceModel");
                params2.addBodyParameter("pid", "" + list.get(aa).getId());
                params2.addBodyParameter("category", "" + list1.get(aa).getId());
                Y.get(params2, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if ((Y.getRespCode(result))) {
                            list2 = JSON.parseArray(Y.getData(result), MobileBean.class);
                            OptionsPickerView pickerView = new OptionsPickerView.Builder(JiaDianWeiXiu.this, new OptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                    homeJdwxXinghao.setText(list2.get(options1).getName());
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
            case R.id.home_jdwx_guzhang:
                RequestParams params3 = new RequestParams("http://221.207.184.124:7071/yxg/findPhoneFault");
                Y.get(params3, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if ((Y.getRespCode(result))) {
                            list3 = JSON.parseArray(Y.getData(result), MobileBean.class);
                            OptionsPickerView pickerView = new OptionsPickerView.Builder(JiaDianWeiXiu.this, new OptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                    homeJdwxGuzhang.setText(list3.get(options1).getName());
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
