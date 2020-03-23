package com.gotszalk.travelservice.hotelPackage.models;

public class HotelInputForm {

    private String hotelName;
    private String hotelCountry;
    private String hotelCity;

    public HotelInputForm() {
    }

    public HotelInputForm(String hotelName, String hotelCountry, String hotelCity) {
        this.hotelName = hotelName;
        this.hotelCountry = hotelCountry;
        this.hotelCity = hotelCity;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelCountry() {
        return hotelCountry;
    }

    public void setHotelCountry(String hotelCountry) {
        this.hotelCountry = hotelCountry;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }
}
