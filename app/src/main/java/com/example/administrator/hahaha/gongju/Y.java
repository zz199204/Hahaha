package com.example.administrator.hahaha.gongju;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.administrator.hahaha.bean.UserBean;
import com.hss01248.dialog.StyledDialog;
import com.orhanobut.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 工具类
 * Created by zykj on 2017/4/8.
 */

public  class  Y {
    public static Context context; //全局上下文

    public  static  boolean isLog=true; //控制日志打印的开关

     public  static UserBean U;





    /**
     * 吐司功能只需要传入一个 字符串
     * @param str
     */
    public static  void t(String  str){
        Toast.makeText(context,str, Toast.LENGTH_LONG).show();
    }

    /**
     * 输出log日志
     * @param str
     */
    public static  void i(String  str){
        if(isLog)
         Logger.i(str);
    }

    /**
     * 检测请求返回的数据是否正确
     */
    public static boolean getRespCode(String  result){
        if("0".equals(JSON.parseObject(result).getString("resp_code"))){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 如果成功获取数据
     */
    public static String getData(String  result){
        return JSON.parseObject(result).getString("data");
    }





    /**
     * get请求  返回成功回调
     * @param params
     * @param call
     * @return
     */
    public static Callback.Cancelable get(RequestParams params, MyCommonCall<String> call){
        StyledDialog.buildLoading().show();
        return   x.http().get(params, call);
    }
    /**
     * post请求  返回成功回调
     * @param params
     * @param call
     * @return
     */
    public static Callback.Cancelable post(RequestParams params, MyCommonCall<String> call){
        StyledDialog.buildLoading().show();
        return   x.http().post(params, call);
    }
    /**
       实现不需要外部完成的两个函数
     */
    public abstract  static class  MyCommonCall<String> implements Callback.CommonCallback<String>{
        @Override
        public void onFinished() {
            StyledDialog.dismissLoading();
        }

        @Override
        public void onCancelled(CancelledException cex) {}

        @Override
        public void onError(Throwable ex, boolean isOnCallback) {
            t("服务器异常");
            StyledDialog.dismissLoading();
            ex.printStackTrace();
        }
    }








}
