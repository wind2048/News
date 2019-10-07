package com.wind.news.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import android.widget.RadioGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import com.wind.news.R;
import com.wind.news.base.BaseFragment;
import com.wind.news.base.BasePager;
import com.wind.news.pager.GovaffairPager;
import com.wind.news.pager.HomePager;
import com.wind.news.pager.NewsPager;
import com.wind.news.pager.SettingPager;
import com.wind.news.pager.SmartServicePager;
import com.wind.news.view.NoScrollViewPager;

import java.util.ArrayList;

public class ContentFragment extends BaseFragment {

    private TextView textView;
    private NoScrollViewPager viewPager;
    private RadioGroup rg_main;
    private ArrayList<BasePager> basePagers;

    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.content_fragment,null);
        viewPager=view.findViewById(R.id.viewPager);
        rg_main=view.findViewById(R.id.rg_main);
        return view;
    }
    public void initData(){
        super.initData();
        basePagers=new ArrayList<>();
        basePagers.add(new HomePager(context));
        basePagers.add(new NewsPager(context));
        basePagers.add(new SmartServicePager(context));
        basePagers.add(new GovaffairPager(context));
        basePagers.add(new SettingPager(context));


        //设置viewpager的适配器
        viewPager.setAdapter(new ContentFragmentAdapter());
        //设置radiogroup的选中状态的监听
        rg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //监听页面改变
        viewPager.addOnPageChangeListener(new MyOnPagerChangeListener());
        rg_main.check(R.id.rb_home);
        basePagers.get(0).initData();
    }
    class MyOnPagerChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        /**
         * 当页面被选中回调这个方法
         * @param position
         */
        @Override
        public void onPageSelected(int position) {
            basePagers.get(position).initData();
        }


        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_home:
                    viewPager.setCurrentItem(0,false);
                    break;
                case R.id.rb_newscenter:
                    viewPager.setCurrentItem(1,false);
                    break;
                case R.id.rb_smartservice:
                    viewPager.setCurrentItem(2, false);
                    break;
                case R.id.rb_govaffair:
                    viewPager.setCurrentItem(3,false);
                    break;
                case R.id.rb_setting:
                    viewPager.setCurrentItem(4,false);
                    break;
            }
        }
    }
    class ContentFragmentAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return basePagers.size();
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            BasePager basePager=basePagers.get(position);
            View rootview=basePager.rootView;
//            basePager.initData();
            container.addView(rootview);

            return rootview;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

    }


}




