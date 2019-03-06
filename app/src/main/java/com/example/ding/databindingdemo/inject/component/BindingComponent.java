package com.example.ding.databindingdemo.inject.component;


import com.example.ding.databindingdemo.inject.module.BindingModule;
import com.example.ding.databindingdemo.inject.scope.DataBinding;

import dagger.Component;

/**
 * 作者：ding on 2019/3/6 15:55
 * <p>
 * 邮箱：770403372@qq.com
 */
@DataBinding
@Component(dependencies = AppComponent.class, modules = BindingModule.class)
public interface BindingComponent extends android.databinding.DataBindingComponent {
}
