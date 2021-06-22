package com.yfz.mvvm_databinding.model;

import com.yfz.mvvm_databinding.bean.StudentBean;

import java.util.ArrayList;
import java.util.List;

public class StudentModel {
    private List<StudentBean> mStudentList = new ArrayList<>();

    /**
     * 将学生对象添加至list中
     * @param studentBean
     */
    public void addStudentToList(StudentBean studentBean){
        mStudentList.add(studentBean);
    }

    /**
     * 返回学生数量
     * @return
     */
    public int getStudentAmount(){
        return mStudentList.size();
    }
}
