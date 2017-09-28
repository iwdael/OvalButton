package com.absurd.ovalbuttom;

import android.graphics.Point;

/**
 * Author: mr-absurd
 * Github: http://github.com/mr-absurd
 * Data: 2017/9/26.
 */

public class ObjectMessage {
    public Point point;
    public int color;
    public int lineColor;

    public ObjectMessage(Point point, int color, int lineColor) {
        this.point = point;
        this.color = color;
        this.lineColor = lineColor;
    }
}
