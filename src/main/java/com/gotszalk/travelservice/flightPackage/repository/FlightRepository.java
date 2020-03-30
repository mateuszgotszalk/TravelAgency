package com.gotszalk.travelservice.flightPackage.repository;

import com.gotszalk.travelservice.flightPackage.models.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
    Optional<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDate(String departureAirport, String arrivalAirport, String departureDate);
}
