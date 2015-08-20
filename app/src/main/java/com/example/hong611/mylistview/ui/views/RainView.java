package com.example.hong611.mylistview.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.example.hong611.mylistview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hong611 on 2015/8/20.
 */
public class RainView extends BaseView {
    private List<RainItem> rainItems = new ArrayList<>();
    private int rainNums;

    public RainView(Context context) {
        super(context);
    }

    public RainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RainView);
        rainNums = typedArray.getInt(R.styleable.RainView_rainNum, 50);
    }

    @Override
    protected void drawSub(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.Gold));
        canvas.drawCircle(600, 100, 40, paint);

        for (RainItem rainItem : rainItems)
            rainItem.drawRain(canvas);
    }

    @Override
    protected void logic() {
        for (RainItem rainItem : rainItems)
            rainItem.rainLogic();
    }

    @Override
    protected void init() {
        for (int i = 0; i < rainNums; i++) {
            rainItems.add(new RainItem(getWidth(), getHeight()));
        }
    }

    public void setRainNums(int nums) {
        rainNums = nums;
    }
}
