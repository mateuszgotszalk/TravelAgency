package com.gotszalk.travelservice.repository;

import com.gotszalk.travelservice.models.flight.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
}
