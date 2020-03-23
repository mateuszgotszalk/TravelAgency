package com.gotszalk.travelservice.flightPackage.models;

import java.math.BigDecimal;

public class FlightInputForm {

    private String departureAirport;
    private String departureCountry;
    private String DepartureDate;
    private String arrivalAirport;
    private String arrivalCountry;
    private String arrivalDate;
    private BigDecimal flightCost;

    public FlightInputForm() {
    }

    public FlightInputForm(String departureAirport, String departureCountry, String departureDate,
                           String arrivalAirport, String arrivalCountry, String arrivalDate,
                           BigDecimal flightCost) {
        this.departureAirport = departureAirport;
        this.departureCountry = departureCountry;
        DepartureDate = departureDate;
        this.arrivalAirport = arrivalAirport;
        this.arrivalCountry = arrivalCountry;
        this.arrivalDate = arrivalDate;
        this.flightCost = flightCost;
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
        return DepartureDate;
    }

    public void setDepartureDate(String departureDate) {
        DepartureDate = departureDate;
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

    private FlightInputForm(final Builder builder){
        this.departureAirport = builder.departureAirport;
        this.departureCountry = builder.departureCountry;
        this.DepartureDate = builder.DepartureDate;
        this.arrivalAirport = builder.arrivalAirport;
        this.arrivalCountry = builder.arrivalCountry;
        this.arrivalDate = builder.arrivalDate;
        this.flightCost = builder.flightCost;
    }

    public static class Builder{
        private String departureAirport;
        private String departureCountry;
        private String DepartureDate;
        private String arrivalAirport;
        private String arrivalCountry;
        private String arrivalDate;
        private BigDecimal flightCost;

        public Builder() {
        }

        public Builder departureAirport(String departureAirport){
            this.departureAirport = departureAirport;
            return this;
        }

        public Builder departureCountry(String departureCountry){
            this.departureCountry = departureCountry;
            return this;
        }

        public Builder DepartureDate(String DepartureDate){
            this.DepartureDate = DepartureDate;
            return this;
        }

        public Builder arrivalAirport(String arrivalAirport){
            this.arrivalAirport = arrivalAirport;
            return this;
        }

        public Builder arrivalCountry(String arrivalCountry){
            this.arrivalCountry = arrivalCountry;
            return this;
        }

        public Builder arrivalDate(String arrivalDate){
            this.arrivalDate = arrivalDate;
            return this;
        }

        public Builder flightCost(BigDecimal flightCost){
            this.flightCost = flightCost;
            return this;
        }

        public FlightInputForm build(){
            return new FlightInputForm(this);
        }
    }
}
