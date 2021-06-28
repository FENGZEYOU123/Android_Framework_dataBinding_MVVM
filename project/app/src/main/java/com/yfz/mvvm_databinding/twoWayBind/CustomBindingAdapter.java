package com.yfz.mvvm_databinding.twoWayBind;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;
import com.yfz.mvvm_databinding.R;

public class CustomBindingAdapter {
    @BindingAdapter({"android:glideImageUrl"})
    public static void loadImageFromUrl(ImageView view, String url){
        //需在manifests里添加权限    <uses-permission android:name="android.permission.INTERNET" />
        //sdk    compile 'com.github.bumptech.glide:glide:3.7.0'
        Glide.with(view.getContext())
                .load(url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(view);
    }
}

