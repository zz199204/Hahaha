package com.example.administrator.hahaha.myapp;

import android.app.Application;

import org.xutils.x;

/**
 * Created by zykj on 2017/4/18.
 */

public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
