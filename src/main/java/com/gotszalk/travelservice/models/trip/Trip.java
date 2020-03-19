package com.gotszalk.travelservice.models.trip;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gotszalk.travelservice.models.person.Person;
import com.gotszalk.travelservice.models.offer.Offer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripId;
    private BigDecimal totalCost;
    private String salesman;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Person> people;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "offer_id")
    private Offer offer;

    public Trip() {
    }

    public Trip(Long tripId, BigDecimal totalCost, /*List<Person> passengerList,*/ String salesman) {
        this.tripId = tripId;
        this.totalCost = totalCost;
       // this.passengerList = passengerList;
        this.salesman = salesman;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
