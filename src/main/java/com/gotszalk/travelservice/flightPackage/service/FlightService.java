package com.gotszalk.travelservice.flightPackage.service;

import com.gotszalk.travelservice.flightPackage.models.Flight;
import com.gotszalk.travelservice.flightPackage.models.FlightInputForm;
import com.gotszalk.travelservice.flightPackage.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight createFlight(FlightInputForm flightInput) throws IllegalArgumentException{

        Optional<Flight> flight = flightRepository
                .findByDepartureAirportAndArrivalAirportAndDepartureDate
                        (flightInput.getDepartureAirport(), flightInput.getArrivalAirport(), flightInput.getDepartureDate());

            return flight.orElseGet(() -> saveFlight(flightInput));
    }

    private Flight saveFlight(FlightInputForm flightInput){

        Flight flight = new Flight();
        flight.setArrivalAirport(flightInput.getArrivalAirport());
        flight.setArrivalCountry(flightInput.getArrivalCountry());
        flight.setArrivalDate(flightInput.getArrivalDate());
        flight.setDepartureAirport(flightInput.getDepartureAirport());
        flight.setDepartureCountry(flightInput.getDepartureCountry());
        flight.setDepartureDate(flightInput.getDepartureDate());
        flight.setFlightCost(flightInput.getFlightCost());
        flightRepository.save(flight);
        return flight;
    }

    public List<Flight> getFLights(){
        return (List<Flight>)flightRepository.findAll();
    }

    public Flight getFlight(String id) throws IllegalArgumentException{
        Optional<Flight> flight = flightRepository.findById(Long.valueOf(id));
        if(flight.isPresent()){
            return flight.get();
        } else {
            throw new IllegalArgumentException("Not Found flight " + id);
        }
    }

    public void deleteFlight(String id){
        flightRepository.deleteById(Long.valueOf(id));
    }
}
