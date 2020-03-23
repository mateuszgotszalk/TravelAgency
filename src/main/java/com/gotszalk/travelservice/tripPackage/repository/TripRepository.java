package com.gotszalk.travelservice.tripPackage.repository;

import com.gotszalk.travelservice.tripPackage.models.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {
}
