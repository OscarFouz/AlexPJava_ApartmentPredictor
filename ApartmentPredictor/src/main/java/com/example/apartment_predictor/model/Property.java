package com.example.apartment_predictor.model;

public abstract class Property {
    protected double area;
    protected int locationRating;

    //Getters
    public double getArea() {
        return area;
    }

    public int getLocationRating() {
        return locationRating;
    }

    //Setters

    public void setArea(double area) {
        this.area = area;
    }

    public void setLocationRating(int locationRating) {
        this.locationRating = locationRating;
    }

    public abstract double calculatePrice();


}
