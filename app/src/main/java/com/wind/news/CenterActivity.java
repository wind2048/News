package com.wind.news;



import android.app.Activity;




import android.os.Bundle;

import com.wind.news.fragment.ContentFragment;

public class CenterActivity extends Activity {

    public static final String MAIN_CONTENT_TAG = "Main_content_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);


        initFragment();
    }
    private void initFragment(){
      getFragmentManager().beginTransaction().replace(R.id.fl_main_maincontent,new ContentFragment(),"Main_content_tag").commit();

    }
}
