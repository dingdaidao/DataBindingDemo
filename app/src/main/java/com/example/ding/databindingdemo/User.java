package com.example.ding.databindingdemo;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/10/15.
 */

public class User {
    private String name;
    private int age;

    public User() {
        this.name = "小花";
        this.age = 18;
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
