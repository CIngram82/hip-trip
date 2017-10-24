package com.HipTrip.HipTrip.models.DataBase;

import com.HipTrip.HipTrip.models.YelpAPI.BusinessDetails;

public class TripAndBusinessDetails {
  private Trip trip;
  private BusinessDetails businessDetails;

  public TripAndBusinessDetails() {
  }

  public Trip getTrip() {
    return trip;
  }

  public void setTrip(Trip trip) {
    this.trip = trip;
  }

  public BusinessDetails getBusinessDetails() {
    return businessDetails;
  }

  public void setBusinessDetails(BusinessDetails businessDetails) {
    this.businessDetails = businessDetails;
  }
}
