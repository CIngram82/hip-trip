package com.HipTrip.HipTrip.models.DataBase;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Trips")
public class Trip {
  @Column
  private int budget;
  @Column
  private String tripStartDate;
  @Column
  private String tripEndDate;
  @Column
  private int adultCount;
  @Column
  private int childCount;
  @Id
  @GeneratedValue
  private int id;

  @OneToMany
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  private List<Hotel> hotels;
  @Column
  private String destination;




  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public List<Hotel> getHotels() {
    return hotels;
  }

  public void setHotels(List<Hotel> hotels) {
    this.hotels = hotels;
  }

  public int getBudget() {
    return budget;
  }

  public void setBudget(int budget) {
    this.budget = budget;
  }

  public String getTripStartDate() {
    return tripStartDate;
  }

  public void setTripStartDate(String tripStartDate) {
    this.tripStartDate = tripStartDate;
  }

  public String getTripEndDate() {
    return tripEndDate;
  }

  public void setTripEndDate(String tripEndDate) {
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
  }

  public Trip(int budget, String destination) {
    this.budget = budget;
    this.destination = destination;
  }

  @Override
  public String toString() {
    return "Trip{" +
        "budget=" + budget +
        ", tripStartDate=" + tripStartDate +
        ", tripEndDate=" + tripEndDate +
        ", adultCount=" + adultCount +
        ", childCount=" + childCount +
        ", id=" + id +
        ", hotels=" + hotels +
        ", destination='" + destination + '\'' +
        '}';
  }
}
