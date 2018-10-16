package com.example.ding.databindingdemo;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;

public class ImageBindingAdapter {
    @BindingAdapter(value = {"bind:imageUrl"},requireAll = true)
    public static void setImageUrl(ImageView view,String url){
        Glide.with(view.getContext()).load(url).into(view);
    }
    @BindingAdapter(value = {"bind:imageSrc"},requireAll = true)
    public static void setImageSrc(ImageView view,int src){
        view.setImageResource(src);
    }
    @BindingAdapter(value = {"bind:imageBitmap"},requireAll = true)
    public static void setImageBitmap(ImageView view,Bitmap bitmap){
        view.setImageBitmap(bitmap);
    }
}
