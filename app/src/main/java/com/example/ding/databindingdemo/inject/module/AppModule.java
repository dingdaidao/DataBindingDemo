package com.example.ding.databindingdemo.inject.module;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：ding on 2019/3/6 15:53
 * <p>
 * 邮箱：770403372@qq.com
 */
@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    RequestManager providerGlide() {
        return Glide.with(application);
    }
}
