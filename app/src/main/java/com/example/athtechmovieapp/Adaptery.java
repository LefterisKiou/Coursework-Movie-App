package com.example.athtechmovieapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.Iterator;
import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {
    private Context mContext;
    private List<MovieModelClass> mData;

    public Adaptery(Context mContext, List<MovieModelClass> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.movie_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(mData.get(position).getId());
        holder.name.setText(mData.get(position).getName());
        holder.release_date.setText(mData.get(position).getRelease_date());
        holder.description.setText(mData.get(position).getDescription());

        Glide.with(mContext).load("https://image.tmdb.org/t/p/w500/" + mData.get(position).getImg()).into(holder.img);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", mData.get(position).getId());
                bundle.putString("name", mData.get(position).getName());
                bundle.putString("poster_path", mData.get(position).getImg());
                bundle.putString("backdrop_path", mData.get(position).getBackImg());
                bundle.putString("description", mData.get(position).getDescription());
                bundle.putString("release_date", mData.get(position).getRelease_date());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView name;
        ImageView img;
        TextView description;
        TextView release_date;
        ImageView back_img;
        ConstraintLayout constraintLayout;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_txt);
            name = itemView.findViewById(R.id.name_txt);
            img = itemView.findViewById(R.id.imageView);
            back_img = itemView.findViewById(R.id.detailBackdrop);
            description = itemView.findViewById(R.id.description);
            release_date = itemView.findViewById(R.id.release_date);
            constraintLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
