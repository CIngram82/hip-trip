package com.HipTrip.HipTrip.Controllers;


import com.HipTrip.HipTrip.models.DataBase.Hotel;
import com.HipTrip.HipTrip.models.DataBase.Restaurant;
import com.HipTrip.HipTrip.models.DataBase.Trip;
import com.HipTrip.HipTrip.models.DataBase.Trip_add_place;
import com.HipTrip.HipTrip.repository.HotelRepo;
import com.HipTrip.HipTrip.repository.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HipTripController {
  @Autowired
  TripRepo tripRepo;
  @Autowired
  HotelRepo hotelRepo;
//  @Autowired
//  UserRepo usersRepo;

  @CrossOrigin
  @RequestMapping(path = "/newTrip", method = RequestMethod.POST)
  private Trip startNewTrip(@RequestBody Trip trip){
    trip.setHotels(new ArrayList<Hotel>() {
    });
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

//Trip roues
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
  @RequestMapping(path = "/hotel/save",method = RequestMethod.PUT)
  private Trip addHotelToTrip(@RequestBody Trip_add_place trip_add_place){
    Hotel dbbd = new Hotel(trip_add_place.getBusinessDetails());
    Trip trip = tripRepo.findOne(trip_add_place.getTrip().getId());
    List<Hotel> h = trip.getHotels();
    h.add(dbbd);
    trip.setHotels(h);
    tripRepo.save(trip);
    return tripRepo.findOne(trip.getId());
  }



  //Restaurant routes
  @CrossOrigin //Database
  @RequestMapping(path = "/restaurant/{id}",method = RequestMethod.DELETE)
  private Trip deleteRestaurant(@PathVariable(value = "id")int id,@RequestBody Trip trip){
    tripRepo.findOne(trip.getId()).getRestaurants().remove(id);
    return tripRepo.findOne(trip.getId());
  }

  @CrossOrigin
  @RequestMapping(path = "/restaurant/save",method = RequestMethod.PUT)
  private Trip addRestaurantToTrip(@RequestBody Trip_add_place trip_add_place){
    Restaurant dbbd = new Restaurant(trip_add_place.getBusinessDetails());
    Trip trip = tripRepo.findOne(trip_add_place.getTrip().getId());
    List<Restaurant> r = trip.getRestaurants();
    r.add(dbbd);
    trip.setRestaurants(r);
    tripRepo.save(trip);
    return tripRepo.findOne(trip.getId());
  }



}
