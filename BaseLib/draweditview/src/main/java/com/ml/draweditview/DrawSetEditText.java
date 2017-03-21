package com.ml.draweditview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by admin on 2017-03-20.
 */

public class DrawSetEditText extends EditText implements DrawSetUtils.DrawSetInterface{
    public DrawSetEditText(Context context) {
        super(context);
    }

    public DrawSetEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        new  DrawSetUtils(this).reastView(context,attrs);

    }

    public DrawSetEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        new  DrawSetUtils(this).reastView(context,attrs);

    }
}
