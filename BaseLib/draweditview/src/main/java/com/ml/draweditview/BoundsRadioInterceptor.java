package com.ml.draweditview;

import android.widget.CompoundButton;

/**
 * Created by admin on 2016/10/19.
 */
public class BoundsRadioInterceptor implements CompoundButton.OnCheckedChangeListener{

    BoundsRadioInterceptor  boundsRadioInterceptor;
    CompoundButton.OnCheckedChangeListener  onCheckedChangeListener;

    public BoundsRadioInterceptor(CompoundButton.OnCheckedChangeListener  responseInterceptor2){
        this.onCheckedChangeListener = responseInterceptor2;

    }


    public BoundsRadioInterceptor  setBoundsRadioInterceptor(BoundsRadioInterceptor boundsRadioInterceptor) {
        this.boundsRadioInterceptor = boundsRadioInterceptor;
        return this;

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        onCheckedChangeListener.onCheckedChanged(buttonView,isChecked);
    }


    public  void  interceptor(CompoundButton buttonView, boolean isChecked) throws Exception {
        if (boundsRadioInterceptor != null) {
             boundsRadioInterceptor.interceptor(buttonView,isChecked);
         }
           onCheckedChanged(buttonView,isChecked);
    }




}
