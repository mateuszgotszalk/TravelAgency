package com.gotszalk.travelservice.flightPackage.controllers;

import com.gotszalk.travelservice.flightPackage.models.Flight;
import com.gotszalk.travelservice.flightPackage.models.FlightInputForm;
import com.gotszalk.travelservice.flightPackage.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FlightController {

    private FlightRepository flightRepository;

    @Autowired
    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @RequestMapping(path = "flights/addFlight")
    public ResponseEntity<String> addFlight(@RequestBody FlightInputForm flightInput){
        if(flightInput == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input is empty");
        }
        else {
            Flight flight = new Flight();
            flight.setArrivalAirport(flightInput.getArrivalAirport());
            flight.setArrivalCountry(flightInput.getArrivalCountry());
            flight.setArrivalDate(flightInput.getArrivalDate());
            flight.setDepartureAirport(flightInput.getDepartureAirport());
            flight.setDepartureCountry(flightInput.getDepartureCountry());
            flight.setDepartureDate(flightInput.getDepartureDate());
            flight.setFlightCost(flightInput.getFlightCost());
            try {
                flightRepository.save(flight);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
            return ResponseEntity.ok(flight.getFlightId() + "");
        }
    }

    @RequestMapping(path = "flights/getFlights", method = RequestMethod.GET)
    public ResponseEntity<List<Flight>> getFlights(){
        List<Flight> flights = (List<Flight>)flightRepository.findAll();
        return ResponseEntity.ok(flights);
    }

    @RequestMapping(path = "flights/getFlight/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getFlight(@PathVariable String id){
        Optional<Flight> flight = flightRepository.findById(Long.valueOf(id));
        if(flight.isPresent()){
            return ResponseEntity.ok(flight.get().toString());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found flight " + id);
        }
    }

    @RequestMapping(path = "flights/deleteFlight", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteFlight(Long id){
        try{
            flightRepository.deleteById(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok("deleted flight with id " + id);
    }
}
