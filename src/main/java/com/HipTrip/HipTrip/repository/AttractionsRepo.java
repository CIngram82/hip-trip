package com.HipTrip.HipTrip.repository;

import com.HipTrip.HipTrip.models.DataBase.Attraction;
import org.springframework.data.repository.CrudRepository;

public interface AttractionsRepo extends CrudRepository<Attraction, Integer> {
}
