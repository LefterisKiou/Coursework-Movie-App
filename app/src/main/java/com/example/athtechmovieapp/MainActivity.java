package com.example.athtechmovieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MovieModelClass> movieList;
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();
        fetchMovies();
    }

    private void fetchMovies() {
        String JSON_URL = "https://api.themoviedb.org/3/movie/popular?api_key=49882d5c398701e2e17856c4f1eab661";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("results");
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        MovieModelClass model = new MovieModelClass();
                        model.setId("Rating: " + jsonObject.getString("vote_average"));
                        model.setName(jsonObject.getString("title"));
                        model.setImg(jsonObject.getString("poster_path"));
                        model.setBackImg(jsonObject.getString("backdrop_path"));
                        model.setDescription(jsonObject.getString("overview"));
                        model.setRelease_date("Release Date: " + jsonObject.getString("release_date"));
                        movieList.add(model);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                PutDataIntoRecyclerView(movieList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    private void PutDataIntoRecyclerView(List<MovieModelClass> movieList){
        Adaptery adaptery = new Adaptery(this, movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptery);
    }
}