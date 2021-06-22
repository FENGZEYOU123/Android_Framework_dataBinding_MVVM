package com.yfz.mvvm_databinding.bean;

/**
 * 学生Bean
 */
public class StudentBean {
    private String defaultName = "默认名字-小明";
    private String name;
    public StudentBean(String studentName){
        this.name = studentName;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultName() {
        return defaultName;
    }
}
