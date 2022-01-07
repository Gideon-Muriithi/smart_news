package com.pluralsight.smartnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    NavigationView mNavigationView;
    Toolbar toolbar;

    ArrayList<RecyclerModel> mRecyclerModels;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
//            Intent intentMain = new Intent(this, MainActivity.class);
//            startActivity(intentMain);


//
            Toast.makeText(this, "Welcome to Smart News", Toast.LENGTH_SHORT).show();
        }

        createList();
        buildRecyclerView();
    }

    private void createList() {
        mRecyclerModels = new ArrayList<>();

        mRecyclerModels.add(new RecyclerModel(R.drawable.news_launcher, "January 2 2022 Myanmar coup: The doctors and nurses defying the military"));
        mRecyclerModels.add(new RecyclerModel(R.drawable.news_launcher, "January 2 2022 Myanmar coup: The doctors and nurses defying the military"));
        mRecyclerModels.add(new RecyclerModel(R.drawable.news_launcher, "January 2 2022 Myanmar coup: The doctors and nurses defying the military"));
        mRecyclerModels.add(new RecyclerModel(R.drawable.news_launcher, "January 2 2022 Myanmar coup: The doctors and nurses defying the military"));        mRecyclerModels.add(new RecyclerModel(R.drawable.news_launcher, "January 2 2022 Myanmar coup: The doctors and nurses defying the military"));

    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new RecyclerAdapter(this, mRecyclerModels);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.break_news:
//                Intent intentMain = new Intent(this, MainActivity.class);
//                startActivity(intentMain);
                Toast.makeText(this, "Create Some News!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.settings:
                Toast.makeText(this, "App Settings", Toast.LENGTH_SHORT).show();
                break;


            default:
                Toast.makeText(this, "Nothing has been selected", Toast.LENGTH_SHORT).show();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}