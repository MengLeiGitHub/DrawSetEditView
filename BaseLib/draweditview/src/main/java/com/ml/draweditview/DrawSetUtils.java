package com.ml.draweditview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;


/**
 * Created by admin on 2017-03-20.
 */

public class DrawSetUtils {

    DrawSetInterface drawSetInterface;
    public  DrawSetUtils(DrawSetInterface drawSetInterface){
        this.drawSetInterface=drawSetInterface;
    }


    public void reastView(Context context, AttributeSet attrs) {
        // TODO Auto-generated method stub

        try{


            TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.boundsAttrs);


            int  resourceId[][]={
                    {R.styleable.boundsAttrs_leftWidth,R.styleable.boundsAttrs_leftHeight,R.styleable.boundsAttrs_LeftPadding},
                    {R.styleable.boundsAttrs_topWidth,R.styleable.boundsAttrs_topHeight,R.styleable.boundsAttrs_topLeftPadding},
                    {R.styleable.boundsAttrs_rightWidth,R.styleable.boundsAttrs_rightHeight,R.styleable.boundsAttrs_rightPadding},
                    {R.styleable.boundsAttrs_bottomWidth,R.styleable.boundsAttrs_bottomHeight,R.styleable.boundsAttrs_bottomLeftPadding}

            };



            Drawable[] drawables=drawSetInterface.getCompoundDrawables();
            int index=0;
            Drawable[]  boundsDraw=new Drawable[4];
            for(Drawable drawable:drawables){
                boundsDraw[index]=drawable;

                if(drawable==null){
                    index++;
                    continue;
                }

                float  width=typedArray.getDimension(resourceId[index][0], 0);
                float  height=typedArray.getDimension(resourceId[index][1], 0);
                float  leftPadding=typedArray.getDimension(resourceId[index][2], 0);
                Rect rect=	drawable.getBounds();
                //	Log.e("666666666666666666",width+","+height);
                //	Log.e("777777777777777777",getResources().getDisplayMetrics().widthPixels+","+getResources().getDisplayMetrics().heightPixels);
                int  left=rect.left;
                if(leftPadding!=0)left=(int) leftPadding;

                int  right=(int) (left+width);
                int  top=rect.top;
                int  bottom=(int) (top+height);

                drawable.setBounds(left, top, right, bottom);
                index++;
            }
            typedArray.recycle();
            drawSetInterface.setCompoundDrawables(boundsDraw[0], boundsDraw[1], boundsDraw[2], boundsDraw[3]);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public interface DrawSetInterface{
        public Drawable[]  getCompoundDrawables();
        public  void  setCompoundDrawables( Drawable left, Drawable top,
                                              Drawable right,Drawable bottom);

    }

}
