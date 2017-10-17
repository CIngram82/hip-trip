package com.HipTrip.HipTrip.models.DataBase;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Trips")
public class Trip {
  @Column
  private int budget;
  @Column
  private LocalDate tripStartDate;
  @Column
  private LocalDate tripEndDate;
  @Column
  private int adultCount;
  @Column
  private int childCount;
  @Id
  @GeneratedValue
  private int id;

  @OneToMany
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  private List<DatabaseBusinessDetails> hotels;
  @Column
  private String destination;




  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public List<DatabaseBusinessDetails> getHotels() {
    return hotels;
  }

  public void setHotels(List<DatabaseBusinessDetails> hotels) {
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
