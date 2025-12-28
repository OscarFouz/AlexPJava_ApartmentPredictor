package com.example.apartment_predictor.model;

import java.util.List;
import java.util.UUID;

public class TownHouse extends Apartment {

    private boolean hasHomeownersAssociation;
    private double hoaMonthlyFee;

    public TownHouse() {this.id = UUID.randomUUID().toString(); }

    public TownHouse(String id, Long price, Integer area, Integer bathrooms, Integer stories, String mainroad, String guestroom, String basement, String hotwaterheating, String airconditioning, Integer parking, String prefarea, String furnishingstatus, int numberOfRooms, List<Review> reviews, boolean hasHomeownersAssociation, double hoaMonthlyFee) {
        super(id, price, area, bathrooms, stories, mainroad, guestroom, basement, hotwaterheating, airconditioning, parking, prefarea, furnishingstatus, numberOfRooms, reviews);
        this.hasHomeownersAssociation = hasHomeownersAssociation;
        this.hoaMonthlyFee = hoaMonthlyFee;
    }

    //Getters
    public double getHoaMonthlyFee() {
        return hoaMonthlyFee;
    }

    public boolean isHasHomeownersAssociation() {
        return hasHomeownersAssociation;
    }

    //Setters

    public void setHasHomeownersAssociation(boolean hasHomeownersAssociation) {
        this.hasHomeownersAssociation = hasHomeownersAssociation;
    }

    public void setHoaMonthlyFee(double hoaMonthlyFee) {
        this.hoaMonthlyFee = hoaMonthlyFee;
    }

    //ToString

    @Override
    public String toString() {
        return "TownHouse{" +
                "hasHomeownersAssociation=" + hasHomeownersAssociation +
                ", hoaMonthlyFee=" + hoaMonthlyFee +
                ", id='" + id + '\'' +
                ", area=" + area +
                ", numberOfRooms=" + numberOfRooms +
                ", area=" + area +
                ", locationRating=" + locationRating +
                '}';
    }

    @Override
    public double calculatePrice() {
        double basePrice = area * 220 + (numberOfRooms * 12000);
        if (hasHomeownersAssociation) {
            basePrice = basePrice - hoaMonthlyFee;
        }
        return basePrice * (1 + (locationRating * 0.09));
    }
}
