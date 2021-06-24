package com.yfz.mvvm_databinding.twoWayBind;

import androidx.lifecycle.MutableLiveData;

public class MyVM extends ViewModel {
    public MutableLiveData<String> mContentMLD1;
    public MyVM() {
        mContentMLD1 = new MutableLiveData<>();
    }
}
