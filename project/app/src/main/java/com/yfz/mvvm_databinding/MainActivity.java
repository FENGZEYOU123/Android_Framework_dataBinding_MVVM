package com.yfz.mvvm_databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.yfz.mvvm_databinding.bean.StudentBean;
import com.yfz.mvvm_databinding.databinding.ActivityMainBinding;
import com.yfz.mvvm_databinding.model.StudentModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private EditText vEdtName;
    private StudentModel mStudentModel;
    private ViewClickHandlers mViewClickHandlers;
    private StudentBean mStudentBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mViewClickHandlers = new ViewClickHandlers();
        mBinding.setViewclickhandlers(mViewClickHandlers);

        mStudentBean = new StudentBean("小明");
        mBinding.setStudentbean(mStudentBean); //绑定一个学生Bean
        mStudentModel = new StudentModel();
        mStudentModel.addStudentToList( mStudentBean );
        mBinding.setStudentmodel(mStudentModel); //绑定一个学生Model

        initial();
    }
    private void initial(){
        vEdtName = findViewById(R.id.vEdtName);
    }

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
            mStudentBean.setName(name);
            mStudentModel.addStudentToList( mStudentBean );
//            StudentBean studentBean = new StudentBean(editText.getText().toString().trim());
//            mBinding.setStudentbean(studentBean);
//            mStudentModel.addStudentToList( studentBean );
//            mBinding.setStudentmodel(mStudentModel);
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
}