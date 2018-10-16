package com.example.ding.databindingdemo;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/10/15.
 */

public class User {
    private String name;
    private int age;
    public String pic;
    public String job;

    public User() {
        this.name = "小花";
        this.age = 18;
        this.pic = "http://upload.jianshu.io/users/upload_avatars/2291344/4f4a849cff90?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
