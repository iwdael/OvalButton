package com.hacknife.ovalbutton;

import android.graphics.Point;

/**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : OvalButton
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
