package com.dinh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dinh.activity.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SlideHomeAdapter extends SliderViewAdapter<SlideHomeAdapter.ViewHolder> {
    private Context context;

    public SlideHomeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_slide_home, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        switch (position) {
            case 0:
                Glide.with(viewHolder.itemView)
                        .load("http://mobishops.herokuapp.com/images/imageBanner/banner_xiaomi.png")
                        .into(viewHolder.imageViewBackground);
                break;
            case 1:
                Glide.with(viewHolder.itemView)
                        .load("http://mobishops.herokuapp.com/images/imageBanner/banner_sansung.png")
                        .into(viewHolder.imageViewBackground);
                break;
            case 2:
                Glide.with(viewHolder.itemView)
                        .load("http://mobishops.herokuapp.com/images/imageBanner/banner_nokia_1.jpg")
                        .into(viewHolder.imageViewBackground);
                break;
            case 3:
                Glide.with(viewHolder.itemView)
                        .load("http://mobishops.herokuapp.com/images/imageBanner/banner_vivo_2.jpg")
                        .into(viewHolder.imageViewBackground);
                break;
            default:
                Glide.with(viewHolder.itemView)
                        .load("http://mobishops.herokuapp.com/images/imageBanner/banner_oppo_1.jpg")
                        .into(viewHolder.imageViewBackground);
                break;

        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    class ViewHolder extends SliderViewAdapter.ViewHolder{

        View itemView;
        ImageView imageViewBackground;
        public ViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            this.itemView = itemView;
        }
    }
}
