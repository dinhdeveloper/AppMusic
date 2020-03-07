package com.dinh.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dinh.activity.MusicDetailActivity;
import com.dinh.activity.R;
import com.dinh.activity.VideoDetailActivity;
import com.dinh.adapter.SlideHomeAdapter;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class HomeFragment extends Fragment {
    private SliderView sliderView;
    private ImageView icon_person,icon_notification;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolBar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        addControls(view);

        SlideHomeAdapter adapter = new SlideHomeAdapter(getActivity());
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.SCALE_DOWN); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINSCALINGTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.argb(1, 248, 249, 249));
        sliderView.setScrollTimeInSec(2); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        return view;
    }

    private void addControls(View view) {
        sliderView = view.findViewById(R.id.imageSlider);
        icon_person = view.findViewById(R.id.icon_person);
        icon_notification = view.findViewById(R.id.icon_notification);

        icon_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MusicDetailActivity.class));
            }
        });
        icon_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), VideoDetailActivity.class));
            }
        });

    }

}
