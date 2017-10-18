//package com.HipTrip.HipTrip;
//
//
//import com.HipTrip.HipTrip.models.DataBase.Trip;
//import com.HipTrip.HipTrip.repository.BusinessDetailsRepo;
//import com.HipTrip.HipTrip.repository.TripRepo;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringBootTest
//public class HipTripControllerTest {
//  @Autowired
//  TripRepo tripRepo;
//
//  @Autowired
//  BusinessDetailsRepo businessDetailsRepo;
//
//  @Autowired
//  private MockMvc mvc;
//
//
//  @Test
//  public void newTripTest()throws Exception {
///* given(this.userVehicleService.getVehicleDetails("sboot"))
//           .willReturn(new VehicleDetails("Honda", "Civic"));
//   this.mvc.perform(get("/sboot/vehicle").accept(MediaType.TEXT_PLAIN))
//           .andExpect(status().isOk()).andExpect(content().string("Honda Civic")); */
//    long startCount = tripRepo.count();
//    Trip t = new Trip(3,"new york,NY");
//    String result = "";
//  mvc.perform(post("/newTrip").accept())
//      .andExpect(status().isOk()).andExpect(content().string(result));
//    //get number of trips in test Database
//    //run new trip with budget and destination
//
//    long endCount = tripRepo.count();
//    assert endCount == startCount +1;
//  }
//  @Test
//  public void newTripTestNoBudget(){
//    // look up how to test routes.
//    //get number of trips in test Database
//    //run new trip with no budget
//    // error == "missing budget"
//    // number of trips == starting trips;
//  }
//  @Test
//  public void newTripTestNoDestination(){
//    // look up how to test routes.
//    //get number of trips in test Database
//    //run new trip with no destination
//    // error == "missing destination"
//    // number of trips == starting trips;
//  }
//  @Test
//  public void newTripTestNoInfo(){
//    // look up how to test routes.
//    //get number of trips in test Database
//    //run new trip with no destination && no budget
//    // error == "missing budget"
//    // number of trips == starting trips;
//  }
//
//  @Test
//  public void getAllTripDetailsGet(){
//    // test route with Get.
//    // returns all trips.
//  }
//}
