package com.gotszalk.travelservice.models.offer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gotszalk.travelservice.models.flight.Flight;
import com.gotszalk.travelservice.models.hotel.Hotel;

import javax.persistence.*;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long offerId;

    private double price;

    @Enumerated(EnumType.STRING)
    private Standard standard;

    @Enumerated(EnumType.STRING)
    private Status status;

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

    public Offer(double price, Standard standard, Status status, String kindOfApartment) {
        this.price = price;
        this.standard = standard;
        this.status = status;
        this.kindOfApartment = kindOfApartment;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
