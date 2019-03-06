package com.example.ding.databindingdemo;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

public class ImageBindingAdapter {
    private final RequestManager glide;

    public ImageBindingAdapter(RequestManager glide) {
        this.glide = glide;
    }

    @BindingAdapter(value = {"bind:imageUrl"}, requireAll = true)
    public void setImageUrl(ImageView view, String url) {
        glide.load(url).into(view);
    }





    @BindingAdapter(value = {"bind:imageSrc"}, requireAll = true)
    public static void setImageSrc(ImageView view, int src) {
        view.setImageResource(src);
    }

    @BindingAdapter(value = {"bind:imageBitmap"}, requireAll = true)
    public static void setImageBitmap(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }
}
