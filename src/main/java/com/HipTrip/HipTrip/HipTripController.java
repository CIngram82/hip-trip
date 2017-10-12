package com.HipTrip.HipTrip;


import org.springframework.web.bind.annotation.*;

@RestController
public class HipTripController {

  @CrossOrigin
  @RequestMapping(path = "/newTrip", method = RequestMethod.POST)
  private Trip startNewTrip(@RequestBody Trip trip){

    return trip;
  }

//  @CrossOrigin
//  @RequestMapping(path = "/search/hotel/{info}", method = RequestMethod.GET)
//  private List<Hotel> getHotelsForLocation(@PathVariable("info") String info){
//    List<Hotel> hotelList = new ArrayList<>();
//
//    return hotelList;
//  }

}
