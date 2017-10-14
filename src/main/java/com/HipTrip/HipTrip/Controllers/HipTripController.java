package com.HipTrip.HipTrip.Controllers;


import com.HipTrip.HipTrip.models.BusinessDetails;
import com.HipTrip.HipTrip.models.Trip;
import com.HipTrip.HipTrip.models.YelpResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class HipTripController {
//  private static final String TOKEN = System.getenv("YELP_API_TOKEN");
    private static final String TOKEN = "Bearer 5XyC6OLI1Rtqv4weHiCPPC7iobApAuAc97McQaMKd6ws4whbXBrBfevH4TWrJy0h0UWfuCHn78lM8U0mS9y3vReTcf3bkT_whgJc1ywxouNSom7UKMc_5xIdPQLdWXYx";
    private ArrayList<Trip> tripList = new ArrayList<>();

  @CrossOrigin
  @RequestMapping(path = "/newTrip", method = RequestMethod.POST)
  private Trip startNewTrip(@RequestBody Trip trip){
    tripList.add(trip);
    return trip;
  }

  @CrossOrigin
  @RequestMapping(path = "/search/hotel/", method = RequestMethod.POST)
  private YelpResponse getHotelsForLocation(@RequestBody Trip trip){
    RestTemplate template = new RestTemplate();
    String url = "https://api.yelp.com/v3/businesses/search?term=hotel&location=" + trip.getDestination() + "&radius=5000&price=" + trip.getBudget();
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, TOKEN);
    HttpEntity<String> request = new HttpEntity<>(headers);
    YelpResponse yr = template.exchange(url, HttpMethod.GET, request, YelpResponse.class).getBody();
    return yr;
  }
  @CrossOrigin
  @RequestMapping(path = "/trip/details/{id}", method = RequestMethod.GET)
  private Trip getTripDetails(@RequestParam int id){
    return tripList.stream().filter( t -> t.getId() ==id).findFirst().get();
  }

  @CrossOrigin
  @RequestMapping(path = "/trip/details/{id}",method = RequestMethod.PUT)
  private Trip addTripDetails(@RequestParam int id, @RequestBody  Trip trip){
    Trip tripToMod =  tripList.stream().filter( t -> t.getId() == id).findFirst().get();
    tripToMod.setTripStartDate(trip.getTripStartDate());
    tripToMod.setTripEndDate(trip.getTripEndDate());
    tripToMod.setAdultCount(trip.getAdultCount());
    tripToMod.setChildCount(trip.getChildCount());
    tripToMod.setBusinessDetails(new ArrayList<>());
    return tripToMod;
  }

  @CrossOrigin
  @RequestMapping(path = "/hotel/{id}",method = RequestMethod.GET)
  private BusinessDetails getTripByID(@RequestParam int id){
    RestTemplate template = new RestTemplate();
    String url = "https://api.yelp.com/v3/businesses/"+ id;
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, TOKEN);
    HttpEntity<String> request = new HttpEntity<>(headers);
    BusinessDetails bd = template.exchange(url, HttpMethod.GET, request, BusinessDetails.class).getBody();
    return bd;
  }

}
