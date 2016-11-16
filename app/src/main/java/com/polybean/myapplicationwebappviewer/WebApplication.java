package com.polybean.myapplicationwebappviewer;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.polybean.myapplicationwebappviewer.adapter.CustomPageAdapter;
import com.polybean.myapplicationwebappviewer.webfrag.WebFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antony Lulciuc on 11/15/2016.
 */

public class WebApplication extends Application {
    private static List<Fragment> mPages = new ArrayList<>();
    public static List<String> Urls = new ArrayList<>();

    public CustomPageAdapter initAdapter(AppCompatActivity _activity) {
        return (new CustomPageAdapter(_activity.getSupportFragmentManager(), mPages));
    }
}
