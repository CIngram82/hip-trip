package com.HipTrip.HipTrip;


import com.HipTrip.HipTrip.repository.BusinessDetailsRepo;
import com.HipTrip.HipTrip.repository.TripRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
//@JsonTest
public class HipTripControllerTest {
  @Autowired
  TripRepo tripRepo;

  @Autowired
  BusinessDetailsRepo businessDetailsRepo;

  @Autowired
//  private


  @Test
  public void getAllTripDetailsGet(){
    // test route with Get.
    // returns all trips.
  }
}
