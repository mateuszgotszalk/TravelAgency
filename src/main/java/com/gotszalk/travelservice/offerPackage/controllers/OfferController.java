package com.gotszalk.travelservice.offerPackage.controllers;

import com.gotszalk.travelservice.offerPackage.models.Offer;
import com.gotszalk.travelservice.offerPackage.models.OfferInputForm;
import com.gotszalk.travelservice.offerPackage.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OfferController {

    private OfferRepository offerRepository;

    @Autowired
    public OfferController(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @PostMapping(path = "offer/addOffer")
    public @ResponseBody ResponseEntity<String> addOffer(@RequestBody OfferInputForm inputForm){

        if(inputForm == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input is empty");
        } else {
            //najpier add hotel potem add flight i potem robimy oferte
        }
    }


    @GetMapping(path = "offer/getOffers")
    public @ResponseBody ResponseEntity<String> getOffers(){

        List<Offer> offers = null;
        try{
            offers = (List<Offer>)offerRepository.findAll();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(offers.toString());
    }

    @GetMapping(path = "hotels/getHotel/{id}")
    public ResponseEntity<String> getOffer(@PathVariable String id){
        Optional<Offer> offer = offerRepository.findById(Long.valueOf(id));
        if(offer.isPresent()){
            return ResponseEntity.ok(offer.get().toString());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found offer " + id);
        }
    }
}
