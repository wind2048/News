package com.wind.news;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.wind.news.utils.CacheUtils;
import com.wind.news.utils.DensityUtils;

import java.util.ArrayList;

public class GuideActivity extends Activity {
    private ViewPager viewpager;
    private Button btn_start_main;
    private LinearLayout ll_point_group;
    private ImageView  iv_red_point;

    private ArrayList<ImageView> imageViews;
    //两点间距
    private int leftmax;

    private int widthdpi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewpager = findViewById(R.id.viewpager);
        btn_start_main=findViewById(R.id.btn_start_main);
        ll_point_group=findViewById(R.id.ll_point_group);
        iv_red_point=findViewById(R.id.iv_red_point);
        //准备数据
        int[] ids=new int[]{
                R.drawable.guide_1,
                R.drawable.guide_2,
                R.drawable.guide_3
        };
        widthdpi= DensityUtils.dip2px(this,10);
        imageViews=new ArrayList<>();
        for(int i=0;i<ids.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setBackgroundResource(ids[i]);
            imageViews.add(imageView);

            //创建点
            ImageView point=new ImageView(this);
            point.setBackgroundResource(R.drawable.point_normal);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(widthdpi,widthdpi);
            if(i!=0){
                params.leftMargin=widthdpi;
            }
            point.setLayoutParams(params);
            ll_point_group.addView(point);

        }
        viewpager.setAdapter(new MyPagerAdapter());
        //根据view的生命周期，当视图执行到onlayout或者ondraw的时候，视图的高和边距都有了
        iv_red_point.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener());
        viewpager.setOnPageChangeListener(new MyOnPageChangeListener());

        //设置按钮的点击事件
        btn_start_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //保存曾经进入过新闻中心
                CacheUtils.putBoolean(GuideActivity.this,MainActivity.START_MAIN,true);

                //跳转到新闻中心
                Intent intent=new Intent(GuideActivity.this,CenterActivity.class);
                startActivity(intent);

                //关闭引导页面
                finish();
            }
        });
    }
    class  MyOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        //位置，百分比，滑动的像素
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //两点间滑动距离对应的坐标=原来的起始位置+两点间移动的距离
            int leftmargin= position*leftmax+(int) (positionOffset*leftmax);
            RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) iv_red_point.getLayoutParams();
            params.leftMargin=leftmargin;
            iv_red_point.setLayoutParams(params);
        }

        @Override
        public void onPageSelected(int position) {
            if(position==imageViews.size()-1){
                btn_start_main.setVisibility(View.VISIBLE);
            }else{
                btn_start_main.setVisibility(View.GONE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    class MyOnGlobalLayoutListener implements ViewTreeObserver

            .OnGlobalLayoutListener{

        @Override
        public void onGlobalLayout() {
            iv_red_point.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            leftmax = ll_point_group.getChildAt(1).getLeft() - ll_point_group.getChildAt(0).getLeft();
        }
    }

    private class MyPagerAdapter extends PagerAdapter {


        @Override
        public Object instantiateItem( ViewGroup container, int position) {
            ImageView imageView=imageViews.get(position);
            container.addView(imageView);
            return  imageView;
        }

        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position,  Object object) {
           // super.destroyItem(container, position, object);
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject( View view,  Object object) {
           return view==object;
        }
    }
}
