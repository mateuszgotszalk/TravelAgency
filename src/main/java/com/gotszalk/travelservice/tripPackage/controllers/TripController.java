package com.gotszalk.travelservice.tripPackage.controllers;

import com.gotszalk.travelservice.tripPackage.models.Status;
import com.gotszalk.travelservice.tripPackage.models.TripInputForm;
import com.gotszalk.travelservice.tripPackage.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping(path = "trip/addTrip")
    public @ResponseBody ResponseEntity<?> addTrip(@RequestBody TripInputForm inputForm){
        try {
            return ResponseEntity.ok(tripService.addTrip(inputForm));
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(path = "trip/getTrips")
    public @ResponseBody ResponseEntity<?> getTrips(){
        try{
            return ResponseEntity.ok(tripService.getTrips());
        }catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Error error){
            System.out.println("Error: " );
            System.out.println(error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }catch (Throwable throwable){
            System.out.println("Throwable: " );
            System.out.println(throwable.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(throwable.getMessage());
        }
    }

    @GetMapping(path = "trip/getTrip/{id}")
    public ResponseEntity<?> getTrip(@PathVariable String id){
        try{
            return ResponseEntity.ok(tripService.getTrip(id));

        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found trip " + id);
        }
    }

    @DeleteMapping(path = "trip/deleteTrip/{id}")
    public @ResponseBody ResponseEntity<String> deleteTrip(@PathVariable String id){
        try{
            tripService.deleteTrip(id);
        }catch (Exception | Error e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok("{ \"Deleted trip with id\": " + id + "}");
    }

    @PutMapping(path = "trip/changeStatus/{id}")
    public @ResponseBody ResponseEntity<?> updateStatus(@PathVariable String id, @RequestBody Status status){
        try{
            tripService.updateTrip(id, status);
            return ResponseEntity.ok("{ \"OK\": \"updated\" }");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
