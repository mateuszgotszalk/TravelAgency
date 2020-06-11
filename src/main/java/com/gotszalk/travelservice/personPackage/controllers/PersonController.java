package com.gotszalk.travelservice.personPackage.controllers;

import com.gotszalk.travelservice.personPackage.models.Person;
import com.gotszalk.travelservice.personPackage.models.PersonInput;
import com.gotszalk.travelservice.personPackage.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(path = "people/addPerson")
    public @ResponseBody ResponseEntity<?> addPerson(@RequestBody PersonInput input){

        try {
            return ResponseEntity.ok(personService.createPerson(input));
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(path = "people/addPeople", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> addPeople(List<PersonInput> inputPeople) {

        List<Person> people = new LinkedList<>();

        try {
            for (PersonInput item : inputPeople) {
                people.add(personService.createPerson(item));
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(people);
    }

    @RequestMapping(path = "people/getPeople", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getPeople(){
        try{

            return ResponseEntity.ok(personService.getPeople());

        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(path = "people/getPerson/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getPerson(@PathVariable String id){
        try{
            return ResponseEntity.ok(personService.getPerson_DTO(id));

        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found person " + id);
        }
    }

    @RequestMapping(path = "people/deletePerson/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<String> deletePerson(@PathVariable String id){
        try{
            personService.deletePerson(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok("{ \"Deleted person with id\": " + id + "}");
    }
}
