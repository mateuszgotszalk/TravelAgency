package com.gotszalk.travelservice.repository;

import com.gotszalk.travelservice.models.trip.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {
}
