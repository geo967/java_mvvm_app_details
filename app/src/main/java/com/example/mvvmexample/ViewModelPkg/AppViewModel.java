package com.example.mvvmexample.ViewModelPkg;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmexample.ModelClass.Model;

public class AppViewModel extends ViewModel {


    //live data

    public MutableLiveData<String> mutableLiveData=new MutableLiveData<>();

    //connecting view model with db - model
    public Model getAppFromDatabase(){
        return new Model("android app",1000,4);
    }

    //connecting view model with main activity
    public void getAppName(){
        String appName=getAppFromDatabase().getAppName();
        mutableLiveData.setValue(appName);
    }
}
