package com.gotszalk.travelservice.models.hotel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gotszalk.travelservice.models.offer.Offer;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hotelId;
    private String hotelName;
    private String hotelCountry;
    private String hotelCity;

    @JsonIgnore
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
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
        this.offers = offers;
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
}
