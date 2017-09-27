package com.absurd.ovalbuttom;

import android.animation.TypeEvaluator;
import android.graphics.Color;
import android.graphics.Point;

/**
 * Author: mr-absurd
 * Github: http://github.com/mr-absurd
 * Data: 2017/9/26.
 */

public class PointEvaluator implements TypeEvaluator<ObjectMessage> {
    @Override
    public ObjectMessage evaluate(float v, ObjectMessage start, ObjectMessage end) {
        int x = (int) (start.point.x + (end.point.x - start.point.x) * v);
        int color =  getColor(start.color, end.color, v);
        return new ObjectMessage(new Point(x, start.point.y), color);
    }


    public static int getColor(int mStartColor,int mEndColor,float radio) {
        int redStart = Color.red(mStartColor);
        int blueStart = Color.blue(mStartColor);
        int greenStart = Color.green(mStartColor);
        int redEnd = Color.red(mEndColor);
        int blueEnd = Color.blue(mEndColor);
        int greenEnd = Color.green(mEndColor);
        int red = (int) (redStart + ((redEnd - redStart) * radio + 0.5));
        int greed = (int) (greenStart + ((greenEnd - greenStart) * radio + 0.5));
        int blue = (int) (blueStart + ((blueEnd - blueStart) * radio + 0.5));
        return Color.argb(255,red, greed, blue);
    }




}
