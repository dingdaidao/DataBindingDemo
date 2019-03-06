package com.example.ding.databindingdemo.inject.module;

import com.bumptech.glide.RequestManager;
import com.example.ding.databindingdemo.ImageBindingAdapter;
import com.example.ding.databindingdemo.inject.scope.DataBinding;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：ding on 2019/3/6 15:56
 * <p>
 * 邮箱：770403372@qq.com
 */
@Module
public class BindingModule {
    @DataBinding
    @Provides
    ImageBindingAdapter providerImageBindingAdapter(RequestManager glide) {
        return new ImageBindingAdapter(glide);
    }
}
