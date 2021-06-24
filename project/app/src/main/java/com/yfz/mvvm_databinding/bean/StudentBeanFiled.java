package com.yfz.mvvm_databinding.bean;

import androidx.databinding.ObservableField;

public class StudentBeanFiled {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> getName(){
        return name;
    }
}
