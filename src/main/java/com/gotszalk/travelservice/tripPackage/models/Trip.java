package com.gotszalk.travelservice.tripPackage.models;

import com.gotszalk.travelservice.personPackage.models.Person;
import com.gotszalk.travelservice.offerPackage.models.Offer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripId;

    private BigDecimal totalCost;
    private String salesman;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany
    @JoinTable(
        name = "trip_person",
        joinColumns = @JoinColumn(name = "trip_id"),
        inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> people = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    public Trip() {
    }

    public Trip(Long tripId, BigDecimal totalCost, String salesman, Status status) {
        this.tripId = tripId;
        this.totalCost = totalCost;
        this.salesman = salesman;
        this.status = status;
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
        this.people = new HashSet<Person>();
        this.people.addAll(people);
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addPerson(Person person){
        people.add(person);
        person.getTrips().add(this);
    }

    public void removePerson(Person person){
        people.remove(person);
        person.getTrips().remove(this);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripId=" + tripId +
                ", totalCost=" + totalCost +
                ", salesman='" + salesman + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return getTripId().equals(trip.getTripId()) &&
                getTotalCost().equals(trip.getTotalCost()) &&
                getSalesman().equals(trip.getSalesman()) &&
                getStatus() == trip.getStatus() &&
                getPeople().equals(trip.getPeople()) &&
                getOffer().equals(trip.getOffer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripId, totalCost, salesman, status, people, offer);
    }

    private Trip(final Builder builder) {
        this.salesman = builder.salesman;
        this.people = builder.people;
        this.offer = builder.offer;
        this.status = builder.status;
        this.totalCost = builder.totalCost;
    }

    public static class Builder{
        private Long tripId;
        private BigDecimal totalCost;
        private String salesman;
        private Status status;
        private Set<Person> people;
        private Offer offer;

        public Builder() {
        }

        public Builder tripId(Long tripId) {
            this.tripId = tripId;
            return this;
        }

        public Builder totalCost(BigDecimal totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public Builder salesman(String salesman) {
            this.salesman = salesman;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder people(Set<Person> people) {
            this.people = people;
            return this;
        }

        public Builder offer(Offer offer) {
            this.offer = offer;
            return this;
        }

        public Trip build(){
            return new Trip(this);
        }
    }
}
