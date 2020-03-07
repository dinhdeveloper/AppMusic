package com.dinh.API;


import com.dinh.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("product/cate={id}")
    Call<ArrayList<Product>> getProductByCateId(@Path("id") int id);
}
