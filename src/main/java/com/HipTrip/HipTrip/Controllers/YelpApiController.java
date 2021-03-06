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



  //Get single by ID routes

  @CrossOrigin
  @RequestMapping(path = "/hotel/{id}",method = RequestMethod.GET)
  private BusinessDetails getHotelByID(@PathVariable(value = "id") String id){
    return getBizDetails(id);
  }
  @CrossOrigin
  @RequestMapping(path = "/restaurant/{id}",method = RequestMethod.GET)
  private BusinessDetails getRestaurantByID(@PathVariable(value = "id") String id){
    return getBizDetails(id);
  }
  @CrossOrigin
  @RequestMapping(path = "/art/{id}",method = RequestMethod.GET)
  private BusinessDetails getArtByID(@PathVariable(value = "id") String id){
    return getBizDetails(id);
  }
  @CrossOrigin
  @RequestMapping(path = "/attraction/{id}",method = RequestMethod.GET)
  private BusinessDetails getAttractionByID(@PathVariable(value = "id") String id){
    return getBizDetails(id);
  }
  @CrossOrigin
  @RequestMapping(path = "/nightlife/{id}",method = RequestMethod.GET)
  private BusinessDetails getNightlifeByID(@PathVariable(value = "id") String id){
    return getBizDetails(id);
  }
  @CrossOrigin
  @RequestMapping(path = "/shopping/{id}",method = RequestMethod.GET)
  private BusinessDetails getShoppingByID(@PathVariable(value = "id") String id){
    return getBizDetails(id);
  }
  @CrossOrigin
  @RequestMapping(path = "/spa/{id}",method = RequestMethod.GET)
  private BusinessDetails getSpaByID(@PathVariable(value = "id") String id){
    return getBizDetails(id);
  }


  //Search routes
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
  @RequestMapping(path = "/search/restaurant", method = RequestMethod.POST)
  private YelpResponse getRestaurantsForLocation(@RequestBody Trip trip){
    RestTemplate template = new RestTemplate();
    String url = "https://api.yelp.com/v3/businesses/search?term=restaurant&location=" + trip.getDestination() + "&radius=40000";
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, TOKEN);
    HttpEntity<String> request = new HttpEntity<>(headers);
    return template.exchange(url, HttpMethod.GET, request, YelpResponse.class).getBody();
  }


  // Search by category.
  @CrossOrigin
  @RequestMapping(path = "/search/{category}", method = RequestMethod.POST)
  private YelpResponse getAnyForLocation(@PathVariable(value = "category") String category,@RequestBody Trip trip){

    switch (category){
      case "spa" :
        category = "barbers,spas,hair,massage,othersalons";
        break;
      case "nightlife" :
        category = "bars,beergardens,comedyclubs,karaoke,musicvenues";
        break;
      case "attraction" :
        category = "amusementparks,aquariums,bikerentals,fitness,kids_activities";
        break;
      case "shopping" :
        category = "antiques,fashion,jewelry,outlet_stores,popupshopss";
        break;
      case "art" :
        category = "galleries,festivals,museums,theater,wineries";
        break;
      default:
        // If the category is not one of the above group searches search for it by its self.
        // We ended up not using this option.
        break;
    }
    return getCategoryYR(category , trip);
  }



  private YelpResponse getCategoryYR(String category, Trip trip){
    RestTemplate template = new RestTemplate();
    String url = "https://api.yelp.com/v3/businesses/search?location=" + trip.getDestination()
        +"&radius=40000&categories=" + category;
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, TOKEN);
    HttpEntity<String> request = new HttpEntity<>(headers);
    return template.exchange(url, HttpMethod.GET, request, YelpResponse.class).getBody();
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
