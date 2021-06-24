package com.yfz.mvvm_databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.yfz.mvvm_databinding.bean.StudentBean;
import com.yfz.mvvm_databinding.bean.StudentBeanFiled;
import com.yfz.mvvm_databinding.databinding.ActivityMainBinding;
import com.yfz.mvvm_databinding.model.StudentModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private EditText vEdtName;
    private StudentModel mStudentModel;
    private ViewClickHandlers mViewClickHandlers;
    private BindFunction mBindFunction;
    private StudentBean mStudentBean;
    private StudentBeanFiled mStudentBeanFiled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mViewClickHandlers = new ViewClickHandlers();
        mBinding.setViewclickhandlers(mViewClickHandlers);

        //****提前绑定数据对象-实现观察者自动更新UI
        mStudentBean = new StudentBean("小明");
        mBinding.setStudentbean(mStudentBean); //绑定一个学生Bean
        mStudentModel = new StudentModel();
        mStudentModel.addStudentToList( mStudentBean );
        mBinding.setStudentmodel(mStudentModel); //绑定一个学生Model
        //*****

        //绑定方法
        mBindFunction = new BindFunction();
        mBinding.setBindfunction(mBindFunction);

        //绑定filed
        mStudentBeanFiled = new StudentBeanFiled();
        mBinding.setStudentbeanfiled(mStudentBeanFiled);

        initial();
    }
    private void initial(){
        vEdtName = findViewById(R.id.vEdtName);
    }

    /**
     * 绑定点击事件
     */
    public class ViewClickHandlers {
        /**
         * 处理绑定的view点击事件回调
         */
        public void onBtnClick(View view){
            StudentBean studentBean = new StudentBean(vEdtName.getText().toString().trim());
            mStudentModel.addStudentToList( studentBean );
//            mBinding.setStudentbean(studentBean);    //更新绑定的data variables
//            mBinding.setStudentmodel(mStudentModel); //更新绑定的data variables
        }
        /**
         * 处理绑定的view点击事件回调，同时也传递editText对象
         */
        public void onBtnClickWithEditText(View view, EditText editText){
            String name = editText.getText().toString().trim();
            mStudentBean.setName(name);  //可观察者绑定变量
            mStudentModel.addStudentToList( mStudentBean ); //可观察者绑定变量

            //--使用ObservableField声明变量后，用setter方法赋值
            mStudentBeanFiled.name.set(name);
            //--
//            StudentBean studentBean = new StudentBean(editText.getText().toString().trim()); //废弃，通过观察者主动更新
//            mBinding.setStudentbean(studentBean);  //废弃，通过观察者主动更新,不在调bind的setter方法
//            mStudentModel.addStudentToList( studentBean ); //废弃，通过观察者主动更新
//            mBinding.setStudentmodel(mStudentModel); //废弃，通过观察者主动更新,不在调bind的setter方法
        }
        /**
         * 处理绑定的view点击事件回调，同时也传递studentBean对象
         */
        public void onBtnClickWithStudentBean(View view, StudentBean studentBean){
            mStudentModel.addStudentToList( studentBean );
//            mBinding.setStudentbean(studentBean);    //更新绑定的data variables
//            mBinding.setStudentmodel(mStudentModel); //更新绑定的data variables
        }
    }
    /**
     * 绑定方法
     */
    public static class BindFunction{
        public String getAmount(StudentModel studentModel) {
            return "绑定方法，获取当前的学生人数为："+studentModel.getStudentAmount();
        }
    }
}