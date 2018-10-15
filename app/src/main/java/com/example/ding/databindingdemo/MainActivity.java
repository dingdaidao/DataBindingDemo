package com.example.ding.databindingdemo;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ding.databindingdemo.BR;
import com.example.ding.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mBinding.setVariable(BR.user,new User());
        //或者
        mBinding.setUser(new User());
        mBinding.setVariable(BR.act,this);
        mBinding.executePendingBindings();
    }
    public void btn(String name){
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
    }
}
