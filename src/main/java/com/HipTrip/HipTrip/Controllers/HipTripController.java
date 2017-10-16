package com.HipTrip.HipTrip.Controllers;


import com.HipTrip.HipTrip.models.YelpAPI.BusinessDetails;
import com.HipTrip.HipTrip.models.Trip.Trip;
import com.HipTrip.HipTrip.models.YelpAPI.YelpResponse;
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
    trip.setBusinessDetails(new ArrayList<>());
    tripList.add(trip);
    return trip;
  }

  @CrossOrigin
  @RequestMapping(path = "/search/{term}", method = RequestMethod.POST)
  private YelpResponse getHotelsForLocation(@PathVariable(value = "term")String term,@RequestBody Trip trip){
    RestTemplate template = new RestTemplate();
    String url = "https://api.yelp.com/v3/businesses/search?term=" + term +"&location=" + trip.getDestination() + "&radius=5000&price=" + trip.getBudget();
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, TOKEN);
    HttpEntity<String> request = new HttpEntity<>(headers);
    YelpResponse yr = template.exchange(url, HttpMethod.GET, request, YelpResponse.class).getBody();
    return yr;
  }

  @CrossOrigin
  @RequestMapping(path = "/trip/details/{id}", method = RequestMethod.GET)
  private Trip getTripDetails(@PathVariable(value = "id") int id){
    return tripList.stream().filter( t -> t.getId() == id).findFirst().get();
  }

  @CrossOrigin
  @RequestMapping(path = "/trip/details/{id}",method = RequestMethod.PUT)
  private Trip addTripDetails(@PathVariable(value = "id") int id, @RequestBody  Trip trip){
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
  private BusinessDetails getHotelByID(@PathVariable(value = "id") String id){
    return getBizById(id);
  }

  @CrossOrigin
  @RequestMapping(path = "/hotel/{id}",method = RequestMethod.PUT)
  private Trip addHotelToTrip(@PathVariable(value = "id") String id,@RequestBody Trip trip){
    tripList.get(trip.getId()).getBusinessDetails().add(getBizById(id));
    return tripList.get(trip.getId());
  }

  @CrossOrigin
  @RequestMapping(path = "/hotel/{id}",method = RequestMethod.DELETE)
  private Trip deleteHotel(@PathVariable(value = "id")String id,@RequestBody Trip trip){
      trip.getBusinessDetails().stream().filter(t -> t.getId() == id).findFirst().get();

    return trip;
  }

  @CrossOrigin
  @RequestMapping(path = "/restaurant/{id}",method = RequestMethod.GET)
  private BusinessDetails getrestaurantByID(@PathVariable(value = "id") String id){
    return getBizById(id);
  }

  @CrossOrigin
  @RequestMapping(path = "/restaurant/{id}",method = RequestMethod.PUT)
  private Trip addrestaurantToTrip(@PathVariable(value = "id") String id,@RequestBody Trip trip){
    tripList.get(trip.getId()).getBusinessDetails().add(getBizById(id));
    return tripList.get(trip.getId());
  }

  @CrossOrigin
  @RequestMapping(path = "/restaurant/{id}",method = RequestMethod.DELETE)
  private Trip deleterestaurant(@PathVariable(value = "id")String id,@RequestBody Trip trip){
    trip.getBusinessDetails().stream().filter(t -> t.getId() == id).findFirst().get();
    return trip;
  }



  private BusinessDetails getBizById(String id){
    RestTemplate template = new RestTemplate();
    String url = "https://api.yelp.com/v3/businesses/"+ id;
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, TOKEN);
    HttpEntity<String> request = new HttpEntity<>(headers);
    BusinessDetails bd = template.exchange(url, HttpMethod.GET, request, BusinessDetails.class).getBody();
    return bd;
  }


}
