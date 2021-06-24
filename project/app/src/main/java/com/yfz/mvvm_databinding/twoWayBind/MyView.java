package com.yfz.mvvm_databinding.twoWayBind;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    private int mClickTime = 0;
    public MyView(Context context) {
        super(context);
        initial();
    }
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initial();
    }
    private void initial(){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickTime ++;
            }
        });
    }
}
