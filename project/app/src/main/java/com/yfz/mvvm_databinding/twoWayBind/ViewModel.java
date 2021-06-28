package com.yfz.mvvm_databinding.twoWayBind;

import androidx.databinding.ObservableField;

public class ViewModel {

   public ObservableField<String> editTextInput = new ObservableField();
   public ObservableField<String> getEditTextInput(){
       return editTextInput;
    }

   public String isChecked ="checkBox已经被选中";
   public String isUnChecked ="未被选中";
   public ObservableField<Boolean> checkBoxStatus = new ObservableField<>();
   public ObservableField<Boolean> getCheckBoxStatus(){
       return checkBoxStatus;
   }

   //加载网络头像
   public String avatarImgUrl ="https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";

}
