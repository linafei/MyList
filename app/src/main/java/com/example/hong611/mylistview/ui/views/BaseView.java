package com.example.hong611.mylistview.ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hong611 on 2015/8/19.
 */
public abstract class BaseView extends View {
    protected MyThread myThread;

    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected abstract void drawSub(Canvas canvas);

    protected abstract void logic();

    protected abstract void init();

    @Override
    protected final void onDraw(Canvas canvas) {
        if (myThread == null) {
            myThread = new MyThread();
            myThread.start();
        } else {
            drawSub(canvas);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        running = false;
        super.onDetachedFromWindow();
    }

    private boolean running = true;

    private class MyThread extends Thread {
        @Override
        public void run() {

            init();
            while (running) {
                logic();
                postInvalidate();

                try {
                    sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
