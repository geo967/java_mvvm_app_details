package com.example.mvvmexample.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvvmexample.R;
import com.example.mvvmexample.ViewModelPkg.AppViewModel;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    //connecting main activity with view model and listening to live data
    AppViewModel appViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        textView=findViewById(R.id.text);

        //view model provider is deprecated
        appViewModel= new ViewModelProvider(this).get(AppViewModel.class);

        //listening and observing the changes to live data
        appViewModel.mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //any change in live data it will do this
                textView.setText(s);
            }
        });

    }

    public void clickedButton(View view){
            appViewModel.getAppName();
    }
}