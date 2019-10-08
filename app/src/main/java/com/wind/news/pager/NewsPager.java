package com.wind.news.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.wind.news.base.BasePager;
import com.wind.news.utils.Constants;
import com.wind.news.utils.LogUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class NewsPager extends BasePager {
    public NewsPager(Context context) {
        super(context);
    }
    public  void initData(){
        super.initData();
        tv_title.setText("新闻中心");
        TextView textView=new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        fl_context.addView(textView);
        textView.setText("新闻中心内容");
        //联网请求数据
        getDataFromNet();
    }
    /**
     * 使用xUtils3联网请求数据
     */
    private void getDataFromNet() {
        RequestParams params=new RequestParams(Constants.NEWSCENTER_PAGER_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                LogUtil.e("xutils3联网成功"+result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("xutils3联网失败"+ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

}
