package com.pluralsight.smartnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<RecyclerModel> mRecyclerModels;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createList();
        buildRecyclerView();
    }

    private void createList() {
        mRecyclerModels = new ArrayList<>();

        mRecyclerModels.add(new RecyclerModel(R.drawable.news_launcher, "Product one"));
        mRecyclerModels.add(new RecyclerModel(R.drawable.news_launcher, "Product two"));
        mRecyclerModels.add(new RecyclerModel(R.drawable.news_launcher, "Product three"));
        mRecyclerModels.add(new RecyclerModel(R.drawable.news_launcher, "Product four"));
        mRecyclerModels.add(new RecyclerModel(R.drawable.news_launcher, "Product five"));


    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new RecyclerAdapter(this, mRecyclerModels);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}