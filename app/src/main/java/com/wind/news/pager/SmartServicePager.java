package com.wind.news.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.wind.news.base.BasePager;

public class SmartServicePager extends BasePager {
    public SmartServicePager(Context context) {
        super(context);
    }
    public  void initData(){
        super.initData();
        tv_title.setText("智慧服务");
        TextView textView=new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        fl_context.addView(textView);
        textView.setText("智慧服务内容");
    }

}
