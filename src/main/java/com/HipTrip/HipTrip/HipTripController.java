package com.HipTrip.HipTrip;


import com.HipTrip.HipTrip.models.Trip;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class HipTripController {
//  private static final String TOKEN = System.getenv("YELP_API_TOKEN");
    private static final String TOKEN = "Bearer 5XyC6OLI1Rtqv4weHiCPPC7iobApAuAc97McQaMKd6ws4whbXBrBfevH4TWrJy0h0UWfuCHn78lM8U0mS9y3vReTcf3bkT_whgJc1ywxouNSom7UKMc_5xIdPQLdWXYx";

  @CrossOrigin
  @RequestMapping(path = "/newTrip", method = RequestMethod.POST)
  private Trip startNewTrip(@RequestBody Trip trip){

    return trip;
  }

  @CrossOrigin
  @RequestMapping(path = "/search/hotel/", method = RequestMethod.GET)
  private String getHotelsForLocation(){
    // send api call to yelp using location
    RestTemplate template = new RestTemplate();
    String url = "https://api.yelp.com/v3/businesses/search?term=hotel&latitude=37.786882&longitude=-122.399972&radius=100";

    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, TOKEN);

    HttpEntity<String> request = new HttpEntity<>(headers);

    String hotelList = template.exchange(url, HttpMethod.GET, request, String.class).toString();

//    List<Hotel> hotelList = new ArrayList<>();

    return hotelList;
  }

}
