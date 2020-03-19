package com.gotszalk.travelservice.repository;

import com.gotszalk.travelservice.models.person.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
