package com.example.hong611.mylistview.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.hong611.mylistview.R;
import com.example.hong611.mylistview.threads.HttpThread;

/**
 * Created by hong611 on 2015/8/14.
 */
public class ImageShowActivity extends Activity {
    ImageView imageView;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_show_layout);

        initView();
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.image_from_web);

        new HttpThread("http://f.hiphotos.baidu.com/zhidao/pic/item/4afbfbedab64034f75411f70afc379310a551d33.jpg", imageView, handler)
                .start();
    }
}
