package com.wind.news.base;

import android.content.Context;
import android.view.View;

public abstract  class MenuDetaiBasePager {
    /**
     * 上下文
     * @param context
     */
    public final  Context context;

    /**
     * 代表各个详情页面的视图
     * @param context
     */
    public View rootView;
    public MenuDetaiBasePager(Context context){
        this.context=context;
    }

    /**
     * 强制子类实现该抽象方法，每个页面实现不同的效果
     * @return
     */
    public abstract View initview();

    /**
     * 子页面需要绑定数据，联网请求数据
     */
    public void initData(){

    }
}
