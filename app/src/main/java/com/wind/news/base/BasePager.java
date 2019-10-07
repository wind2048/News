package com.wind.news.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.wind.news.R;


public class BasePager {
    public final Context context;
    public TextView tv_title;
    public FrameLayout fl_context;
    /**
     * 视图，代表各个不同的页面
     */
    public View rootView;
    public BasePager(Context context){
        this.context=context;
        rootView=initView();
    }

    private View initView() {
  View view=View.inflate(context,R.layout.base_pager,null);
  tv_title=view.findViewById(R.id.tv_title);
  fl_context=view.findViewById(R.id.fl_content);
        return  view;
    }

    /**
     * 绑定数据
     */
    public void initData(){

    }
}
