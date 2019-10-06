package com.wind.news.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;


import androidx.viewpager.widget.ViewPager;


import com.wind.news.R;
import com.wind.news.base.BaseFragment;

public class ContentFragment extends BaseFragment {

    private TextView textView;
    private ViewPager viewPager;
    private RadioGroup rg_main;

    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.content_fragment,null);
        viewPager=view.findViewById(R.id.viewPager);
        rg_main=view.findViewById(R.id.rg_main);
        return view;
    }
    public void initData(){
        super.initData();

        rg_main.check(R.id.rb_home);
    }
}

