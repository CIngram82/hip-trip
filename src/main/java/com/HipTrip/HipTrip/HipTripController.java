package com.HipTrip.HipTrip;


import com.HipTrip.HipTrip.models.Trip;
import com.HipTrip.HipTrip.models.YelpResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
public class HipTripController {
//  private static final String TOKEN = System.getenv("YELP_API_TOKEN");
    private static final String TOKEN = "Bearer 5XyC6OLI1Rtqv4weHiCPPC7iobApAuAc97McQaMKd6ws4whbXBrBfevH4TWrJy0h0UWfuCHn78lM8U0mS9y3vReTcf3bkT_whgJc1ywxouNSom7UKMc_5xIdPQLdWXYx";

  @CrossOrigin
  @RequestMapping(path = "/newTrip", method = RequestMethod.POST)
  private Trip startNewTrip(@RequestBody Trip trip){
    trip.setTripStartDate(LocalDate.now());
    return trip;
  }

  @CrossOrigin
  @RequestMapping(path = "/search/hotel/", method = RequestMethod.POST)
  private YelpResponse getHotelsForLocation(){

    RestTemplate template = new RestTemplate();
    String url = "https://api.yelp.com/v3/businesses/search?term=hotel&latitude=37.786882&longitude=-122.399972&radius=1000";

    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, TOKEN);

    HttpEntity<String> request = new HttpEntity<>(headers);

    ResponseEntity<YelpResponse> hotelList = template.exchange(url, HttpMethod.GET, request, YelpResponse.class);

    return hotelList.getBody();
  }

}
