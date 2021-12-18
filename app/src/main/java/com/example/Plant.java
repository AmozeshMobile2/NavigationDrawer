package com.example;

public class Plant {

    //properties
    private String plantName;
    private int gravity;
    private int distanceFromSun;
    private int diameter;


    //constructor


    public Plant(String plantName, int gravity, int distanceFromSun, int diameter) {
        this.plantName = plantName;
        this.gravity = gravity;
        this.distanceFromSun = distanceFromSun;
        this.diameter = diameter;
    }

    //Getters


    public String getPlantName() {
        return plantName;
    }

    public int getGravity() {
        return gravity;
    }

    public int getDistanceFromSun() {
        return distanceFromSun;
    }

    public int getDiameter() {
        return diameter;
    }
}
