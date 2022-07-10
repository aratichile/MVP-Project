package com.example.virtusaicicimvpapplication.data_details;

import com.example.virtusaicicimvpapplication.model.Datum;

import java.util.List;

public interface ListContract {

//    void getDataList(Model.OnFinishedListener onFinishedListener, int pageNo);

    interface Model {

        interface OnFinishedListener {
            void onFinished(List<Datum> dataArrayList);

            void onFailure(Throwable t);
        }

        void getDataList(OnFinishedListener onFinishedListener, int pageNo);

    }

    interface View {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<Datum> dataArrayList);

        void onResponseFailure(Throwable throwable);

    }

    interface Presenter {

        void onDestroy();

        void getMoreData(int pageNo);

        void requestDataFromServer();

    }

}
