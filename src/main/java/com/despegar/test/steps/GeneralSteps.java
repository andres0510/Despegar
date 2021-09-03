package com.despegar.test.steps;

import com.despegar.test.action.DriverManager;
import com.despegar.test.helpers.Report;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class GeneralSteps {

    private GeneralSteps(){}

    @Before
    public static void setUp(){
        Report.init();
        DriverManager.init();
    }

    @After
    public static void tearDown(){
        DriverManager.finish();
    }

}
