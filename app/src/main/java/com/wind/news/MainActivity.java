package com.wind.news;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.wind.news.utils.CacheUtils;

public class MainActivity extends Activity {

    public static final String START_MAIN = "start_Main";
    private RelativeLayout rl_root;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl_root=findViewById(R.id.rl_root);
        AlphaAnimation aa=new AlphaAnimation(0,1);
        aa.setFillAfter(true);

        ScaleAnimation bb=new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        bb.setFillAfter(true);

        RotateAnimation cc=new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        cc.setFillAfter(true);
        AnimationSet set=new AnimationSet(false);
        set.addAnimation(aa);
        set.addAnimation(bb);
        set.addAnimation(cc);
        set.setDuration(2000);
        rl_root.startAnimation(set);
        set.setAnimationListener(new MyAnimationListener());
    }
    class MyAnimationListener implements  Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {



        }

        @Override
        public void onAnimationEnd(Animation animation) {
            //判断是否进入过主页面
            boolean isStartMain= CacheUtils.getBoolean(MainActivity.this,START_MAIN);
            Intent intent;
            if(isStartMain){
                //如果进入过主页面，直接进入主页面
                intent=new Intent(MainActivity.this,CenterActivity.class);

            }else {
                //如果没有进入过主页面，进入引导页面
                intent=new Intent(MainActivity.this,GuideActivity.class);


            }
            startActivity(intent);
            finish();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

}
