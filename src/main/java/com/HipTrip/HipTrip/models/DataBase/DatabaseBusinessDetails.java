package com.HipTrip.HipTrip.models.DataBase;

import javax.persistence.*;

@Entity
@Table(name = "BusinessDetail")
public class DatabaseBusinessDetails {
  @Id
  @GeneratedValue
  private int id;

  @Column
  private String searchId;

  public DatabaseBusinessDetails() {

  }

  public int getId() {
    return id;
  }

  public String getSearchId() {
    return searchId;
  }

  public void setSearchId(String searchId) {
    this.searchId = searchId;
  }
}

