package com.gotszalk.travelservice.tripPackage.controllers;


import com.gotszalk.travelservice.tripPackage.models.Trip;
import com.gotszalk.travelservice.tripPackage.models.TripInputForm;
import com.gotszalk.travelservice.tripPackage.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripController {

    private TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping(path = "trip/addTrip")
    public @ResponseBody ResponseEntity<String> addTrip(@RequestBody TripInputForm inputForm){
        try {
            Trip trip = tripService.createTrip(inputForm);
            return ResponseEntity.ok(trip.getTripId().toString());
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
