package com.example.virtusaicicimvpapplication.data_details;

import android.content.Context;

import com.example.virtusaicicimvpapplication.model.Datum;
import com.example.virtusaicicimvpapplication.roomDatabase.AppDataBase;
import com.example.virtusaicicimvpapplication.roomDatabase.DataDao;

import java.util.List;

public class ListPresenter implements ListContract.Presenter, ListContract.Model.OnFinishedListener{


    private ListContract.View dataListView;

    private ListContract.Model dataListModel;

    private Context context;

    public ListPresenter(ListContract.View dataListView) {
        this.dataListView = dataListView;
        dataListModel = new DataListModel();
    }
    @Override
    public void onDestroy() {
        this.dataListView = null;
    }

    @Override
    public void getMoreData(int pageNo) {
        if (dataListView != null) {
            dataListView.showProgress();
        }
        dataListModel.getDataList(this, pageNo);
    }

    @Override
    public void requestDataFromServer() {

        if (dataListView != null) {
            dataListView.showProgress();
        }

        dataListModel.getDataList(this, 1);
    }


    @Override
    public void onFinished(List<Datum> dataArrayList) {
        dataListView.setDataToRecyclerView(dataArrayList);
        if (dataListView != null) {

            dataListView.hideProgress();
        }

    }

    @Override
    public void onFailure(Throwable t) {
        dataListView.onResponseFailure(t);
        if (dataListView != null) {
            dataListView.hideProgress();
        }
    }

}
