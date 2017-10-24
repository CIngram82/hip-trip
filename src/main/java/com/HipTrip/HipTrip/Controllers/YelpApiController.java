package com.HipTrip.HipTrip.Controllers;

import com.HipTrip.HipTrip.models.DataBase.Trip;
import com.HipTrip.HipTrip.models.YelpAPI.BusinessDetails;
import com.HipTrip.HipTrip.models.YelpAPI.YelpResponse;
import com.HipTrip.HipTrip.repository.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class YelpApiController {
    private static final String TOKEN = System.getenv("YELP_API_TOKEN");
  @Autowired
  TripRepo tripRepo;



  //Hotel routes
  @CrossOrigin
  @RequestMapping(path = "/search/hotel", method = RequestMethod.POST)
  private YelpResponse getHotelsForLocation(@RequestBody Trip trip){
    RestTemplate template = new RestTemplate();
    String url = "https://api.yelp.com/v3/businesses/search?term=hotel&location=" + trip.getDestination() + "&radius=40000&price=" + trip.getBudget();
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, TOKEN);
    HttpEntity<String> request = new HttpEntity<>(headers);
    return template.exchange(url, HttpMethod.GET, request, YelpResponse.class).getBody();
  }

  @CrossOrigin
  @RequestMapping(path = "/hotel/{id}",method = RequestMethod.GET)
  private BusinessDetails getHotelByID(@PathVariable(value = "id") String id){
    return getBizDetails(id);
  }



  //Restaurant routes
  @CrossOrigin
  @RequestMapping(path = "/search/restaurant", method = RequestMethod.POST)
  private YelpResponse getTermsForLocation(@RequestBody Trip trip){
    RestTemplate template = new RestTemplate();
    String url = "https://api.yelp.com/v3/businesses/search?term=restaurant&location=" + trip.getDestination() + "&radius=40000";
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, TOKEN);
    HttpEntity<String> request = new HttpEntity<>(headers);
    return template.exchange(url, HttpMethod.GET, request, YelpResponse.class).getBody();
  }

  @CrossOrigin
  @RequestMapping(path = "/restaurant/{id}",method = RequestMethod.GET)
  private BusinessDetails getRestaurantByID(@PathVariable(value = "id") String id){
    return getBizDetails(id);
  }







  private BusinessDetails getBizDetails(String id){
    RestTemplate template = new RestTemplate();
    String url = "https://api.yelp.com/v3/businesses/"+ id;
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, TOKEN);
    HttpEntity<String> request = new HttpEntity<>(headers);
    return template.exchange(url, HttpMethod.GET, request, BusinessDetails.class).getBody();
  }
}
