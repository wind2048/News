package com.wind.news.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.wind.news.base.BasePager;

public class GovaffairPager extends BasePager {
    public GovaffairPager(Context context) {
        super(context);
    }
    public  void initData(){
        super.initData();
        tv_title.setText("政要指南");
        TextView textView=new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        fl_context.addView(textView);
        textView.setText("政要指南内容");
    }

}
