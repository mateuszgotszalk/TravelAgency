package com.gotszalk.travelservice.hotelPackage.models;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    private Hotel hotel = new Hotel();
    private Hotel hotel1 = new Hotel();

    @Before
    void setUp() {

        hotel.setHotelId(1234L);
        hotel.setHotelName("Test");
        hotel.setHotelCity("City");
        hotel.setHotelCountry("Country");

        hotel1.setHotelId(1234L);
        hotel1.setHotelName("Test");
        hotel1.setHotelCity("City");
        hotel1.setHotelCountry("Country");
    }

    @Test
    void hashCodeTest() {
        assertEquals(hotel.hashCode(), hotel1.hashCode());
    }

    @Test
    void equalsTest() {
        assertEquals(hotel, hotel1);
    }
}