package com.gotszalk.travelservice.personPackage.repository;

import com.gotszalk.travelservice.personPackage.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
