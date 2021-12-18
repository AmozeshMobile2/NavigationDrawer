package com.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.Plant;
import com.example.navigationdrawer.R;

import java.util.ArrayList;
import java.util.Locale;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.plantHolder> {

    //Adapter has two class
    //1-plant adapter

    //properties
    private Context context;
    private ArrayList<Plant> plants;

    public PlanetAdapter(Context context, ArrayList<Plant> plants) {
        this.context = context;
        this.plants = plants;
    }


    @Override
    public plantHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.plant_item_rc,parent,false);
        return new plantHolder(view) ;
    }

    @Override
    public void onBindViewHolder(PlanetAdapter.plantHolder holder, int position) {
       Plant plant=plants.get(position);
        holder.SetDetails(plant);

    }

    @Override
    public int getItemCount() {
        return plants.size();
    }


    //2-plant holder

    class plantHolder extends RecyclerView.ViewHolder {

        private TextView txtName, txtGravity, txtDistance, txtDiameter;

        public plantHolder(View itemView) {
            super(itemView);

            txtName = (itemView).findViewById(R.id.txt_name);
            txtGravity = (itemView).findViewById(R.id.txt_gravity);
            txtDistance = (itemView).findViewById(R.id.txt_distance);
            txtDiameter = (itemView).findViewById(R.id.txt_diameter);


        }


void SetDetails(Plant plant){

            txtName.setText(plant.getPlantName());
            txtDistance.setText(String.format(Locale.US,
                    "Distance from Sun :%d Million KM",plant.getDistanceFromSun()));
            txtGravity.setText(String.format(Locale.US,
                    "Surface Gravity : %d N/K ",plant.getGravity()));
            txtDiameter.setText(String.format(Locale.US,
                    "Diameter %d Km",plant.getDiameter()));

        }



    }


}
