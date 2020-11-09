package com.gotszalk.travelservice.tripPackage.service;

import com.gotszalk.travelservice.offerPackage.models.Offer;
import com.gotszalk.travelservice.offerPackage.service.OfferService;
import com.gotszalk.travelservice.personPackage.models.Person;
import com.gotszalk.travelservice.personPackage.models.PersonInput;
import com.gotszalk.travelservice.personPackage.models.Role;
import com.gotszalk.travelservice.personPackage.service.PersonService;
import com.gotszalk.travelservice.tripPackage.models.Status;
import com.gotszalk.travelservice.tripPackage.models.Trip;
import com.gotszalk.travelservice.tripPackage.models.TripInputForm;
import com.gotszalk.travelservice.tripPackage.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final PersonService personService;
    private final OfferService offerService;

    @Autowired
    public TripService(TripRepository tripRepository, PersonService personService, OfferService offerService) {
        this.tripRepository = tripRepository;
        this.personService = personService;
        this.offerService = offerService;
    }

    public Trip addTrip(TripInputForm inputForm) {
        //init
        Set<Person> people = createPeopleSet(inputForm);
        Offer offer = offerService.getOffer(inputForm.getOfferId());

        return createTrip(inputForm, offer, people);
    }

    private Trip createTrip(TripInputForm inputForm, Offer offer, Set<Person> people){
        //create Trip
        Trip trip = new Trip.Builder()
                .people(people)
                .salesman(inputForm.getSalesman())
                .offer(offer)
                .status(Status.UTWORZONA)
                .totalCost(calculateCost(offer.getPrice(), people))
                .build();
        tripRepository.save(trip);
        return trip;
    }

    BigDecimal calculateCost(BigDecimal price, Set<Person> people) {

        BigDecimal totalCost = BigDecimal.ZERO;

        for(Person person : people){
            if (person.getRole().equals(Role.CLIENT) || person.getRole().equals(Role.PASSENGER)){
                totalCost = totalCost.add(price);
            }
        }
        return totalCost;
    }

    private Set<Person> createPeopleSet(TripInputForm inputForm){
        Set<Person> people = new HashSet<>();
        for (PersonInput personInput: inputForm.getPeople()){
            Person person = personService.createPerson(personInput);
            people.add(person);
        }
        return people;
    }

    public Trip getTrip(String id) throws IllegalArgumentException{
        Optional<Trip> trip = tripRepository.findById(Long.valueOf(id));
        if(trip.isPresent()){
            return trip.get();
        } else {
            throw new IllegalArgumentException("Not found trip " + id);
        }
    }

    public List<Trip> getTrips(){
        return (List<Trip>)tripRepository.findAll();
    }

    public void updateTrip(String id, Status status){
        tripRepository.updateStatus(Long.valueOf(id), status);
    }

    @Transactional
    public void deleteTrip(String id){
        Optional<Trip> trip = tripRepository.findById(Long.valueOf(id));
        trip.ifPresent(value -> {
            value.getPeople().removeAll(value.getPeople());
            tripRepository.delete(trip.get());
        });
    }
}
