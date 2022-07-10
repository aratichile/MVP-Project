package com.example.virtusaicicimvpapplication.data_details;

import static com.example.virtusaicicimvpapplication.GridSpacingItemDecoration.dpToPx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.virtusaicicimvpapplication.GridSpacingItemDecoration;
import com.example.virtusaicicimvpapplication.R;
import com.example.virtusaicicimvpapplication.model.Datum;
import java.util.ArrayList;
import java.util.List;

public class DataListActivity extends AppCompatActivity implements ListContract.View{

    private static final String TAG = "MovieListActivity";
    private ListPresenter listPresenter;
    private RecyclerView rvDataList;
    private List<Datum> dataList;
    private DataAdapter dataAdapter;
    private ProgressBar pbLoading;
    private TextView tvEmptyView;

    private int pageNo = 1;

    //Constants for load more
    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    int firstVisibleItem, visibleItemCount, totalItemCount;
    private GridLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        setListeners();
        //Initializing presenter
        listPresenter = new ListPresenter(this);

        listPresenter.requestDataFromServer();

    }
    private void initUI() {


        rvDataList = findViewById(R.id.rv_data_list);

        dataList = new ArrayList<>();
        dataAdapter = new DataAdapter(this, dataList);
        Log.d(TAG, "dataList "+dataList);
        mLayoutManager = new GridLayoutManager(this, 1);
        rvDataList.setLayoutManager(mLayoutManager);
        rvDataList.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(this, 5), true));
        rvDataList.setItemAnimator(new DefaultItemAnimator());
        rvDataList.setAdapter(dataAdapter);

        pbLoading = findViewById(R.id.pb_loading);

        tvEmptyView = findViewById(R.id.tv_empty_view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        listPresenter.onDestroy();
    }

    @Override
    public void showProgress() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerView(List<Datum> dataArrayList) {
        dataList.clear();
        dataList.addAll(dataArrayList);
        dataAdapter.notifyDataSetChanged();

        // This will help us to fetch data from next page no.
        pageNo++;
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Log.e(TAG, throwable.getMessage());
        Toast.makeText(this, getString(R.string.communication_error), Toast.LENGTH_LONG).show();
    }

    private void setListeners() {

        rvDataList.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                visibleItemCount = rvDataList.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();

                // Handling the infinite scroll
                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if (!loading && (totalItemCount - visibleItemCount)
                        <= (firstVisibleItem + visibleThreshold)) {
                    listPresenter.getMoreData(pageNo);
                    loading = true;
                }
            }
        });
    }
}