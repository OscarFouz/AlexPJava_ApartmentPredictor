package com.example.apartment_predictor.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Apartment extends Property {

    @Id
    protected String id;
    private Long price;
    //protected Integer area;
    //protected Integer bedrooms;
    private Integer bathrooms;
    private Integer stories;
    private String mainroad;
    private String guestroom;
    private String basement;
    private String hotwaterheating;
    private String airconditioning;
    private Integer parking;
    private String prefarea;
    private String furnishingstatus;
    protected int numberOfRooms;



    @OneToMany(
            mappedBy = "apartment",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Review> reviews = new ArrayList<>();

    // Default constructor
    public Apartment() {
        this.id = UUID.randomUUID().toString();
    }

    public Apartment(String id, Long price, Integer area, Integer bathrooms, Integer stories, String mainroad, String guestroom, String basement, String hotwaterheating, String airconditioning, Integer parking, String prefarea, String furnishingstatus, int numberOfRooms, List<Review> reviews) {
        this.id = UUID.randomUUID().toString();
        this.price = price;
        this.area = area;
        this.bathrooms = bathrooms;
        this.stories = stories;
        this.mainroad = mainroad;
        this.guestroom = guestroom;
        this.basement = basement;
        this.hotwaterheating = hotwaterheating;
        this.airconditioning = airconditioning;
        this.parking = parking;
        this.prefarea = prefarea;
        this.furnishingstatus = furnishingstatus;
        this.numberOfRooms = numberOfRooms;
        this.reviews = reviews;
    }
// constructor created for old test
    public Apartment(long l, int i, int i1, int i2, int i3, String yes, String no, String no1, String no2, String yes1, int i4, String yes2, String furnished) {
        super();
    }


//    // helpers
//    public void addReview(Review review) {
//        reviews.add(review);
//        review.setApartment(this);
//    }
//
//    public void removeReview(Review review) {
//        reviews.remove(review);
//        review.setApartment(null);
//    }

    // Getters

    public String getId() {
        return id;
    }

    public Long getPrice() {
        return price;
    }

//    public Integer getArea() {
//        return area;
//    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public Integer getStories() {
        return stories;
    }

    public String getMainroad() {
        return mainroad;
    }

    public String getGuestroom() {
        return guestroom;
    }

    public String getBasement() {
        return basement;
    }

    public String getHotwaterheating() {
        return hotwaterheating;
    }

    public String getAirconditioning() {
        return airconditioning;
    }

    public Integer getParking() {
        return parking;
    }

    public String getPrefarea() {
        return prefarea;
    }

    public String getFurnishingstatus() {
        return furnishingstatus;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    //Setters
    public void setPrice(Long price) {
        this.price = price;
    }

//    public void setArea(Integer area) {
//        this.area = area;
//    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setStories(Integer stories) {
        this.stories = stories;
    }

    public void setMainroad(String mainroad) {
        this.mainroad = mainroad;
    }

    public void setGuestroom(String guestroom) {
        this.guestroom = guestroom;
    }

    public void setBasement(String basement) {
        this.basement = basement;
    }

    public void setHotwaterheating(String hotwaterheating) {
        this.hotwaterheating = hotwaterheating;
    }

    public void setAirconditioning(String airconditioning) {
        this.airconditioning = airconditioning;
    }

    public void setParking(Integer parking) {
        this.parking = parking;
    }

    public void setPrefarea(String prefarea) {
        this.prefarea = prefarea;
    }

    public void setFurnishingstatus(String furnishingstatus) {
        this.furnishingstatus = furnishingstatus;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", price=" + price +
                ", area=" + area +
                ", bedrooms=" + numberOfRooms +
                ", bathrooms=" + bathrooms +
                ", stories=" + stories +
                ", mainroad='" + mainroad + '\'' +
                ", guestroom='" + guestroom + '\'' +
                ", basement='" + basement + '\'' +
                ", hotwater='" + hotwaterheating + '\'' +
                ", airconditioning='" + airconditioning + '\'' +
                ", parking=" + parking +
                ", prefarea='" + prefarea + '\'' +
                ", furnishingstatus='" + furnishingstatus + '\'' +
                ", reviews='" + reviews.size() + '\'' +
                '}';
    }
    @Override
    public double calculatePrice() {
        double basePrice = area * 120 + (numberOfRooms * 8000);
        return basePrice * (1 + (locationRating * 0.04));
    }
}
