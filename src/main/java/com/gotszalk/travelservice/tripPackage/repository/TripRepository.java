package com.gotszalk.travelservice.tripPackage.repository;

import com.gotszalk.travelservice.tripPackage.models.Status;
import com.gotszalk.travelservice.tripPackage.models.Trip;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {

    @Transactional
    @Modifying
    @Query("update Trip t set t.status = :newStatus where t.tripId = :id")
    void updateStatus(@Param("id") Long id, @Param("newStatus") Status status);
}
