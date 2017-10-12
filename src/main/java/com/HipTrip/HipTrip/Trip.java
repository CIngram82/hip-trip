package com.HipTrip.HipTrip;

import java.time.LocalDate;

public class Trip {
  private int budget;
  private String destination;
  private LocalDate tripStartDate;
  private LocalDate tripEndDate;
  private int adultCount;
  private int childCount;
  private int id;


  public int getBudget() {
    return budget;
  }

  public void setBudget(int budget) {
    this.budget = budget;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
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

  public Trip(int budget, String destination) {
    this.budget = budget;
    this.destination = destination;
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
