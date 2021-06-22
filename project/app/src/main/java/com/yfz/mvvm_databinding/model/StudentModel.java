package com.yfz.mvvm_databinding.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.yfz.mvvm_databinding.BR;
import com.yfz.mvvm_databinding.bean.StudentBean;

import java.util.ArrayList;
import java.util.List;

public class StudentModel extends BaseObservable {
    List<StudentBean> mStudentList = new ArrayList<>();

    /**
     * 将学生对象添加至list中
     * @param studentBean
     */
    public void addStudentToList(StudentBean studentBean){
        mStudentList.add(studentBean);
        //studentAmount是通过方法 getStudentAmount 添加了Bindable注解后自动生成的。
        notifyPropertyChanged(BR.studentAmount);
    }

    /**
     * 返回学生数量
     * @return
     */
    @Bindable
    public int getStudentAmount(){
        return mStudentList.size();
    }
}
