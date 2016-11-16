package com.polybean.myapplicationwebappviewer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.polybean.myapplicationwebappviewer.webfrag.WebFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antony Lulciuc on 11/15/2016.
 */

public class CustomPageAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mPages;

    public CustomPageAdapter(FragmentManager _frameManager, List<Fragment> _pages) {
        super(_frameManager);
        mPages = _pages;
    }

    public void addPage(WebFragment _page){
        mPages.add(_page);
        this.notifyDataSetChanged();
    }

    public void removePage(int _position){
        mPages.remove(_position);
        this.notifyDataSetChanged();
    }

    @Override
    public android.support.v4.app.Fragment getItem(int _position) {
        return (mPages.get(_position));
    }

    @Override
    public int getCount() {
        return (mPages.size());
    }

    public void loadUrl(String _url, int _position){
        if (mPages.size() > 0)
            ((WebFragment)mPages.get(_position)).openUrl(_url);
        else{
            WebFragment webFragment = new WebFragment();
            webFragment.setUrl(_url);
            this.addPage(webFragment);
        }
    }



}
