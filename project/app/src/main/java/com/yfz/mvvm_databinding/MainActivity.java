package com.yfz.mvvm_databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.yfz.mvvm_databinding.bean.StudentBean;
import com.yfz.mvvm_databinding.databinding.ActivityMainBinding;
import com.yfz.mvvm_databinding.model.StudentModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private EditText vEdtName;
    private Button vBtnAdd;
    private StudentModel mStudentModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);  //将其替换
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        initial();
        addListener();
    }
    private void initial(){
        mStudentModel = new StudentModel();
        vEdtName = findViewById(R.id.vEdtName);
        vBtnAdd = findViewById(R.id.vBtnAdd);
    }
    private void addListener(){
        vBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentBean studentBean = new StudentBean(vEdtName.getText().toString().trim());
                mStudentModel.addStudentToList( studentBean );
                mBinding.setStudentbean(studentBean);    //更新绑定的data variables
                mBinding.setStudentmodel(mStudentModel); //更新绑定的data variables
            }
        });
    }
}