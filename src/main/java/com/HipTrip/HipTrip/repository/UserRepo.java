package com.HipTrip.HipTrip.repository;



import com.HipTrip.HipTrip.models.DataBase.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
  User findByNameAndPassword(String name, String password);

}