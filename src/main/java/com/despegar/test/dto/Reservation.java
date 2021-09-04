package com.despegar.test.dto;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private static String originCity;
    private static String destinationCity;
    private static Date departureDate;
    private static Date returnDate;
    private static String price;

    private Reservation(){}

    public static void initReservation(String origin, String destination) {
        originCity = origin;
        destinationCity = destination;
        Faker faker = new Faker();
        departureDate = faker.date().future(45, TimeUnit.DAYS);
        returnDate = faker.date().future(15, TimeUnit.DAYS, departureDate);
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- GETTER ----------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public static String getOriginCity() {
        return originCity;
    }

    public static String getDestinationCity() {
        return destinationCity;
    }

    public static Date getDepartureDate() {
        return departureDate;
    }

    public static Date getReturnDate() {
        return returnDate;
    }

    public static String getPrice() {
        return price;
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- SETTER ----------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public static void setPrice(String price) {
        Reservation.price = price;
    }

}
