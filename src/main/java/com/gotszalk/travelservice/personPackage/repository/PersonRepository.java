package com.gotszalk.travelservice.personPackage.repository;

import com.gotszalk.travelservice.personPackage.models.Person;
import com.gotszalk.travelservice.tripPackage.models.Trip;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByNameAndSurrNameAndDateOfBirth(String name, String surrName, String dateOfBirth);

    /*@Transactional
    @Modifying
    @Query("update Person p set p.trips = :trips where p.personId = :id")
    void addTrip(@Param("id") Long id, @Param("trips") Set<Trip> trips);*/
}
