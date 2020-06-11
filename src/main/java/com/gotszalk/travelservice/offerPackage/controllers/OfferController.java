package com.gotszalk.travelservice.offerPackage.controllers;

import com.gotszalk.travelservice.offerPackage.models.Offer;
import com.gotszalk.travelservice.offerPackage.models.OfferInputForm;
import com.gotszalk.travelservice.offerPackage.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class OfferController {

    private OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping(path = "offer/addOffer")
    public @ResponseBody
    ResponseEntity<?> addOffer(@RequestBody OfferInputForm inputForm) {
        try {
            return ResponseEntity.ok(offerService.createOffer(inputForm));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(path = "offer/getOffers")
    public @ResponseBody
    ResponseEntity<?> getOffers() {
        try {
            return ResponseEntity.ok(offerService.getOffers());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(path = "offer/getOffer/{id}")
    public ResponseEntity<?> getOffer(@PathVariable String id) {
        try {
            return ResponseEntity.ok(offerService.getOffer(id));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found offer " + id);
        }
    }

    @DeleteMapping(path = "offer/deleteOffer/{id}")
    public @ResponseBody
    ResponseEntity<String> deleteOffer(@PathVariable String id) {
        try {
            offerService.deleteOffer(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok("{ \"Deleted offer with id\": " + id + "}");
    }
}
