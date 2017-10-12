package com.HipTrip.HipTrip;


import org.springframework.web.bind.annotation.*;

@RestController
public class HipTripController {

  @CrossOrigin
  @RequestMapping(path = "/newTrip", method = RequestMethod.POST)
  private Trip startNewTrip(@RequestBody String destination,  int budget){

    System.out.println("****** destination ****** " + destination);
    System.out.println("budget" + 3);
    Trip t = new Trip(budget,destination);
    System.out.println(t);
    return t;
  }

//  @CrossOrigin
//  @RequestMapping(path = "/search/hotel/{info}", method = RequestMethod.GET)
//  private List<Hotel> getHotelsForLocation(@PathVariable("info") String info){
//    List<Hotel> hotelList = new ArrayList<>();
//
//    return hotelList;
//  }

}
