package com.gotszalk.travelservice.personPackage.service;


import com.gotszalk.travelservice.personPackage.models.Person;
import com.gotszalk.travelservice.personPackage.models.PersonInput;
import com.gotszalk.travelservice.personPackage.models.Person_DTO;
import com.gotszalk.travelservice.personPackage.repository.PersonRepository;
import com.gotszalk.travelservice.personPackage.utils.PersonMapper;
import com.gotszalk.travelservice.tripPackage.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(PersonInput input) throws IllegalArgumentException{

        Optional<Person> person = personRepository
                .findByNameAndSurrNameAndDateOfBirth(input.getName(), input.getSurrName(), input.getDateOfBirth());

        return person.orElseGet(() -> savePerson(input));
    }

    private Person savePerson(PersonInput input){

        Person person = new Person();
        person.setName(input.getName());
        person.setSurrName(input.getSurrName());
        person.setDateOfBirth(input.getDateOfBirth());
        person.setRole(input.getRole());
        personRepository.save(person);
        return person;
    }

    public List<Person_DTO> getPeople(){
        return ((List<Person>)personRepository.findAll())
                .stream()
                .map(PersonMapper::mapPersonToPersonDTO)
                .collect(Collectors.toList());
    }

    public Person_DTO getPerson_DTO(String id) throws IllegalArgumentException{
        Optional<Person> person = personRepository.findById(Long.valueOf(id));
        if(person.isPresent()){
            return PersonMapper.mapPersonToPersonDTO(person.get());
        } else {
            throw new IllegalArgumentException("Not Found person " + id);
        }
    }

    public void deletePerson(String id){
        personRepository.deleteById(Long.valueOf(id));
    }
}
