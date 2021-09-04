package com.despegar.test.steps;

import com.despegar.test.controller.GeneralController;
import com.despegar.test.controller.ReservationController;
import com.despegar.test.dto.Reservation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReservationSteps {

    //----------------------------------------------------------------------------------------------------------------->
    //---------- STEPS ------------------------------------------------------------------------------------------------>
    //----------------------------------------------------------------------------------------------------------------->

    @Given("^two cities (.*?) and (.*?)$")
    public void twoCitiesOriginAndDestionation(String origin, String destination){
        Reservation.initReservation(origin, destination);
        GeneralController.openDespegarApp();
    }

    @When("^a flight reservation is made$")
    public void aFlightReservationIsMade(){
        ReservationController.searchFlights();
        ReservationController.selectFlight();
    }

    @Then("^the application shows correct info for reservation$")
    public void theApplicationShowsCorrectInfoForReservation(){
        ReservationController.compareFlightInfo();
    }

}
