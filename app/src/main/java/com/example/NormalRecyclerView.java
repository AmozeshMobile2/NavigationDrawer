package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.Adapter.PlanetAdapter;
import com.example.navigationdrawer.R;

import java.util.ArrayList;

public class NormalRecyclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlanetAdapter planetAdapter;
    private ArrayList<Plant> PlantArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_recycler_view);


        recyclerView=findViewById(R.id.normal_recycler_view);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PlantArrayList = new ArrayList<>();
        planetAdapter = new PlanetAdapter(this, PlantArrayList);
        recyclerView.setAdapter(planetAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        createListData();



    }

    private void createListData() {

        //this method is for adding data to recyclerview
        //let's make adapter and planet model class
        Plant plant = new Plant("Earth", 10, 1500, 12700);
        PlantArrayList.add(plant);

    //    PlanetAdapter.notifyDataSetChanged();

    }
}