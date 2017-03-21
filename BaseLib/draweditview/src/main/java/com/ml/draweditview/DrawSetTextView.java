package com.ml.draweditview;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ml.draweditview.DrawSetUtils.DrawSetInterface;


public class DrawSetTextView extends TextView implements DrawSetInterface {



	public DrawSetTextView(Context context){
		super(context);
	}

	public DrawSetTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		new  DrawSetUtils(this).reastView(context,attrs);
	}

	public DrawSetTextView(Context context, AttributeSet attrs, int checkedCol) {
			super(context,attrs,checkedCol);
	     new  DrawSetUtils(this).reastView(context,attrs);
	}





	int width=0;
	int height=0;

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		width=getMeasuredWidth();
		height=getMeasuredHeight();
	}


	@Override
	protected void onDraw(Canvas canvas) {


		/*	float scaleX=0;
			float scaleY=0;
			int  height1=0;

			Drawable[] drawables=	getCompoundDrawables();
			if(drawables[0]!=null){

			}
			if(drawables[1]!=null){
				height1=height1+drawables[1].getBounds().height()+getCompoundDrawablePadding();
			}
			if(drawables[2]!=null){

			}
			if(drawables[3]!=null){
				height1=height1+drawables[3].getBounds().height();

			}
		if(StringUtil.notEmpty(getText().toString())){
			float top=getPaint().getFontMetrics().top;
			float bottom=getPaint().getFontMetrics().bottom;
			height1=(int)(bottom-top)+height1;

		}
		initHeight=getHeight();
		initWidth=getWidth();
		scaleY=height1*1f/height;
		int staryY=initHeight-height;
		Log.e("tag", "height1="+height1+" height="+height + "initHeight/2-staryY="+(initHeight/2-staryY));

		if(staryY==0){
			scaleY=1;
		}*/

		canvas.scale(0.9f,0.9f,width/2,height/2);



		super.onDraw(canvas);








	}
}
