package com.HipTrip.HipTrip.models;

public class Hours {
  private boolean is_open_now;
  private String hours_type;
  private Open open;

  public boolean isIs_open_now() {
    return is_open_now;
  }

  public void setIs_open_now(boolean is_open_now) {
    this.is_open_now = is_open_now;
  }

  public String getHours_type() {
    return hours_type;
  }

  public void setHours_type(String hours_type) {
    this.hours_type = hours_type;
  }

  public Open getOpen() {
    return open;
  }

  public void setOpen(Open open) {
    this.open = open;
  }

  public Hours() {

  }
}
