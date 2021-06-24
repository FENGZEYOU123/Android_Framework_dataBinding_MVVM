package com.yfz.mvvm_databinding.twoWayBind;

import androidx.databinding.ObservableField;

public class ViewModel {
   public ObservableField<String> editTextInput = new ObservableField();
   public ObservableField<String> getEditTextInput(){
       return editTextInput;
    }
}
