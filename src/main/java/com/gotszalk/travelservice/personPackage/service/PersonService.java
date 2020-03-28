package com.gotszalk.travelservice.personPackage.service;


import com.gotszalk.travelservice.personPackage.models.Person;
import com.gotszalk.travelservice.personPackage.models.PersonInput;
import com.gotszalk.travelservice.personPackage.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Person createPerson(PersonInput input) throws IllegalArgumentException{
        Person person = savePerson(input);
        return person;
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

    public List<Person> getPeople(){
        return (List<Person>)personRepository.findAll();
    }

    public Person getPerson(String id) throws IllegalArgumentException{
        Optional<Person> person = personRepository.findById(Long.valueOf(id));
        if(person.isPresent()){
            return person.get();
        } else {
            throw new IllegalArgumentException("Not Found person " + id);
        }
    }

    public void deletePerson(String id){
        personRepository.deleteById(Long.valueOf(id));
    }
}
