package com.example.administrator.hahaha.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;
import com.example.administrator.hahaha.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zykj on 2017/4/18.
 */

public class Mainactivity extends Activity {
    @Bind(R.id.textView2)
    TextView textView2;
    @Bind(R.id.textView4)
    TextView textView4;
    @Bind(R.id.textView3)
    ImageView textView3;
    @Bind(R.id.activity_main_sjwx)
    FrameLayout activityMainSjwx;
    @Bind(R.id.imageView7)
    ImageView imageView7;
    @Bind(R.id.activity_main_dnwx)
    FrameLayout activityMainDnwx;
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.imageView3)
    ImageView imageView3;
    @Bind(R.id.imageView2)
    ImageView imageView2;
    @Bind(R.id.activity_main_jdwx)
    FrameLayout activityMainJdwx;
    @Bind(R.id.banner)
    Banner banner;
    private List<Integer> path = new ArrayList<Integer>();
    private List<String> str = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        path.add(R.mipmap.a);
        path.add(R.mipmap.b);
        path.add(R.mipmap.c);
        path.add(R.mipmap.d);
        path.add(R.mipmap.e);
        str.add("1大卡麻子");
        str.add("2面包车");
        str.add("3牛车");
        str.add("4翻斗子");
        str.add("5老驴车");
        banner.setImageLoader(new MyImageloader());
        banner.setBannerTitles(str);
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        banner.setImages(path);
        banner.start();

    }

    @OnClick({R.id.activity_main_sjwx, R.id.activity_main_dnwx, R.id.activity_main_jdwx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_main_sjwx:
               Intent intent = new Intent(this, ShouJiWeiXiu.class);
                startActivity(intent);
                break;
            case R.id.activity_main_dnwx:
                Intent intent1 = new Intent(this, DianNaoWeiXiu.class);
                startActivity(intent1);
                break;
            case R.id.activity_main_jdwx:
                Intent intent2 = new Intent(this, JiaDianWeiXiu.class);
                startActivity(intent2);
                break;
        }
    }
    public class MyImageloader extends ImageLoader {


        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
