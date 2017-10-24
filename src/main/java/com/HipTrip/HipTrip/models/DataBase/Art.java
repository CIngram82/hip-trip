package com.HipTrip.HipTrip.models.DataBase;

import com.HipTrip.HipTrip.models.YelpAPI.BusinessDetails;

import javax.persistence.*;

@Entity
@Table(name = "Art")
public class Art {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private String key;

  @Column
  private String name;

  @Column
  private String image_url;

  @Column
  private String url;

  @Column
  private float rating;

  @Column
  private String price;

  @Column
  private String display_phone;

  @Column
  private float latitude;

  @Column
  private float longitude;

  @Column
  private String address1;

  @Column
  private String address2;

  @Column
  private String address3;

  @Column
  private String city;

  @Column
  private String zip_code;

  @Column
  private String state;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImage_url() {
    return image_url;
  }

  public void setImage_url(String image_url) {
    this.image_url = image_url;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public float getRating() {
    return rating;
  }

  public void setRating(float rating) {
    this.rating = rating;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getDisplay_phone() {
    return display_phone;
  }

  public void setDisplay_phone(String display_phone) {
    this.display_phone = display_phone;
  }

  public float getLatitude() {
    return latitude;
  }

  public void setLatitude(float latitude) {
    this.latitude = latitude;
  }

  public float getLongitude() {
    return longitude;
  }

  public void setLongitude(float longitude) {
    this.longitude = longitude;
  }

  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public String getAddress3() {
    return address3;
  }

  public void setAddress3(String address3) {
    this.address3 = address3;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZip_code() {
    return zip_code;
  }

  public void setZip_code(String zip_code) {
    this.zip_code = zip_code;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Art() {
  }

  public Art(BusinessDetails bd){
    this.setKey(bd.getId());
    this.setName(bd.getName());
    this.setImage_url(bd.getImage_url());
    this.setRating(bd.getRating());
    this.setPrice(bd.getPrice());
    this.setDisplay_phone(bd.getDisplay_phone());
    this.setLatitude(bd.getCoordinates().getLatitude());
    this.setLongitude(bd.getCoordinates().getLongitude());
    this.setAddress1(bd.getLocation().getAddress1());
    this.setAddress2(bd.getLocation().getAddress2());
    this.setAddress3(bd.getLocation().getAddress3());
    this.setCity(bd.getLocation().getCity());
    this.setZip_code(bd.getLocation().getZip_code());
    this.setState(bd.getLocation().getState());
    this.setUrl(bd.getUrl());
  }

}
