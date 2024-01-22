package com.example.themoviedatabaseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<JsonPOJO.Result> results;
    private Button b;
    public static final String mainActivityTag = "mytag";

    public static String url1 = "https://api.themoviedb.org/3/movie/popular?api_key=5d8d574f48b0c983c0b989084f2a187c";
    public static String url2 = "https://api.themoviedb.org/3/movie/157336/videos?api_key=5d8d574f48b0c983c0b989084f2a187c";
    RecyclerView recyclerView;
    MainActivity sss = this;
    private final BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String s = intent.getStringExtra(MyIntentService.intentKey);


            Gson gson = new Gson();
            JsonPOJO jsonPOJOS = gson.fromJson(s, JsonPOJO.class);
            results = jsonPOJOS.getResults();
            initViews();


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.btn1);
        Log.d(mainActivityTag, "above btn");
        b.setOnClickListener(new ButtonClickListener(this));
        Log.d(mainActivityTag, "below btn");


    }

    private void initViews() {


        recyclerView = findViewById(R.id.rv1);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        if (results != null) {
            recyclerView.setAdapter(new MyAdapter(this, results));
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        LocalBroadcastManager.
                getInstance(this).registerReceiver
                        (br, new IntentFilter(MyIntentService.serviceIntentAction));
    }

    @Override
    protected void onStop() {
        super.onStop();

        LocalBroadcastManager.getInstance(this).unregisterReceiver(br);


    }
}