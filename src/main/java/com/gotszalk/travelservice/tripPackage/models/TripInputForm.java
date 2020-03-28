package com.gotszalk.travelservice.tripPackage.models;
import com.gotszalk.travelservice.personPackage.models.PersonInput;

public class TripInputForm {

    private String salesman;
    private PersonInput[] people;
    private String offerId;

    public TripInputForm() {
    }

    public TripInputForm(String salesman, PersonInput[] people, String offerId) {
        this.salesman = salesman;
        this.people = people;
        this.offerId = offerId;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public PersonInput[] getPeople() {
        return people;
    }

    public void setPeople(PersonInput[] people) {
        this.people = people;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }
}
