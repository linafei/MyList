package com.example.hong611.mylistview.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.example.hong611.mylistview.R;

import java.util.Random;

/**
 * Created by hong611 on 2015/8/19.
 */
public class LogicView extends BaseView {
    private float rx = 0;
    private Paint paint = new Paint();
    private String measureText = getResources().getString(R.string.logic_view);

    private int Red = 0;
    private int Green = 0;
    private int Blue = 0;
    private Random random = new Random();

    private int maxRadio;
    private int minRadio;

    private float radio = 20;
    private boolean largen = true;

    public LogicView(Context context) {
        super(context);
    }

    public LogicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LogicView);
        maxRadio = typedArray.getInt(R.styleable.LogicView_maxRadio, 80);
        minRadio = typedArray.getInt(R.styleable.LogicView_minRadio, 20);
    }

    @Override
    protected void drawSub(Canvas canvas) {
        paint.setTextSize(30);
        canvas.drawText(measureText, rx, 50, paint);

        paint.setARGB(0xff, Red, Green, Blue);
        canvas.drawCircle(250, 250, radio, paint);

    }

    @Override
    protected void logic() {
        if (rx > getWidth()) {
            rx = 0 - paint.measureText(measureText);
        } else {
            rx++;
        }
        Red = random.nextInt(255);
        Green = random.nextInt(255);
        Blue = random.nextInt(255);

        if (largen) {
            radio++;
            if (radio > maxRadio) {
                largen = false;
            }
        } else {
            radio--;
            if (radio < minRadio) {
                largen = true;
            }
        }
    }

    @Override
    protected void init() {

    }
}
