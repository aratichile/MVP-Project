package com.example.virtusaicicimvpapplication.data_details;

import android.util.Log;

import com.example.virtusaicicimvpapplication.model.DataRes;
import com.example.virtusaicicimvpapplication.model.Datum;
import com.example.virtusaicicimvpapplication.network.ApiClient;
import com.example.virtusaicicimvpapplication.network.ApiInterface;
import com.example.virtusaicicimvpapplication.data_details.ListContract;
import com.example.virtusaicicimvpapplication.roomDatabase.AppDataBase;
import com.example.virtusaicicimvpapplication.roomDatabase.DataDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataListModel implements ListContract.Model {

    private final String TAG = "DataListModel";

    private DataDao dataDao;

    @Override
    public void getDataList(final OnFinishedListener onFinishedListener, int pageNo) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<DataRes> call = apiService.getPopularData(1, 12);
        call.enqueue(new Callback<DataRes>() {
            @Override
            public void onResponse(Call<DataRes> call, Response<DataRes> response) {
                List<Datum> data = response.body().getData();
                Log.d(TAG, "Number of movies received: " + data.size());


                onFinishedListener.onFinished(data);
            }

            @Override
            public void onFailure(Call<DataRes> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }
}
