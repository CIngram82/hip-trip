package com.HipTrip.HipTrip.Controllers;


import com.HipTrip.HipTrip.models.DataBase.Trip;
import com.HipTrip.HipTrip.repository.BusinessDetailsRepo;
import com.HipTrip.HipTrip.repository.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HipTripController {
  @Autowired
  TripRepo tripRepo;
  @Autowired
  BusinessDetailsRepo businessDetailsRepo;
//  @Autowired
//  UserRepo usersRepo;

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


  @CrossOrigin //Database
  @RequestMapping(path = "/hotel/{id}",method = RequestMethod.DELETE)
  private Trip deleteHotel(@PathVariable(value = "id")int id,@RequestBody Trip trip){
  tripRepo.findOne(trip.getId()).getHotels().remove(id);

    return tripRepo.findOne(trip.getId());
  }


}
