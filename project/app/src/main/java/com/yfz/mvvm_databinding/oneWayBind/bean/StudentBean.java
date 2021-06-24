package com.yfz.mvvm_databinding.oneWayBind.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.yfz.mvvm_databinding.BR;

/**
 * 学生Bean
 */
public class StudentBean extends BaseObservable {
    String name;
    public StudentBean(String studentName){
        this.name = studentName;
    }
    @Bindable
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
