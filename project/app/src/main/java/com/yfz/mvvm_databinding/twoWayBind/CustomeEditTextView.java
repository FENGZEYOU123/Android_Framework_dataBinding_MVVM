package com.yfz.mvvm_databinding.twoWayBind;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

public class CustomeEditTextView extends FrameLayout {
    private EditText mEtContent;
    public CustomeEditTextView(@NonNull Context context) {
        super(context);
    }
    public CustomeEditTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    // SET 方法
    @BindingAdapter("y_content")
    public static void setStr(CustomeEditTextView cetv, String content) {
        if (cetv != null) {
            String mCurrentStr = cetv.mEtContent.getText().toString().trim();
            if (!TextUtils.isEmpty(content)) {
                if (!content.equalsIgnoreCase(mCurrentStr)) {
                    cetv.mEtContent.setText(content);
                    // 设置光标位置
                    cetv.mEtContent.setSelection(content.length());
                }
            }
        }
    }
    // GET 方法
    @InverseBindingAdapter(attribute = "y_content", event = "contentAttrChanged")
    public static String getStr(CustomeEditTextView cetv) {
        return cetv.mEtContent.getText().toString().trim();
    }
    // 监听,如果有变动就调用listener中的onChange方法
    @BindingAdapter(value = "contentAttrChanged")
    public static void setChangeListener(CustomeEditTextView cetv, InverseBindingListener listener) {
        cetv.mEtContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listener.onChange();
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
