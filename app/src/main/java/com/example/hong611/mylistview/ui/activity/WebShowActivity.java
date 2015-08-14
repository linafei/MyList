package com.example.hong611.mylistview.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;

import com.example.hong611.mylistview.R;
import com.example.hong611.mylistview.threads.HttpThread;


/**
 * Created by hong611 on 2015/8/14.
 */
public class WebShowActivity extends Activity {
    WebView webView;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_show_layout);

        initView();
    }

    private void initView() {
        webView = (WebView) findViewById(R.id.webview);

        new HttpThread("http://www.baidu.com", webView, handler).start();
    }
}
