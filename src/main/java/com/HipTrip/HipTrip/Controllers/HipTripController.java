package com.HipTrip.HipTrip.Controllers;


import com.HipTrip.HipTrip.models.DataBase.DatabaseBusinessDetails;
import com.HipTrip.HipTrip.models.DataBase.Trip;
import com.HipTrip.HipTrip.models.YelpAPI.BusinessDetails;
import com.HipTrip.HipTrip.models.YelpAPI.YelpResponse;
import com.HipTrip.HipTrip.repository.BusinessDetailsRepo;
import com.HipTrip.HipTrip.repository.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HipTripController {
  @Autowired
  TripRepo tripRepo;
  @Autowired
  BusinessDetailsRepo businessDetailsRepo;

//  private static final String TOKEN = System.getenv("YELP_API_TOKEN");
    private static final String TOKEN = "Bearer 5XyC6OLI1Rtqv4weHiCPPC7iobApAuAc97McQaMKd6ws4whbXBrBfevH4TWrJy0h0UWfuCHn78lM8U0mS9y3vReTcf3bkT_whgJc1ywxouNSom7UKMc_5xIdPQLdWXYx";


  @CrossOrigin
  @RequestMapping(path = "/newTrip", method = RequestMethod.POST)
  private Trip startNewTrip(@RequestBody Trip trip){
    tripRepo.save(trip);
    return trip;
  }

  @CrossOrigin
  @RequestMapping(path = "/trip/details", method = RequestMethod.GET)
  private ArrayList<Trip> getAllTrips(){
    ArrayList<Trip> t = new ArrayList();
    tripRepo.findAll().forEach(t::add);
    return t;
  }

  @CrossOrigin
  @RequestMapping(path = "/search/{term}/", method = RequestMethod.POST)
  private YelpResponse getHotelsForLocation(@PathVariable(value = "term")String term,@RequestBody Trip trip){
    RestTemplate template = new RestTemplate();
    String url = "https://api.yelp.com/v3/businesses/search?term=" + term + "&location=" + trip.getDestination() + "&radius=5000&price=" + trip.getBudget();
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, TOKEN);
    HttpEntity<String> request = new HttpEntity<>(headers);
    YelpResponse yr = template.exchange(url, HttpMethod.GET, request, YelpResponse.class).getBody();
    return yr;
  }

  @CrossOrigin
  @RequestMapping(path = "/trip/details/{id}", method = RequestMethod.GET)
  private Trip getTripDetails(@PathVariable(value = "id") int id){
    return tripRepo.findOne(id);
  }

  @CrossOrigin
  @RequestMapping(path = "/trip/details/{id}",method = RequestMethod.PUT)
  private Trip addTripDetails(@PathVariable(value = "id") int id, @RequestBody  Trip trip){
    Trip t = tripRepo.findOne(id);
    t.setTripStartDate(trip.getTripStartDate());
    t.setTripEndDate(trip.getTripEndDate());
    t.setAdultCount(trip.getAdultCount());
    t.setChildCount(trip.getChildCount());
    tripRepo.save(t);
    return tripRepo.findOne(id);
  }

  @CrossOrigin
  @RequestMapping(path = "/hotel/{id}",method = RequestMethod.GET)
  private BusinessDetails getHotelByID(@PathVariable(value = "id") String id){
    RestTemplate template = new RestTemplate();
    String url = "https://api.yelp.com/v3/businesses/"+ id;
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, TOKEN);
    HttpEntity<String> request = new HttpEntity<>(headers);
    BusinessDetails bd = template.exchange(url, HttpMethod.GET, request, BusinessDetails.class).getBody();
    return bd;
  }

  @CrossOrigin
  @RequestMapping(path = "/hotel/{id}",method = RequestMethod.PUT)
  private Trip addHotelToTrip(@PathVariable(value = "id") String id,@RequestBody Trip trip){
    RestTemplate template = new RestTemplate();
    String url = "https://api.yelp.com/v3/businesses/"+ id;
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, TOKEN);
    HttpEntity<String> request = new HttpEntity<>(headers);
    BusinessDetails bd = template.exchange(url, HttpMethod.GET, request, BusinessDetails.class).getBody();
    DatabaseBusinessDetails dbbd = new DatabaseBusinessDetails();
    dbbd.setSearchId(bd.getId());
    Trip butt = tripRepo.findOne(trip.getId());
    List<DatabaseBusinessDetails> h = butt.getHotels();
    h.add(dbbd);
    butt.setHotels(h);
    tripRepo.save(butt);
    return tripRepo.findOne(trip.getId());
  }

//  @CrossOrigin
//  @RequestMapping(path = "/hotel/{id}",method = RequestMethod.DELETE)
//  private Trip deleteHotel(@PathVariable(value = "id")int id,@RequestBody Trip trip){
//  tripRepo.findOne(trip.getId()).getHotels().remove(id);
//
//    return tripRepo.findOne(trip.getId());
//  }


}
