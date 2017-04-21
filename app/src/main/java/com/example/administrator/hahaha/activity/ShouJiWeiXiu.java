package com.example.administrator.hahaha.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.hss01248.dialog.StyledDialog;


import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/18.
 */

public class ShouJiWeiXiu extends Activity {
    @Bind(R.id.home_sjwx_pinpai)
    TextView homeSjwxPinpai;
    @Bind(R.id.home_sjwx_btpinpai)
    ImageView homeSjwxBtpinpai;
    @Bind(R.id.home_sjwx_xinghao)
    TextView homeSjwxXinghao;
    @Bind(R.id.home_sjwx_btxinghao)
    ImageView homeSjwxBtxinghao;
    @Bind(R.id.home_sjwx_guzhang)
    TextView homeSjwxGuzhang;
    @Bind(R.id.home_sjwx_btguzhang)
    ImageView homeSjwxBtguzhang;
    @Bind(R.id.home_sjwx_btqr)
    Button homeSjwxBtqr;
    int aa = -1;
    private static final String TAG = "ShouJiWeiXiu";
    @Bind(R.id.home_sjwx_fanhui)
    ImageView homeSjwxFanhui;
    private List<MobileBean> list;
    private List<MobileBean> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_sjwx);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.home_sjwx_btpinpai, R.id.home_sjwx_btxinghao, R.id.home_sjwx_btguzhang, R.id.home_sjwx_btqr, R.id.home_sjwx_fanhui})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_sjwx_fanhui:
                Intent intent1 = new Intent(ShouJiWeiXiu.this, Mainactivity.class);
                startActivity(intent1);
                break;
            case R.id.home_sjwx_btpinpai:
                // 手机品牌的选择     需要网络请求  去设置app 初始化
                RequestParams params = new RequestParams("http://221.207.184.124:7071/yxg/findPhoneBrand");
                Y.get(params, new Y.MyCommonCall<String>() {
                    @Override
                    public void onSuccess(String result) {
                        StyledDialog.dismissLoading();
                        if ((Y.getRespCode(result))) {
                            list = JSON.parseArray(Y.getData(result), MobileBean.class);
                            OptionsPickerView pickerView = new OptionsPickerView.Builder(ShouJiWeiXiu.this, new OptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                    homeSjwxPinpai.setText(list.get(options1).getName());
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
            case R.id.home_sjwx_btxinghao:
                if (aa == -1) {
                    Toast.makeText(this, "请先选择品牌", Toast.LENGTH_SHORT).show();
                } else {
                    RequestParams params1 = new RequestParams("http://221.207.184.124:7071/yxg/findPhoneModel");
                    params1.addBodyParameter("pid", "" + list.get(aa).getId());
                    x.http().get(params1, new Callback.CommonCallback<String>() {
                        @Override
                        public void onSuccess(String result) {
                            StyledDialog.dismissLoading();
                            if ("0".equals(JSON.parseObject(result).getString("resp_code"))) {
                                Log.i(TAG, "onSuccess: -------------成功-----");
                                //成功进行操作
                                String data = JSON.parseObject(result).getString("data").toString();
                                Log.i(TAG, "onSuccess: -------------成功-----" + data);
                                final List<MobileBean> list = JSON.parseArray(JSON.parseObject(result).getString("data"), MobileBean.class);
                                OptionsPickerView pickerView = new OptionsPickerView.Builder(ShouJiWeiXiu.this, new OptionsPickerView.OnOptionsSelectListener() {
                                    @Override
                                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                        homeSjwxXinghao.setText(list.get(options1).getName());
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
                                //失败
                                Log.i(TAG, "onSuccess: -------------失败-----");
                            }
                        }

                        @Override
                        public void onError(Throwable ex, boolean isOnCallback) {

                        }

                        @Override
                        public void onCancelled(CancelledException cex) {

                        }

                        @Override
                        public void onFinished() {

                        }
                    });
                }

                break;
            case R.id.home_sjwx_btguzhang:
                StyledDialog.buildLoading().show();
                RequestParams params1 = new RequestParams("http://221.207.184.124:7071/yxg/findPhoneFault");
                x.http().get(params1, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        StyledDialog.dismissLoading();
                        if ("0".equals(JSON.parseObject(result).getString("resp_code"))) {
                            Log.i(TAG, "onSuccess: -------------成功-----");
                            //成功进行操作
                            String data = JSON.parseObject(result).getString("data").toString();
                            Log.i(TAG, "onSuccess: -------------成功-----" + data);
                            final List<MobileBean> list = JSON.parseArray(JSON.parseObject(result).getString("data"), MobileBean.class);
                            OptionsPickerView pickerView = new OptionsPickerView.Builder(ShouJiWeiXiu.this, new OptionsPickerView.OnOptionsSelectListener() {
                                @Override
                                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                    homeSjwxGuzhang.setText(list.get(options1).getName());
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
                            //失败
                            Log.i(TAG, "onSuccess: -------------失败-----");
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
                break;
            case R.id.home_sjwx_btqr:
                Intent intent = new Intent(ShouJiWeiXiu.this, HuJiaoFuWu.class);
                startActivity(intent);
                break;
        }
    }
}
