package com.example.virtusaicicimvpapplication.network;

import com.example.virtusaicicimvpapplication.model.DataRes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("users")
    Call<DataRes> getPopularData(@Query("page") int page, @Query("per_page") int noOfItem);

}
