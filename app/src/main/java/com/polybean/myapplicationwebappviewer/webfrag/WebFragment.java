package com.polybean.myapplicationwebappviewer.webfrag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.polybean.myapplicationwebappviewer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebFragment extends Fragment {
    private String mUrl;
    private WebView mWebView;
    private View mSelf;

    public WebFragment() {
        // Required empty public constructor
    }

    public WebFragment newInstance(String _url){
        WebFragment webFragment = new WebFragment();
        webFragment.setUrl(_url);
        return (webFragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mSelf = inflater.inflate(R.layout.fragment_web, container, false);
        mWebView = (WebView)mSelf.findViewById(R.id.viewport);
        openUrl(mUrl);
        return (mSelf);
    }

    public void openUrl(String _url){
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebClient());
        mWebView.loadUrl(_url);
        mWebView.requestFocus();
        setRetainInstance(true);
    }

    public void setUrl(String _url){
        mUrl = _url;
    }

    public String getUrl(){
        return (mUrl);
    }
}
