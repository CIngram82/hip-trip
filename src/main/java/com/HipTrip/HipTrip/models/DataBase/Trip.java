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

  @OneToMany
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  private List<Art> arts;

  @OneToMany
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  private List<Shopping> shopping;

  @OneToMany
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  private List<Attraction> attractions;

  @OneToMany
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  private List<Nightlife> nightlife;

  @OneToMany
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  private List<Restaurant> restaurants;

  @OneToMany
  @Cascade(org.hibernate.annotations.CascadeType.ALL)
  private List<Spa> spas;


  @Column
  private String destination;

  public List<Art> getArts() {
    return arts;
  }

  public void setArts(List<Art> arts) {
    this.arts = arts;
  }

  public List<Shopping> getShopping() {
    return shopping;
  }

  public void setShopping(List<Shopping> shopping) {
    this.shopping = shopping;
  }

  public List<Attraction> getAttractions() {
    return attractions;
  }

  public void setAttractions(List<Attraction> attractions) {
    this.attractions = attractions;
  }

  public List<Nightlife> getNightlife() {
    return nightlife;
  }

  public void setNightlife(List<Nightlife> nightlife) {
    this.nightlife = nightlife;
  }

  public List<Spa> getSpas() {
    return spas;
  }

  public void setSpas(List<Spa> spas) {
    this.spas = spas;
  }

  public void setRestaurants(List<Restaurant> restaurants) {
    this.restaurants = restaurants;
  }

  public List<Restaurant> getRestaurants() {
    return restaurants;
  }

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

}
