package com.example.ding.databindingdemo.inject.component;

import com.bumptech.glide.RequestManager;
import com.example.ding.databindingdemo.inject.module.AppModule;
import com.example.ding.databindingdemo.inject.module.BindingModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者：ding on 2019/3/6 15:54
 * <p>
 * 邮箱：770403372@qq.com
 */
@Singleton
@Component(modules = {AppModule.class, BindingModule.class})
public interface AppComponent {
    RequestManager glide();
}
