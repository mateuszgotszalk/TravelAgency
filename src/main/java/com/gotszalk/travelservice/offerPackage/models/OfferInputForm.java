package com.gotszalk.travelservice.offerPackage.models;

import java.math.BigDecimal;

public class OfferInputForm {

    private BigDecimal price;
    private Standard standard;
    private String kindOfApartment;

    private String hotelName;
    private String hotelCountry;
    private String hotelCity;

    private String departureAirport;
    private String departureCountry;
    private String departureDate;
    private String arrivalAirport;
    private String arrivalCountry;
    private String arrivalDate;
    private BigDecimal flightCost;

    public OfferInputForm() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public String getKindOfApartment() {
        return kindOfApartment;
    }

    public void setKindOfApartment(String kindOfApartment) {
        this.kindOfApartment = kindOfApartment;
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

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getArrivalCountry() {
        return arrivalCountry;
    }

    public void setArrivalCountry(String arrivalCountry) {
        this.arrivalCountry = arrivalCountry;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public BigDecimal getFlightCost() {
        return flightCost;
    }

    public void setFlightCost(BigDecimal flightCost) {
        this.flightCost = flightCost;
    }

    @Override
    public String toString() {
        return "OfferInputForm{" +
                "price=" + price +
                ", standard=" + standard +
                ", kindOfApartment='" + kindOfApartment + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", hotelCountry='" + hotelCountry + '\'' +
                ", hotelCity='" + hotelCity + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", departureCountry='" + departureCountry + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", arrivalCountry='" + arrivalCountry + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", flightCost=" + flightCost +
                '}';
    }
}
