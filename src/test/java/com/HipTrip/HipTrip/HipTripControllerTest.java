package com.HipTrip.HipTrip;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class HipTripControllerTest {

  //Make a test DataBase
  /*
  @Test
public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
  throws ClientProtocolException, IOException {

   // Given
   String name = RandomStringUtils.randomAlphabetic( 8 );
   HttpUriRequest request = new HttpGet( "https://api.github.com/users/" + name );

   // When
   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

   // Then
   assertThat(
     httpResponse.getStatusLine().getStatusCode(),
     equalTo(HttpStatus.SC_NOT_FOUND));
}
   */

  @Test
  public void newTripTest() {
    // look up how to test routes.
    //get number of trips in test Database
    //run new trip with budget and destination
    // number of trips is now +1.
  }
  @Test
  public void newTripTestNoBudget(){
    // look up how to test routes.
    //get number of trips in test Database
    //run new trip with no budget
    // error == "missing budget"
    // number of trips == starting trips;
  }
  @Test
  public void newTripTestNoDestination(){
    // look up how to test routes.
    //get number of trips in test Database
    //run new trip with no destination
    // error == "missing destination"
    // number of trips == starting trips;
  }
  @Test
  public void newTripTestNoInfo(){
    // look up how to test routes.
    //get number of trips in test Database
    //run new trip with no destination && no budget
    // error == "missing budget"
    // number of trips == starting trips;
  }

  @Test
  public void getAllTripDetailsGet(){
    // test route with Get.
    // returns all trips.
  }
}
