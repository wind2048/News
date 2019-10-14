package com.wind.news.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wind.news.base.BasePager;
import com.wind.news.domain.NewsCenterPagerBean;
import com.wind.news.domain.NewsCenterPagerBean2;
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
                processData(result);

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

    /**
     * 解析json数据并显示
     * @param json
     */

    private void processData(String json) {
        NewsCenterPagerBean bean=parsedJson(json);
        NewsCenterPagerBean2 bean2=parsedJson2(json);
        String title=bean.getData().get(0).getChildren().get(1).getTitle();
        LogUtil.e("gson解析成功"+title);

        String title2=bean2.getData().get(0).getChildren().get(1).getTitle();
        LogUtil.e("使用gson解析成功"+title2);
    }


    /**
     * 解析json数据
     * @param
     * @return
     */

    private NewsCenterPagerBean parsedJson(String json) {
        Gson gson=new Gson();
        NewsCenterPagerBean bean=gson.fromJson(json,NewsCenterPagerBean.class);
        return  bean;
    }

    private NewsCenterPagerBean2 parsedJson2(String json) {
       return  new Gson().fromJson(json,NewsCenterPagerBean2.class);
    }


}
