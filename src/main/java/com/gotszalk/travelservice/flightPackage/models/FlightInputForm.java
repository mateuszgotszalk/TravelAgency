package com.gotszalk.travelservice.flightPackage.models;

import java.math.BigDecimal;
import java.util.Objects;

public class FlightInputForm {

    private String departureAirport;
    private String departureCountry;
    private String departureDate;
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
        this.departureDate = departureDate;
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

    private FlightInputForm(final Builder builder){
        this.departureAirport = builder.departureAirport;
        this.departureCountry = builder.departureCountry;
        this.departureDate = builder.departureDate;
        this.arrivalAirport = builder.arrivalAirport;
        this.arrivalCountry = builder.arrivalCountry;
        this.arrivalDate = builder.arrivalDate;
        this.flightCost = builder.flightCost;
    }

    public static class Builder{
        private String departureAirport;
        private String departureCountry;
        private String departureDate;
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

        public Builder departureDate(String DepartureDate){
            this.departureDate = DepartureDate;
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

    @Override
    public String toString() {
        return "FlightInputForm{" +
                "departureAirport='" + departureAirport + '\'' +
                ", departureCountry='" + departureCountry + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", arrivalCountry='" + arrivalCountry + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", flightCost=" + flightCost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightInputForm that = (FlightInputForm) o;
        return getDepartureAirport().equals(that.getDepartureAirport()) &&
                getDepartureCountry().equals(that.getDepartureCountry()) &&
                getDepartureDate().equals(that.getDepartureDate()) &&
                getArrivalAirport().equals(that.getArrivalAirport()) &&
                getArrivalCountry().equals(that.getArrivalCountry()) &&
                getArrivalDate().equals(that.getArrivalDate()) &&
                getFlightCost().equals(that.getFlightCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepartureAirport(), getDepartureCountry(), getDepartureDate(), getArrivalAirport(), getArrivalCountry(), getArrivalDate(), getFlightCost());
    }
}
