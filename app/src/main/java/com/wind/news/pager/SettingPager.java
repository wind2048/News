package com.wind.news.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.wind.news.base.BasePager;

public class SettingPager extends BasePager {
    public SettingPager(Context context) {
        super(context);
    }
    public  void initData(){
        super.initData();
        tv_title.setText("设置中心");
        TextView textView=new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        fl_context.addView(textView);
        textView.setText("设置中心内容");
    }

}
