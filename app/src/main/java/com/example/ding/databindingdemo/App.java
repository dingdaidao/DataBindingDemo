package com.example.ding.databindingdemo;

import android.app.Application;
import android.databinding.DataBindingUtil;

import com.example.ding.databindingdemo.inject.component.AppComponent;
import com.example.ding.databindingdemo.inject.component.BindingComponent;
import com.example.ding.databindingdemo.inject.component.DaggerAppComponent;
import com.example.ding.databindingdemo.inject.component.DaggerBindingComponent;
import com.example.ding.databindingdemo.inject.module.AppModule;

/**
 * 作者：ding on 2019/3/6 15:50
 * <p>
 * 邮箱：770403372@qq.com
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
                .build();

        BindingComponent bindingComponent = DaggerBindingComponent.builder()
                .appComponent(appComponent)
                .build();

        DataBindingUtil.setDefaultComponent(bindingComponent);

    }
}
