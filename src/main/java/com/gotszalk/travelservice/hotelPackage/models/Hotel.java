package com.gotszalk.travelservice.hotelPackage.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gotszalk.travelservice.offerPackage.models.Offer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hotelId;
    private String hotelName;
    private String hotelCountry;
    private String hotelCity;

    @JsonIgnore
    @OneToMany(mappedBy = "hotel")
    private List<Offer> offers;

    public Hotel() {
    }

    public Hotel(String hotelName, String hotelCountry, String hotelCity) {
        this.hotelName = hotelName;
        this.hotelCountry = hotelCountry;
        this.hotelCity = hotelCity;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
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

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = new ArrayList<Offer>();
        this.offers.addAll(offers);
    }

    public void addOffer(Offer offer){
        offer.setHotel(this);
        offers.add(offer);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", hotelCountry='" + hotelCountry + '\'' +
                ", hotelCity='" + hotelCity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(getHotelId(), hotel.getHotelId()) &&
                Objects.equals(getHotelName(), hotel.getHotelName()) &&
                Objects.equals(getHotelCountry(), hotel.getHotelCountry()) &&
                Objects.equals(getHotelCity(), hotel.getHotelCity()) &&
                Objects.equals(getOffers(), hotel.getOffers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHotelId(), getHotelName(), getHotelCountry(), getHotelCity(), getOffers());
    }
}
