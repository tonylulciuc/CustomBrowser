package com.polybean.myapplicationwebappviewer;


import android.os.Handler;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;

import com.polybean.myapplicationwebappviewer.adapter.CustomPageAdapter;
import com.polybean.myapplicationwebappviewer.webfrag.WebFragment;

import java.util.Iterator;

import static com.polybean.myapplicationwebappviewer.WebApplication.Urls;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private CustomPageAdapter mCustomPageAdapter;
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebApplication wa = (WebApplication)getApplication();
        mCustomPageAdapter = wa.initAdapter(this);

        mViewPager    = (ViewPager)findViewById(R.id.pager);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.left_drawer);
        mViewPager.setAdapter(mCustomPageAdapter);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int size = Urls.size();
                Iterator<String> it = Urls.iterator();
                for (int i = 0; i < size; i++){
                    mCustomPageAdapter.loadUrl(it.next(), i);
                }
            }
        }, 100);
    }


    public void onHamburgerClick(View _view){
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT))
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        else
            mDrawerLayout.openDrawer(Gravity.LEFT);
    }

    public void onSearchClick(View _view){
        String url = ((EditText)findViewById(R.id.search)).getText().toString();
        int position =  mViewPager.getCurrentItem();
        if (!url.contains("http://")){
            url = "http://" + url;
        }

        if (position >= Urls.size())
            Urls.add(url);
        else
            Urls.add(position, url);
        mCustomPageAdapter.loadUrl(url, mViewPager.getCurrentItem());
    }

    public void onPrevPageClick(View _view){
        mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
    }

    public void onNextPageClick(View _view){
        mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
    }

    public void onAddNewPageClick(View _view){
        mCustomPageAdapter.addPage(new WebFragment());
    }

    public void onRemovePageClick(View _view){
        int position = mViewPager.getCurrentItem();

        Urls.remove(position);
        mCustomPageAdapter.removePage(position);
        mViewPager.removeViewAt(position);
        mViewPager.setAdapter(mCustomPageAdapter);
        mViewPager.setCurrentItem(position + 1);
    }

}
