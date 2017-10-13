package com.HipTrip.HipTrip.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trip {
  private int budget;
  private LocalDate tripStartDate;
  private LocalDate tripEndDate;
  private int adultCount;
  private int childCount;
  private int id;
  private ArrayList<Hotel> hotels;
  private String destination;
  private static int ID_COUNTER = 0;

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public ArrayList<Hotel> getHotels() {
    return hotels;
  }

  public void setHotels(ArrayList<Hotel> hotels) {
    this.hotels = hotels;
  }

  public int getBudget() {
    return budget;
  }

  public void setBudget(int budget) {
    this.budget = budget;
  }

  public LocalDate getTripStartDate() {
    return tripStartDate;
  }

  public void setTripStartDate(LocalDate tripStartDate) {
    this.tripStartDate = tripStartDate;
  }

  public LocalDate getTripEndDate() {
    return tripEndDate;
  }

  public void setTripEndDate(LocalDate tripEndDate) {
    this.tripEndDate = tripEndDate;
  }

  public int getAdultCount() {
    return adultCount;
  }

  public void setAdultCount(int adultCount) {
    this.adultCount = adultCount;
  }

  public int getChildCount() {
    return childCount;
  }

  public void setChildCount(int childCount) {
    this.childCount = childCount;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Trip() {
    this.id = ID_COUNTER++;
  }

  public Trip(int budget, String destination) {
    this.budget = budget;
    this.destination = destination;
    this.id = ID_COUNTER++;
  }

  @Override
  public String toString() {
    return "Trip{" +
        "budget=" + budget +
        ", destination='" + destination + '\'' +
        ", tripStartDate=" + tripStartDate +
        ", tripEndDate=" + tripEndDate +
        ", adultCount=" + adultCount +
        ", childCount=" + childCount +
        ", id=" + id +
        '}';
  }
}
