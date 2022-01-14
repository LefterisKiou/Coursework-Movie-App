package com.example.athtechmovieapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.detailImageView);
        ImageView backdrop = findViewById(R.id.detailBackdrop);
        TextView name = findViewById(R.id.detailTitle);
        TextView id = findViewById(R.id.detailRating);
        TextView releaseDate = findViewById(R.id.detailReleaseDate);
        TextView description = findViewById(R.id.detailDescription);

        Bundle bundle = getIntent().getExtras();
        String mId = bundle.getString("id");
        String mName = bundle.getString("name");
        String mImg = bundle.getString("poster_path");
        String mBackdrop = bundle.getString("backdrop_path");
        String mDesc = bundle.getString("description");
        String mRelease = bundle.getString("release_date");

        Glide.with(this).load("https://image.tmdb.org/t/p/w500/" + mImg).into(imageView);
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/" + mBackdrop).into(backdrop);
        name.setText(mName);
        id.setText(mId);
        description.setText(mDesc);
        releaseDate.setText(mRelease);


    }
}