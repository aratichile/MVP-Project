package com.example.virtusaicicimvpapplication.data_details;

import static android.content.ContentValues.TAG;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.virtusaicicimvpapplication.R;
import com.example.virtusaicicimvpapplication.model.Datum;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private DataListActivity dataListActivity;
    private List<Datum> dataList;
    private List<Datum> originalMovieList;


    public DataAdapter(DataListActivity dataListActivity, List<Datum> dataList) {
        this.dataListActivity = dataListActivity;
        this.dataList = dataList;
        this.originalMovieList = dataList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_rows, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Datum datum = dataList.get(position);

        holder.tvName.setText(datum.getFirstName() + " " + datum.getLastName());
        holder.tvEmail.setText(String.valueOf(datum.getEmail()));
        Log.d(TAG, "name "+datum.getLastName());

        // loading album cover using Glide library
        Glide.with(dataListActivity)
                .load(datum.getAvatar())
                .listener(new RequestListener<Drawable>() {
                    @Override

                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.pbLoadImage.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.pbLoadImage.setVisibility(View.GONE);
                        return false;
                    }
                })
                .apply(new RequestOptions().placeholder(R.drawable.ic_place_holder).error(R.drawable.ic_place_holder))
                .into(holder.ivAvtar);


    }

    @Override
    public int getItemCount() {
        return dataList.size() ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView tv;

        public TextView tvName;

        public TextView tvEmail;

        public ImageView ivAvtar;

        public ProgressBar pbLoadImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvEmail = itemView.findViewById(R.id.tv_email);
            ivAvtar = itemView.findViewById(R.id.iv_avtar);
            pbLoadImage = itemView.findViewById(R.id.pb_avtar);
        }
    }
}
