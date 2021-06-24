package com.yfz.mvvm_databinding.twoWayBind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.yfz.mvvm_databinding.R;
import com.yfz.mvvm_databinding.databinding.ActivityMainBinding;
import com.yfz.mvvm_databinding.databinding.ActivityTwoWayBindBinding;

/**
 * Author:游丰泽
 * Time:999999999999/01/01
 * Describe:探究下双向绑定
 * csdn:https://blog.csdn.net/ruiruiddd/article/details/118103730
 * github:https://github.com/FENGZEYOU123/Android_Framework_dataBinding_MVVM
 */
public class TwoWayBindActivity extends AppCompatActivity {
    private ActivityTwoWayBindBinding mBinding;
    private ViewModel mViewMode;
    private MyVM myVM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_two_way_bind);
        mViewMode = new ViewModel();
        mBinding.setViewmodel(mViewMode);
        initVM();
    }
    private void initVM() {
        myVM = new ViewModelProvider(this).get(MyVM.class);
        mBinding.setMVM(myVM);
        myVM.mContentMLD1.setValue("1");
    }
}