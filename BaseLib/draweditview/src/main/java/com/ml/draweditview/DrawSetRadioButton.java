package com.ml.draweditview;


import android.content.Context;

import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.RadioButton;


public class DrawSetRadioButton extends RadioButton implements DrawSetUtils.DrawSetInterface {
	BoundsRadioInterceptor  boundsRadioInterceptor;

	public DrawSetRadioButton(Context context){
		super(context);
	}


	public DrawSetRadioButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		new  DrawSetUtils(this).reastView(context,attrs);
	}


	public DrawSetRadioButton(Context context, AttributeSet attrs, int checkedColor) {
		super(context, attrs,checkedColor);
		// TODO Auto-generated constructor stub
		new  DrawSetUtils(this).reastView(context,attrs);
	}


	OnCheckedChangeListener mylistener=	new OnCheckedChangeListener(){

		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

			try {
				if(boundsRadioInterceptor!=null)
				boundsRadioInterceptor.interceptor(buttonView, isChecked);
			} catch (Exception e) {
				e.printStackTrace();
			}

/*

			if(checkedColor!=0&&uncheckColor!=0)
				if(isChecked){
					setTextColor(checkedColor);
				}else {
					setTextColor(uncheckColor);
				}

*/




		}
	};
	@Override
	public void setOnCheckedChangeListener(final OnCheckedChangeListener listener) {
 		boundsRadioInterceptor=	new BoundsRadioInterceptor(listener).setBoundsRadioInterceptor(boundsRadioInterceptor);
  		super.setOnCheckedChangeListener(mylistener);
	}











	/*@Override
	protected void onDraw(Canvas canvas) {
		Drawable[] drawables = getCompoundDrawables();
		if (drawables != null) {
			Drawable drawableLeft = drawables[0];
			Drawable right = drawables[2];
			//第一个是left
 			if (drawableLeft != null) {
				//获取文字的宽度
				float textWidth = getPaint().measureText(getText().toString());
				int drawablePadding = getCompoundDrawablePadding();
				int drawableWidth = 0;
				drawableWidth = drawableLeft.getIntrinsicWidth();
				float bodyWidth = textWidth + drawableWidth + drawablePadding;
				int y = getWidth();
				canvas.translate((getWidth() - bodyWidth) / 2, 0);
			}

			if (right != null) {
				//获取文字的宽度
				float textWidth = getPaint().measureText(getText().toString());
				int drawablePadding = getCompoundDrawablePadding();
				int drawableWidth = 0;
				drawableWidth = right.getIntrinsicWidth();
				float bodyWidth = textWidth + drawableWidth + drawablePadding;
				setPadding(0, 0, (int)(getWidth() - bodyWidth), 0);
 				canvas.translate((getWidth() - bodyWidth) / 2, 0);
			}

			*//*float textWidth = getPaint().measureText(getText().toString());
			int drawablePadding = getCompoundDrawablePadding();
			int drawableWidth = 0;
			float bodyWidth =textWidth ;
			if (drawableLeft != null) {
				drawableWidth = drawableLeft.getIntrinsicWidth();
				bodyWidth= drawableWidth + drawablePadding;
			}
			if(right!=null){
				drawableWidth = right.getIntrinsicWidth();
				bodyWidth= bodyWidth + drawableWidth + drawablePadding;
			}


			canvas.translate((getWidth() - bodyWidth) / 2, 0);
			*//*


		}
		super.onDraw(canvas);
	}*/
	
	
	
	

}
