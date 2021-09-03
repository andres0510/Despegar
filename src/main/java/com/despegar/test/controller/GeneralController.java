package com.despegar.test.controller;

import com.despegar.test.action.DriverManager;
import com.despegar.test.helpers.Dictionary;
import com.despegar.test.helpers.PropertiesFile;
import com.despegar.test.helpers.Report;

public class GeneralController {

    private GeneralController(){}

    //----------------------------------------------------------------------------------------------------------------->
    //---------- INIT & LOGIN ----------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public static void openDespegarApp() {
        PropertiesFile properties = new PropertiesFile(Dictionary.PropertiesPath.DEFAULT);
        String wappiUrl = properties.getProperty("despegar.url");
        DriverManager.open(wappiUrl);
        Report.reportInfo(String.format(Dictionary.Messages.SUCCESS, "Open Despegar app"));
    }

}
