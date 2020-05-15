package com.gotszalk.travelservice.personPackage.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gotszalk.travelservice.tripPackage.models.Trip;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;
    private String name;
    private String surrName;
    private String dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @ManyToMany(mappedBy = "people", cascade = CascadeType.ALL)
    private Set<Trip> trips;

    public Person() {
    }

    public Person(String name, String surrName, String dateOfBirth) {
        this.name = name;
        this.surrName = surrName;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurrName() {
        return surrName;
    }

    public void setSurrName(String surrName) {
        this.surrName = surrName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = new HashSet<Trip>();
        this.trips.addAll(trips);
    }

    public void addTrip(Trip trip){
        trips.add(trip);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", surrName='" + surrName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getPersonId().equals(person.getPersonId()) &&
                getName().equals(person.getName()) &&
                getSurrName().equals(person.getSurrName()) &&
                getDateOfBirth().equals(person.getDateOfBirth()) &&
                getRole() == person.getRole() &&
                Objects.equals(getTrips(), person.getTrips());
    }
}
