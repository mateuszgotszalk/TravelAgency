package com.gotszalk.travelservice.personPackage.controllers;

import com.gotszalk.travelservice.personPackage.models.Person;
import com.gotszalk.travelservice.personPackage.models.PersonInput;
import com.gotszalk.travelservice.personPackage.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(path = "people/addPerson")
    public @ResponseBody ResponseEntity<String> addPerson(@RequestBody PersonInput input){

        if(input == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input is empty");
        }
        else {
            Person person = new Person();
            person.setName(input.getName());
            person.setSurrName(input.getSurrName());
            person.setDateOfBirth(input.getDateOfBirth());
            person.setRole(input.getRole());
            try {
                personRepository.save(person);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
            return ResponseEntity.ok(person.getPersonId() + "");
        }
    }

    @RequestMapping(path = "people/addPeople", method = RequestMethod.POST)
    public ResponseEntity<String> addPeople(List<PersonInput> inputPeople){

        List<Person> people = new LinkedList<>();

        if (inputPeople !=null){
            for(PersonInput item: inputPeople){
                Person person = new Person();
                person.setName(item.getName());
                person.setSurrName(item.getSurrName());
                person.setDateOfBirth(item.getDateOfBirth());
                person.setRole(item.getRole());
                people.add(person);
            }

            for (Person i: people){
                personRepository.save(i);
            }

            return ResponseEntity.status(HttpStatus.OK).body("Zapisane");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input is empty");
        }
    }

    @RequestMapping(path = "people/getPeople", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getPeople(){

        List<Person> people = null;

        try{
            people = (List<Person>)personRepository.findAll();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(people);
        }
        return ResponseEntity.ok(people);
    }

    @RequestMapping(path = "people/getPerson/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getPerson(@PathVariable String id){

        Optional<Person> person = personRepository.findById(Long.valueOf(id));

        if(person.isPresent()){
            return ResponseEntity.ok(person.get().toString());
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found person " + id);
        }
    }

    @RequestMapping(path = "people/deletePerson", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePerson(Long id){
        try{
            personRepository.deleteById(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok("deleted person with id " + id);
    }
}
