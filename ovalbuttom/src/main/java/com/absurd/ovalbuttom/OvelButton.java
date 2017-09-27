package com.absurd.ovalbuttom;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Author: mr-absurd
 * Github: http://github.com/mr-absurd
 * Data: 2017/9/26.
 */

public class OvelButton extends View {
    private int mWith;
    private int mHight;
    private int mRadius;
    private int mCircleColor;
    private int mUnpressColor;
    private int mPressedColor;
    private boolean mIsOpen = false;
    private Paint mPaint;
    private int mDration;
    private int mSideLineColor;
    private ObjectMessage mCurrentPoint;
    private Path mPath;
    private int mEdgeLineHeight;

    public OvelButton(Context context) {
        this(context, null);
    }

    public OvelButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OvelButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.OvelButton, defStyleAttr, 0);
        mCircleColor = ta.getColor(R.styleable.OvelButton_circleColor, Color.WHITE);
        mUnpressColor = ta.getColor(R.styleable.OvelButton_unPressColor, Color.GRAY);
        mPressedColor = ta.getColor(R.styleable.OvelButton_pressedColor, Color.GREEN);
        mDration = ta.getInteger(R.styleable.OvelButton_duration, 500);
        mSideLineColor = ta.getColor(R.styleable.OvelButton_sideLineColor, Color.GRAY);
        mEdgeLineHeight = (int) ta.getDimension(R.styleable.OvelButton_edgeLineWidth, 1);
        ta.recycle();
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int specModeWidth = MeasureSpec.getMode(widthMeasureSpec);
        float specWidth = MeasureSpec.getSize(widthMeasureSpec);
        int specModeHight = MeasureSpec.getMode(heightMeasureSpec);
        float specHight = MeasureSpec.getSize(heightMeasureSpec);
        if (specModeWidth == MeasureSpec.EXACTLY & specModeHight == MeasureSpec.EXACTLY) {
            if (specWidth / specHight > 5f / 3f) {
                specWidth = specModeHight * 5f / 3f;
            } else {
                specHight = specWidth * 3f / 5f;
            }
        } else {
            throw new RuntimeException("OvalButton onMeasure Error ! W:H = 5:3 ");
        }
        setMeasuredDimension((int) specWidth, (int) specHight);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mWith = getMeasuredWidth();
        mHight = getMeasuredHeight();
        mRadius = (int) (mHight * 0.45f);
        mCurrentPoint = new ObjectMessage(new Point(mHight / 2, mHight / 2), mUnpressColor);
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        mPath.reset();

        //background
        RectF bg = new RectF();
        bg.top = 0;
        bg.left = 0;
        bg.bottom = mHight;
        bg.right = mWith;
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mCurrentPoint.color);
        canvas.drawRoundRect(bg, mHight / 2, mHight / 2, mPaint);

        //background line
        mPath.addRoundRect(bg, mHight / 2, mHight / 2, Path.Direction.CCW);
        mPaint.setColor(mSideLineColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mEdgeLineHeight);
        canvas.drawPath(mPath, mPaint);

        //circle
        mPaint.reset();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mCircleColor);
        canvas.drawCircle(mCurrentPoint.point.x, mCurrentPoint.point.y, mRadius, mPaint);
        // circle line
        mPath.reset();
        mPath.addCircle(mCurrentPoint.point.x, mCurrentPoint.point.y, mRadius, Path.Direction.CCW);
        mPaint.setColor(mSideLineColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mEdgeLineHeight);
        canvas.drawPath(mPath, mPaint);
        canvas.restore();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mIsOpen = mIsOpen == true ? false : true;
                startAnimation(mIsOpen);
                return super.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }


    private void startAnimation(boolean isOpen) {
        ObjectMessage startPoint = new ObjectMessage(new Point(mHight / 2, mHight / 2), mUnpressColor);
        ObjectMessage endPoint = new ObjectMessage(new Point(mWith - mHight / 2, mHight / 2), mPressedColor);
        ValueAnimator anim;
        if (isOpen)
            anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        else
            anim = ValueAnimator.ofObject(new PointEvaluator(), endPoint, startPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurrentPoint = (ObjectMessage) animation.getAnimatedValue();
                invalidate();
            }
        });
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.setDuration(mDration);
        anim.start();
    }

    public boolean getStatus() {
        return mIsOpen;
    }


    public void setStatus(boolean open) {
        mIsOpen = open;
        invalidate();
    }
}
