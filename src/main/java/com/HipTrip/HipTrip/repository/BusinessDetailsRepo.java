package com.HipTrip.HipTrip.repository;

import com.HipTrip.HipTrip.models.DataBase.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface BusinessDetailsRepo extends CrudRepository<Hotel,Integer>{
}
