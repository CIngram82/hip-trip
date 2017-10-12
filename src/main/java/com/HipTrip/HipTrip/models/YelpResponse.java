package com.HipTrip.HipTrip.models;

import java.util.ArrayList;

public class YelpResponse {
  private ArrayList<Business> businesses;
  private int total;
  private Region region;

  public ArrayList getBusinesses() {
    return businesses;
  }

  public void setBusinesses(ArrayList businesses) {
    this.businesses = businesses;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public Region getRegion() {
    return region;
  }

  public void setRegion(Region region) {
    this.region = region;
  }

  public YelpResponse() {
  }
}
