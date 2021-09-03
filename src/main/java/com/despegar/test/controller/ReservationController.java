package com.despegar.test.controller;

import com.despegar.test.dto.Reservation;
import com.despegar.test.helpers.Dictionary;
import com.despegar.test.helpers.Utilities;
import com.despegar.test.page.SearchPage;

public class ReservationController {

    private ReservationController(){}

    public static void searchFlights(){
        SearchPage searchPage = new SearchPage();
        searchPage.writeOriginCity(Reservation.getOriginCity());
        searchPage.clickCityOption();
        searchPage.writeDestinationCity(Reservation.getDestinationCity());
        searchPage.clickCityOption();
        searchPage.clickBtnDepartureDate();
        String yearMonth = Utilities.getDateAsFormat(Reservation.getDepartureDate(), Dictionary.DateFormat.YYYY_MM);
        String day = Utilities.getDateAsFormat(Reservation.getDepartureDate(), Dictionary.DateFormat.D);
        GeneralController.selectDate(yearMonth, day);
        searchPage.clickBtnReturnDate();
        yearMonth = Utilities.getDateAsFormat(Reservation.getReturnDate(), Dictionary.DateFormat.YYYY_MM);
        day = Utilities.getDateAsFormat(Reservation.getReturnDate(), Dictionary.DateFormat.D);
        GeneralController.selectDate(yearMonth, day);
        searchPage.clickBtnSearch();
    }



}
