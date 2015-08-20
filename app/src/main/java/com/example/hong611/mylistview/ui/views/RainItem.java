package com.example.hong611.mylistview.ui.views;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.hong611.mylistview.App;
import com.example.hong611.mylistview.R;

import java.util.Random;

/**
 * Created by hong611 on 2015/8/20.
 */
public class RainItem {
    private int width;
    private int height;

    private int startX;
    private int stopX;
    private int startY;
    private int stopY;
    private int sizeX;
    private int sizeY;
    private float speed;

    private Paint paint;

    private Random random;

    public RainItem(int width, int height) {
        this.width = width;
        this.height = height;

        init();
    }

    private void init() {
        random = new Random();

        sizeX = 5 + random.nextInt(20);
        sizeY = 10 + random.nextInt(50);
        startX = random.nextInt(width);
        stopX = startX + sizeX;
        startY = random.nextInt(height);
        stopY = startY + sizeY;
        speed = 0.2f + random.nextFloat();

        paint = new Paint();
        paint.setColor(App.ctx.getResources().getColor(R.color.stand_bg));
    }

    public void drawRain(Canvas canvas) {
        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }

    public void rainLogic() {
        startX += sizeX * speed;
        stopX += sizeX * speed;
        startY += sizeY * speed;
        stopY += sizeY * speed;

        if (startY > height || startX > width) {
            init();
        }
    }
}
