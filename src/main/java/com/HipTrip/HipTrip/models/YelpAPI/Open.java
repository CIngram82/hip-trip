package com.HipTrip.HipTrip.models.YelpAPI;

public class Open {
  private int day;
  private String start;
  private String end;
  private boolean is_overnight;

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }

  public boolean isIs_overnight() {
    return is_overnight;
  }

  public void setIs_overnight(boolean is_overnight) {
    this.is_overnight = is_overnight;
  }

  public Open() {

  }
}
