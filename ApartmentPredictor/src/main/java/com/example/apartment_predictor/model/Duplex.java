package com.example.apartment_predictor.model;

import java.util.List;
import java.util.UUID;

public class Duplex extends Apartment {

    private String balcony;
    private boolean elevator;
    private boolean hasSeparateUtilities;


    public Duplex() {
        this.id = UUID.randomUUID().toString();
    }

    public Duplex(String id, Long price, Integer area, Integer bathrooms, Integer stories, String mainroad, String guestroom, String basement, String hotwaterheating, String airconditioning, Integer parking, String prefarea, String furnishingstatus, int numberOfRooms, List<Review> reviews, String balcony, boolean elevator, boolean hasSeparateUtilities) {
        super(id, price, area, bathrooms, stories, mainroad, guestroom, basement, hotwaterheating, airconditioning, parking, prefarea, furnishingstatus, numberOfRooms, reviews);
        this.id = UUID.randomUUID().toString();
        this.balcony = balcony;
        this.elevator = elevator;
        this.hasSeparateUtilities = hasSeparateUtilities;
    }

    //Getters
    public String getBalcony() {
        return balcony;
    }

    public boolean isElevator() {
        return elevator;
    }

    public boolean isHasSeparateUtilities() {
        return hasSeparateUtilities;
    }

    //Setters
    public void setBalcony(String balcony) {
        this.balcony = balcony;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public void setHasSeparateUtilities(boolean hasSeparateUtilities) {
        this.hasSeparateUtilities = hasSeparateUtilities;
    }

    @Override
    public String toString() {
        return "Duplex{" +
                "id='" + id + '\'' +
                ", balcony='" + balcony + '\'' +
                ", elevator='" + elevator + '\'' +

                '}';
    }

    @Override
    public double calculatePrice() {
        double basePrice = area * 220 + (numberOfRooms * 12000);
        if (hasSeparateUtilities) {
            basePrice *= 1.15;
        }
        return basePrice * (1 + (locationRating * 0.09));
    }
}
