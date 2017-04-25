package com.ml.expandable;

/**
 * Created by admin on 2017-04-25.
 */


import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

public class ExpandAnimation  extends Animation {

    private View mAnimatedView;
    private int mEndHeight;
    private int mType;
    public final static int COLLAPSE = 1;
    public final static int EXPAND = 0;
    private LinearLayout.LayoutParams mLayoutParams;

    /**
     * Initializes expand collapse animation, has two types, collapse (1) and expand (0).
     * @param view The view to animate
     * @param type The type of animation: 0 will expand from gone and 0 size to visible and layout size defined in xml.
     * 1 will collapse view and set to gone
     */
    public ExpandAnimation(View view, int type) {
        setDuration(500);
        mAnimatedView = view;
        int  width = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int  height = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(width,height);
        mEndHeight = view.getMeasuredHeight();
        mLayoutParams = ((LinearLayout.LayoutParams) view.getLayoutParams());
        mType = type;
        if(mType == EXPAND) {
            Log.e("tag","EXPAND="+mEndHeight);
            mLayoutParams.bottomMargin = -mEndHeight;
        } else {

            mLayoutParams.bottomMargin = 0;
        }
        view.setVisibility(View.VISIBLE);

    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        super.applyTransformation(interpolatedTime, t);
        if (interpolatedTime < 1.0f) {
            if(mType == EXPAND) {
                mLayoutParams.bottomMargin =  -mEndHeight + (int) (mEndHeight * interpolatedTime);
            } else {
                mLayoutParams.bottomMargin = - (int) (mEndHeight * interpolatedTime);
            }
            Log.d("ExpandCollapseAnimation", "anim height " + mLayoutParams.bottomMargin);
            mAnimatedView.requestLayout();
        } else {
            if(mType == EXPAND) {
                mLayoutParams.bottomMargin = 0;
                mAnimatedView.requestLayout();
            } else {
                mLayoutParams.bottomMargin = -mEndHeight;
                mAnimatedView.setVisibility(View.GONE);
                mAnimatedView.requestLayout();
            }
        }
    }
}