package com.polybean.myapplicationwebappviewer.webfrag;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Antony Lulciuc on 11/15/2016.
 */

public class WebClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return (true);
    }
}