package com.HipTrip.HipTrip.models.Trip;

import com.HipTrip.HipTrip.models.YelpAPI.BusinessDetails;

import java.time.Instant;
import java.util.ArrayList;

public class Trip {
  private int budget;
  private Instant tripStartDate;
  private Instant tripEndDate;
  private int adultCount;
  private int childCount;
  private int id;
  private ArrayList<BusinessDetails> hotels;
  private String destination;
  private static int ID_COUNTER = 0;

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public ArrayList<BusinessDetails> getBusinessDetails() {
    return hotels;
  }

  public void setBusinessDetails(ArrayList<BusinessDetails> businessDetails) {
    this.hotels = businessDetails;
  }

  public int getBudget() {
    return budget;
  }

  public void setBudget(int budget) {
    this.budget = budget;
  }

  public Instant getTripStartDate() {
    return tripStartDate;
  }

  public void setTripStartDate(Instant tripStartDate) {
    this.tripStartDate = tripStartDate;
  }

  public Instant getTripEndDate() {
    return tripEndDate;
  }

  public void setTripEndDate(Instant tripEndDate) {
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
