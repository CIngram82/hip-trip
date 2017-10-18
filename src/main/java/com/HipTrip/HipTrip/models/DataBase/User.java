//package com.HipTrip.HipTrip.models.DataBase;
//
//
//import org.hibernate.annotations.Cascade;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "users")
//public class User {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private int id;
//
//  @Column
//  private String name;
//
//  @Column
//  private String password;
//
//  @OneToMany
//  @Cascade(org.hibernate.annotations.CascadeType.ALL)
//  private List<Trip> trips;
//
//  public List<Trip> getTrips() {
//    return trips;
//  }
//
//  public void setTrips(List<Trip> trips) {
//    this.trips = trips;
//  }
//
//  public int getId() {
//    return id;
//  }
//
//  public void setId(int id) {
//    this.id = id;
//  }
//
//  public String getName() {
//    return name;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }
//
//  public String getPassword() {
//    return password;
//  }
//
//  public void setPassword(String password) {
//    this.password = password;
//  }
//}