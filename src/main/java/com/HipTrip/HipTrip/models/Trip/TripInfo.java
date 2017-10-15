package com.HipTrip.HipTrip.models.Trip;

import javax.persistence.*;

@Entity
@Table(name = "trips")
public class TripInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  @Column
  private String destnation;

  @Column
  private int budget;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDestnation() {
    return destnation;
  }

  public void setDestnation(String destnation) {
    this.destnation = destnation;
  }

  public int getBudget() {
    return budget;
  }

  public void setBudget(int budget) {
    this.budget = budget;
  }
}
