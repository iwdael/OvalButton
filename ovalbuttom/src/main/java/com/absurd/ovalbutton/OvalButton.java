package com.absurd.ovalbutton;

import android.animation.Animator;
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

public class OvalButton extends View {
    private int mWith;
    private int mHight;
    private float mRealWidth;
    private float mRealHeight;
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
    private boolean mCurrentIsSliding = false;
    private float mAspectRatio = 5f / 2.8f;

    public OvalButton(Context context) {
        this(context, null);
    }

    public OvalButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OvalButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.OvalButton, defStyleAttr, 0);
        mCircleColor = ta.getColor(R.styleable.OvalButton_circleColor, Color.WHITE);
        mUnpressColor = ta.getColor(R.styleable.OvalButton_unPressColor, Color.GRAY);
        mPressedColor = ta.getColor(R.styleable.OvalButton_pressedColor, Color.GREEN);
        mDration = ta.getInteger(R.styleable.OvalButton_duration, 500);
        mSideLineColor = ta.getColor(R.styleable.OvalButton_sideLineColor, Color.GRAY);
        mEdgeLineHeight = (int) ta.getDimension(R.styleable.OvalButton_edgeLineWidth, 3);
        ta.recycle();
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mRealWidth = getMeasuredWidth();
        mRealHeight = getMeasuredHeight();
        if (mAspectRatio > 5.0f / 3.0f) {
            mHight = (int) mRealHeight;
            mWith = (int) (mRealHeight * 5.0f / 3.0f);
        } else {
            mWith = (int) mRealWidth;
            mHight = (int) (mRealWidth * 3.0f / 5.0f);
        }
        mWith = getMeasuredWidth();
        mHight = getMeasuredHeight();
        mRadius = (int) (mHight * 0.45f);
        mCurrentPoint = new ObjectMessage(new Point(mHight / 2, (int) (mRealHeight / 2)), mUnpressColor, mSideLineColor);
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        mPath.reset();
        mPaint.setAntiAlias(true);
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
//        mPath.addRoundRect(bg, mHight / 2, mHight / 2, Path.Direction.CCW);
//        mPaint.setColor(mSideLineColor);
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeWidth(mCurrentPoint.lineColor);
//        canvas.drawPath(mPath, mPaint);

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
                if (mCurrentIsSliding == false) {
                    mCurrentIsSliding = true;
                    mIsOpen = mIsOpen == true ? false : true;
                    startAnimation(mIsOpen);
                }
                break;
        }
        return true;
    }


    private void startAnimation(boolean isOpen) {
        ObjectMessage startPoint = new ObjectMessage(new Point(mHight / 2, mHight / 2), mUnpressColor, mSideLineColor);
        ObjectMessage endPoint = new ObjectMessage(new Point(mWith - mHight / 2, mHight / 2), mPressedColor, mPressedColor);
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
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                mCurrentIsSliding = false;
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

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
