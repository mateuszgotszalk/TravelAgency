package com.gotszalk.travelservice.offerPackage.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gotszalk.travelservice.flightPackage.models.Flight;
import com.gotszalk.travelservice.hotelPackage.models.Hotel;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long offerId;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Standard standard;

    private String kindOfApartment;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Offer() {
    }

    public Offer(BigDecimal price, Standard standard, String kindOfApartment) {
        this.price = price;
        this.standard = standard;
        this.kindOfApartment = kindOfApartment;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
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

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
