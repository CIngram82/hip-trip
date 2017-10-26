package com.HipTrip.HipTrip.repository;

import com.HipTrip.HipTrip.models.DataBase.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepo extends CrudRepository<Trip , Integer>{
  //User findByNameAndPassword(String name, String password);
  Trip findById(int id);
}
