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


}
