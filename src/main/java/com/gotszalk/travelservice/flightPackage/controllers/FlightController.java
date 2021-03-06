package com.gotszalk.travelservice.flightPackage.controllers;

import com.gotszalk.travelservice.flightPackage.models.Flight;
import com.gotszalk.travelservice.flightPackage.models.FlightInputForm;
import com.gotszalk.travelservice.flightPackage.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class FlightController {

    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(path = "flights/addFlight")
    public @ResponseBody ResponseEntity<?> addFlight(@RequestBody FlightInputForm flightInput){
        try {
            return ResponseEntity.ok(flightService.createFlight(flightInput));
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(path = "flights/getFlights", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getFlights(){
        try{
            return ResponseEntity.ok(flightService.getFLights());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(path = "flights/getFlight/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getFlight(@PathVariable String id){
        try{
            return ResponseEntity.ok(flightService.getFlight(id));

        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found hotel " + id);
        }
    }

    @RequestMapping(path = "flights/deleteFlight/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<String> deleteFlight(@PathVariable String id){
        try{
            flightService.deleteFlight(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok("Deleted flight with id " + id);
    }
}
