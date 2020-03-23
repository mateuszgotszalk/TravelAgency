package com.gotszalk.travelservice.hotelPackage.controllers;

import com.gotszalk.travelservice.hotelPackage.models.Hotel;
import com.gotszalk.travelservice.hotelPackage.models.HotelInputForm;
import com.gotszalk.travelservice.hotelPackage.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @RequestMapping(path = "hotels/addHotel", method = RequestMethod.POST)
    public ResponseEntity<String> addHotel(@RequestBody HotelInputForm hotelInput){

        Hotel hotel = null;
        try {
            hotel = hotelService.createHotel(hotelInput);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
       return ResponseEntity.ok(hotel.getHotelId().toString());
    }

    @RequestMapping(path = "hotels/addHotelList", method = RequestMethod.POST)
    public ResponseEntity<String> addHotelList(@RequestBody HotelInputForm[] inputHotels){

        List<Hotel> hotels = new LinkedList<>();

        try{
            for (HotelInputForm item : inputHotels) {
                    hotels.add(hotelService.createHotel(item));
            }
        }catch(Exception e){
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("Zapisane: " + hotels.toString());
    }

    @RequestMapping(path = "hotels/getHotels", method = RequestMethod.GET)
    public ResponseEntity<String> getHotels(){
        try{
            List<Hotel> hotels = hotelService.getHotels();
            return ResponseEntity.ok(hotels.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(path = "hotels/getHotel/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getHotel(@PathVariable String id){
        try{
            Hotel hotel = hotelService.getHotel(id);
            return ResponseEntity.ok(hotel.toString());

        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found hotel " + id);
        }
    }

    @RequestMapping(path = "hotels/deleteHotel", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteHotel(String id){
        try{
            hotelService.deleteHotel(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok("Deleted hotel with id " + id);
    }
}