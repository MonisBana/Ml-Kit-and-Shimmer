package com.mab.notificationtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.telephony.RadioAccessSpecifier;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<Hospital> productSet;
    private Activity activity;
    private Context mContext;
    public boolean showshimmer = true;
    public int SHIMMER_ITEM_NO = 5;

    public CustomAdapter(ArrayList<Hospital> productSet, Activity activity, Context mContext) {
        this.productSet = productSet;
        this.activity = activity;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.swipe_layout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder viewHolder, int position) {
        if(showshimmer){
            viewHolder.shimmerFrameLayout.startShimmer();
            //viewHolder.RatingLabel.setHeight(50);
            //viewHolder.DistanceLabel.setHeight(50);
            viewHolder.Rating.setHeight(50);
            viewHolder.Distance.setHeight(50);
            viewHolder.star.setMaxHeight(50);
            viewHolder.Name.setHeight(50);
            viewHolder.Name.setWidth(400);
            viewHolder.Distance.setWidth(70);
            viewHolder.Rating.setWidth(70);
            //viewHolder.RatingLabel.setWidth(80);
            //viewHolder.DistanceLabel.setWidth(80);
        }
        else {
            viewHolder.shimmerFrameLayout.stopShimmer();
            viewHolder.shimmerFrameLayout.setShimmer(null);
            final Hospital item = productSet.get(position);
            viewHolder.Name.setText(item.getName());
            viewHolder.Distance.setText(item.getDistance());
            if (item.getName().contains("Palm")) {
                viewHolder.Image.setImageResource(R.drawable.dy);
            } else if (item.getName().contains("Mahavir")) {
                viewHolder.Image.setImageResource(R.drawable.jupiter);
            } else if (item.getName().contains("Hiran")) {
                viewHolder.Image.setImageResource(R.drawable.hiranandani);
            } else if (item.getName().contains("Vinamra")) {
                viewHolder.Image.setImageResource(R.drawable.apollo);
            }
            viewHolder.Rating.setText(item.getRating() + "");
            viewHolder.Distance.setBackground(null);
            viewHolder.Name.setBackground(null);
            viewHolder.Rating.setBackground(null);
            viewHolder.DistanceLabel.setBackground(null);
            viewHolder.RatingLabel.setBackground(null);
            viewHolder.DistanceLabel.setText("Distance");
            viewHolder.RatingLabel.setText("Rating");
            viewHolder.star.setBackground(null);
            viewHolder.star.setImageResource(R.drawable.star_18);
        }
    }

    @Override
    public int getItemCount() {
        return showshimmer ? SHIMMER_ITEM_NO :productSet.size();
    }

    public void refresh(ArrayList<Hospital> mDataSet) {
        this.productSet = mDataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView Name;
        public TextView Distance,DistanceLabel;
        public ImageView Image,star;
        public TextView Rating,RatingLabel;
        public ShimmerFrameLayout shimmerFrameLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.productName);
            Distance = itemView.findViewById(R.id.productPrice);
            Image = itemView.findViewById(R.id.productImage);
            Rating = itemView.findViewById(R.id.rating);
            star = itemView.findViewById(R.id.star);
            RatingLabel = itemView.findViewById(R.id.ratingLabel);
            DistanceLabel = itemView.findViewById(R.id.priceLabel);
            shimmerFrameLayout = itemView.findViewById(R.id.shimmer);
        }
    }
}
