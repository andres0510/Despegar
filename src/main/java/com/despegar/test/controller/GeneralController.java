package com.despegar.test.controller;

import com.despegar.test.action.DriverManager;
import com.despegar.test.helpers.Dictionary;
import com.despegar.test.helpers.PropertiesFile;
import com.despegar.test.helpers.Report;
import com.despegar.test.page.CalendarPage;

public class GeneralController {

    private GeneralController(){}

    //----------------------------------------------------------------------------------------------------------------->
    //---------- INIT & LOGIN ----------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public static void openDespegarApp() {
        PropertiesFile properties = new PropertiesFile(Dictionary.PropertiesPath.DEFAULT);
        String appUrl = properties.getProperty("despegar.url");
        DriverManager.open(appUrl);
        Report.reportInfo(String.format(Dictionary.Messages.SUCCESS, "Open Despegar app"));
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- DATE PICKER ------------------------------------------------------------------------------------------>
    //----------------------------------------------------------------------------------------------------------------->

    public static void selectDate(String yearMonth, String day){
        CalendarPage calendarPage = new CalendarPage();
        if (!calendarPage.searchedMonthIsVisible(yearMonth)) {
            searchMonth(yearMonth);
        }
        calendarPage.clickOptionDay(yearMonth, day);
    }

    private static void searchMonth(String yearMonth) {
        CalendarPage calendarPage = new CalendarPage();
        int monthChange = 0;
        final int MAX_MONTH_CHANGE = 5;
        do {
            if (MAX_MONTH_CHANGE == monthChange) {
                Report.reportFail(String.format("Month '%s' not found", yearMonth));
            }
            calendarPage.clickBtnNextMonth();
            monthChange++;
        } while (!calendarPage.searchedMonthIsVisible(yearMonth));
    }

}
