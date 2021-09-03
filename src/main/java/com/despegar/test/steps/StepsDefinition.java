package com.despegar.test.steps;

import com.despegar.test.controller.GeneralController;
import com.despegar.test.helpers.Report;
import com.despegar.test.action.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition {

    //----------------------------------------------------------------------------------------------------------------->
    //---------- BEFORE & AFTER --------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    @Before
    public static void setUp(){
        Report.initReport();
        DriverManager.initDriverManager();
    }

    @After
    public static void tearDown(){
        DriverManager.finish();
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- STEPS ------------------------------------------------------------------------------------------------>
    //----------------------------------------------------------------------------------------------------------------->

    @Given("^two cities (.*?) and (.*?)$")
    public void anUserFromWappiApp(String origin, String destination){
        GeneralController.openDespegarApp();
    }

    @When("^a flight reservation is made$")
    public void iMakeTheLogin(){

    }

    @Then("^the application shows correct info for reservation$")
    public void updateUserPersonalInfo(){

    }

}
