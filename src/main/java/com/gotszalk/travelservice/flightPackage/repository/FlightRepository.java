package com.gotszalk.travelservice.flightPackage.repository;

import com.gotszalk.travelservice.flightPackage.models.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
}
