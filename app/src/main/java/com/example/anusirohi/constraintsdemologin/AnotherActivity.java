package com.example.anusirohi.constraintsdemologin;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.anusirohi.constraintsdemologin.LocationDemo.FusedLocation;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;

public class AnotherActivity extends AppCompatActivity {
    ArrayList<String> country_list;
    CountryListAdapter listAdapter;
    RecyclerView recyclerView_country_list;
    private FusedLocation mFusedLocation;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Log.d("on create", "------on create---2");
        init();
    }

    private void init() {
        country_list = (ArrayList<String>) getIntent().getSerializableExtra("dsgdag");
        recyclerView_country_list = findViewById(R.id.recyclerView_country_list);
        listAdapter = new CountryListAdapter(this, country_list);
        recyclerView_country_list.setAdapter(listAdapter);
        recyclerView_country_list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("on start", "------on Start---2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("on resume", "------on resume---2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("on pause", "------on pause-----2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("on stop", "------on stop----2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("on destroy", "------on destroy----2");
    }

}
