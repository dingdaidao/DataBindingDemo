package com.example.ding.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ding.databindingdemo.databinding.FragmentHomeBinding;

/**
 * Created by Administrator on 2018/10/15.
 */

public class HomeFragment extends Fragment {
    private FragmentHomeBinding mBindig;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       mBindig =  DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
