package com.gotszalk.travelservice.flightPackage.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    private Flight flight = new Flight();
    private Flight flight1 = new Flight();

    @BeforeEach
    void setUp() {
        flight.setFlightId(123L);
        flight.setFlightCost(BigDecimal.valueOf(700.5));
        flight.setArrivalAirport("ArrivalAiR");
        flight.setArrivalCountry("ArrivalCountry");
        flight.setArrivalDate("20-05-2020 22:23:04");
        flight.setDepartureAirport("DepartureA");
        flight.setDepartureCountry("DepartureCountry");
        flight.setDepartureDate("20-05-2020 23:23:04");

        flight1.setFlightId(123L);
        flight1.setFlightCost(BigDecimal.valueOf(700.5));
        flight1.setArrivalAirport("ArrivalAiR");
        flight1.setArrivalCountry("ArrivalCountry");
        flight1.setArrivalDate("20-05-2020 22:23:04");
        flight1.setDepartureAirport("DepartureA");
        flight1.setDepartureCountry("DepartureCountry");
        flight1.setDepartureDate("20-05-2020 23:23:04");
    }

    @Test
    void flightHashCodeTest() {
        assertEquals(flight.hashCode(), flight1.hashCode());
    }

    @Test
    void flightEqualsTest() {
        assertEquals(flight, flight1);
    }
}