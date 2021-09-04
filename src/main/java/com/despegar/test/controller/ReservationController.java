package com.despegar.test.controller;

import com.despegar.test.dto.Reservation;
import com.despegar.test.enums.LoadingType;
import com.despegar.test.helpers.Dictionary;
import com.despegar.test.helpers.Utilities;
import com.despegar.test.page.PaymentPage;
import com.despegar.test.page.ResultsPage;
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

    public static void selectFlight(){
        GeneralController.waitWhileLoading(LoadingType.PROGRESS_BAR);
        ResultsPage resultsPage = new ResultsPage();
        Reservation.setPrice(resultsPage.getFlightPrice());
        resultsPage.clickBoxFirstFlight();
        GeneralController.waitWhileLoading(LoadingType.LOOP);
        resultsPage.clickBtnSelectFirstFlight();
        GeneralController.waitWhileLoading(LoadingType.LOOP);
        if (resultsPage.baggagePopupIsVisible()) {
            resultsPage.clickStandardBaggage();
            resultsPage.clickBtnContinueBaggage();
            GeneralController.waitWhileLoading(LoadingType.LOOP);
        }
    }

    public static void compareFlightInfo(){
        PaymentPage paymentPage = new PaymentPage();
        AssertController.compare("Price", Reservation.getPrice(), paymentPage.getFlightPrice());
        String cities = String.format("%s - %s", Reservation.getOriginCity(), Reservation.getDestinationCity());
        AssertController.compare("Cities", cities, paymentPage.getCities());
        String date = Utilities.getDateAsFormat(Reservation.getDepartureDate(), Dictionary.DateFormat.DD_MMM_YYYY);
        AssertController.compare("Departure date", date, paymentPage.getDepartureDate());
        date = Utilities.getDateAsFormat(Reservation.getReturnDate(), Dictionary.DateFormat.DD_MMM_YYYY);
        AssertController.compare("Return date", date, paymentPage.getReturnDate());
    }

}
