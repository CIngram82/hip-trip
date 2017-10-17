package com.HipTrip.HipTrip.repository;

import com.HipTrip.HipTrip.models.DataBase.DatabaseBusinessDetails;
import org.springframework.data.repository.CrudRepository;

public interface BusinessDetailsRepo extends CrudRepository<DatabaseBusinessDetails,Integer>{
}
