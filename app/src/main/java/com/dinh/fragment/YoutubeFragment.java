package com.dinh.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dinh.API.APIService;
import com.dinh.API.APIUntil;
import com.dinh.activity.R;
import com.dinh.adapter.NewFilmAdapter;
import com.dinh.adapter.SlideHomeAdapter;
import com.dinh.model.Product;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YoutubeFragment extends Fragment {
    private SliderView sliderView;

    private RecyclerView rc_newfilm;
    ArrayList<Product> listNewFilm;
    NewFilmAdapter newFilmAdapter;

    APIService apiService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_youtube, container, false);

        apiService = APIUntil.getServer();
        addControls(view);
        addSlide();
        addNewFilm();
        return view;
    }

    private void addNewFilm() {
        rc_newfilm.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rc_newfilm.setLayoutManager(layoutManager);

        apiService.getProductByCateId(1).enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                listNewFilm = response.body();
                newFilmAdapter = new NewFilmAdapter(listNewFilm, getContext());
                rc_newfilm.setAdapter(newFilmAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
                Log.e("onFailure",t.getMessage());
            }
        });
    }

    private void addSlide() {
        SlideHomeAdapter adapter = new SlideHomeAdapter(getActivity());
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.SCALE_DOWN); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINSCALINGTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.argb(1, 248, 249, 249));
        sliderView.setScrollTimeInSec(2); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }

    private void addControls(View view) {
        sliderView = view.findViewById(R.id.imageSlider);
        rc_newfilm = view.findViewById(R.id.rc_newfilm);
    }
}
