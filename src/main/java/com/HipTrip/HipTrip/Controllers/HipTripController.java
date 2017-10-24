package com.HipTrip.HipTrip.Controllers;


import com.HipTrip.HipTrip.models.DataBase.*;
import com.HipTrip.HipTrip.repository.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HipTripController {
  @Autowired
  TripRepo tripRepo;

  //Trip routes
  @CrossOrigin
  @RequestMapping(path = "/newTrip", method = RequestMethod.POST)
  private Trip startNewTrip(@RequestBody Trip trip){
    trip.setHotels(new ArrayList<Hotel>() {});
    trip.setRestaurants(new ArrayList<Restaurant>() {});
    trip.setArts(new ArrayList<Art>() {});
    trip.setAttractions(new ArrayList<Attraction>() {});
    trip.setNightlife(new ArrayList<Nightlife>() {});
    trip.setShopping(new ArrayList<Shopping>() {});
    trip.setSpas(new ArrayList<Spa>() {});

    tripRepo.save(trip);
    return trip;
  }

  @CrossOrigin
  @RequestMapping(path = "/trip/details", method = RequestMethod.GET)
  private ArrayList<Trip> getAllTrips(){
    ArrayList<Trip> t = new ArrayList<>();
    tripRepo.findAll().forEach(t::add);
    return t;
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
    if (trip.getTripStartDate() != null)
    t.setTripStartDate(trip.getTripStartDate());
    if (trip.getTripEndDate() != null)
      t.setTripEndDate(trip.getTripEndDate());
    if (trip.getAdultCount() != 0)
      t.setAdultCount(trip.getAdultCount());
    if (trip.getChildCount() != 0)
      t.setChildCount(trip.getChildCount());
    tripRepo.save(t);
    return tripRepo.findOne(id);
  }



  //Hotel routes
  @CrossOrigin
  @RequestMapping(path = "/hotel/{id}",method = RequestMethod.DELETE)
  private Trip deleteHotel(@PathVariable(value = "id")int id,@RequestBody Trip trip){
  tripRepo.findOne(trip.getId()).getHotels().remove(id);

    return tripRepo.findOne(trip.getId());
  }

  @CrossOrigin
  @RequestMapping(path = "/save/hotel",method = RequestMethod.PUT)
  private Trip addHotelToTrip(@RequestBody TripAndBusinessDetails trip_andBusinessDetails){
    Hotel dbbd = new Hotel(trip_andBusinessDetails.getBusinessDetails());
    Trip trip = tripRepo.findOne(trip_andBusinessDetails.getTrip().getId());
    trip.getHotels().add(dbbd);
    return tripRepo.save(trip);
  }



  //Restaurant routes
  @CrossOrigin
  @RequestMapping(path = "/restaurant/{id}",method = RequestMethod.DELETE)
  private Trip deleteRestaurant(@PathVariable(value = "id")int id,@RequestBody Trip trip){
    tripRepo.findOne(trip.getId()).getRestaurants().remove(id);
    return tripRepo.findOne(trip.getId());
  }

  @CrossOrigin
  @RequestMapping(path = "/save/restaurant",method = RequestMethod.PUT)
  private Trip addRestaurantToTrip(@RequestBody TripAndBusinessDetails trip_andBusinessDetails){
    Restaurant dbbd = new Restaurant(trip_andBusinessDetails.getBusinessDetails());
    Trip trip = tripRepo.findOne(trip_andBusinessDetails.getTrip().getId());
    trip.getRestaurants().add(dbbd);
    return tripRepo.save(trip);
  }


  //Other save routes
  @CrossOrigin
  @RequestMapping(path = "/save/arts",method = RequestMethod.PUT)
  private Trip addArtsToTrip(@RequestBody TripAndBusinessDetails trip_andBusinessDetails){
    Art dbbd = new Art(trip_andBusinessDetails.getBusinessDetails());
    Trip trip = tripRepo.findOne(trip_andBusinessDetails.getTrip().getId());
    trip.getArts().add(dbbd);
    return tripRepo.save(trip);
  }

  @CrossOrigin
  @RequestMapping(path = "/save/attraction",method = RequestMethod.PUT)
  private Trip addAttractionToTrip(@RequestBody TripAndBusinessDetails trip_andBusinessDetails){
    Art dbbd = new Art(trip_andBusinessDetails.getBusinessDetails());
    Trip trip = tripRepo.findOne(trip_andBusinessDetails.getTrip().getId());
    trip.getArts().add(dbbd);
    return tripRepo.save(trip);
  }

  @CrossOrigin
  @RequestMapping(path = "/save/nightlife",method = RequestMethod.PUT)
  private Trip addNightlifeToTrip(@RequestBody TripAndBusinessDetails trip_andBusinessDetails){
    Nightlife dbbd = new Nightlife(trip_andBusinessDetails.getBusinessDetails());
    Trip trip = tripRepo.findOne(trip_andBusinessDetails.getTrip().getId());
    trip.getNightlife().add(dbbd);
    return tripRepo.save(trip);
  }

  @CrossOrigin
  @RequestMapping(path = "/save/shopping",method = RequestMethod.PUT)
  private Trip addShoppingToTrip(@RequestBody TripAndBusinessDetails trip_andBusinessDetails){
    Shopping dbbd = new Shopping(trip_andBusinessDetails.getBusinessDetails());
    Trip trip = tripRepo.findOne(trip_andBusinessDetails.getTrip().getId());
    trip.getShopping().add(dbbd);
    return tripRepo.save(trip);
  }

  @CrossOrigin
  @RequestMapping(path = "/save/spa",method = RequestMethod.PUT)
  private Trip addSpaToTrip(@RequestBody TripAndBusinessDetails trip_andBusinessDetails){
    Spa dbbd = new Spa(trip_andBusinessDetails.getBusinessDetails());
    Trip trip = tripRepo.findOne(trip_andBusinessDetails.getTrip().getId());
    trip.getSpas().add(dbbd);
    return tripRepo.save(trip);
  }


  // Other Delete routes
  @CrossOrigin
  @RequestMapping(path = "/arts/{id}",method = RequestMethod.DELETE)
  private Trip deleteArts(@PathVariable(value = "id")int id,@RequestBody Trip trip){
    tripRepo.findOne(trip.getId()).getArts().remove(id);
    return tripRepo.findOne(trip.getId());
  }

  @CrossOrigin
  @RequestMapping(path = "/attraction/{id}",method = RequestMethod.DELETE)
  private Trip deleteAttraction(@PathVariable(value = "id")int id,@RequestBody Trip trip){
    tripRepo.findOne(trip.getId()).getAttractions().remove(id);
    return tripRepo.findOne(trip.getId());
  }

  @CrossOrigin
  @RequestMapping(path = "/nightlife/{id}",method = RequestMethod.DELETE)
  private Trip deleteNightlife(@PathVariable(value = "id")int id,@RequestBody Trip trip){
    tripRepo.findOne(trip.getId()).getNightlife().remove(id);
    return tripRepo.findOne(trip.getId());
  }

  @CrossOrigin
  @RequestMapping(path = "/shopping/{id}",method = RequestMethod.DELETE)
  private Trip deleteShopping(@PathVariable(value = "id")int id,@RequestBody Trip trip){
    tripRepo.findOne(trip.getId()).getShopping().remove(id);
    return tripRepo.findOne(trip.getId());
  }

  @CrossOrigin
  @RequestMapping(path = "/spa/{id}",method = RequestMethod.DELETE)
  private Trip deleteSpa(@PathVariable(value = "id")int id,@RequestBody Trip trip){
    tripRepo.findOne(trip.getId()).getSpas().remove(id);
    return tripRepo.findOne(trip.getId());
  }
}
