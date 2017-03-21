package com.ml.draweditview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by admin on 2017-03-20.
 */

public class DrawSetButton extends Button implements DrawSetUtils.DrawSetInterface{
    public DrawSetButton(Context context) {
        super(context);
    }

    public DrawSetButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        new  DrawSetUtils(this).reastView(context,attrs);

    }

    public DrawSetButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        new  DrawSetUtils(this).reastView(context,attrs);

    }
}
