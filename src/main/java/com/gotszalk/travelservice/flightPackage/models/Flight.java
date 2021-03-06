package com.gotszalk.travelservice.flightPackage.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gotszalk.travelservice.offerPackage.models.Offer;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flightId;
    private String departureAirport;
    private String departureCountry;
    private String departureDate;
    private String arrivalAirport;
    private String arrivalCountry;
    private String arrivalDate;
    private BigDecimal flightCost;

    @JsonIgnore
    @OneToMany(mappedBy = "flight")
    private List<Offer> offers;

    public Flight(String departureAirport, String departureCountry, String departureDate,
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

    public Flight() {
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
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

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = new ArrayList<Offer>();
        this.offers.addAll(offers);
    }

    public void addOffer(Offer offer){
        offer.setFlight(this);
        offers.add(offer);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", departureAirport='" + departureAirport + '\'' +
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
        Flight flight = (Flight) o;
        return getFlightId().equals(flight.getFlightId()) &&
                getDepartureAirport().equals(flight.getDepartureAirport()) &&
                getDepartureCountry().equals(flight.getDepartureCountry()) &&
                getDepartureDate().equals(flight.getDepartureDate()) &&
                getArrivalAirport().equals(flight.getArrivalAirport()) &&
                getArrivalCountry().equals(flight.getArrivalCountry()) &&
                getArrivalDate().equals(flight.getArrivalDate()) &&
                getFlightCost().equals(flight.getFlightCost()) &&
                Objects.equals(getOffers(), flight.getOffers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlightId(), getDepartureAirport(), getDepartureCountry(),
                getDepartureDate(), getArrivalAirport(), getArrivalCountry(),
                getArrivalDate(), getFlightCost(), getOffers());
    }
}
