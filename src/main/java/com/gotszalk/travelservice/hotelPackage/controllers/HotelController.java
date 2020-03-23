package com.gotszalk.travelservice.hotelPackage.controllers;

import com.gotszalk.travelservice.hotelPackage.models.Hotel;
import com.gotszalk.travelservice.hotelPackage.models.HotelInputForm;
import com.gotszalk.travelservice.hotelPackage.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class HotelController {

    private HotelRepository hotelRepository;

    @Autowired
    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @RequestMapping(path = "hotels/addHotel", method = RequestMethod.POST)
    public ResponseEntity<String> addHotel(@RequestBody HotelInputForm hotelInput){
        if(hotelInput == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input is empty");
        }
        else {
            Hotel hotel = new Hotel();
            hotel.setHotelName(hotelInput.getHotelName());
            hotel.setHotelCity(hotelInput.getHotelCity());
            hotel.setHotelCountry(hotelInput.getHotelCountry());
            try {
                hotelRepository.save(hotel);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
            return ResponseEntity.ok(hotel.getHotelId() + "");
        }
    }

    @RequestMapping(path = "hotels/addHotelList", method = RequestMethod.POST)
    public ResponseEntity<String> addHotelList(@RequestBody HotelInputForm[] inputHotels){

        List<Hotel> hotels = new LinkedList<>();

        if (inputHotels !=null){

            for(HotelInputForm item: inputHotels){
                Hotel hotel = new Hotel();
                hotel.setHotelName(item.getHotelName());
                hotel.setHotelCity(item.getHotelCity());
                hotel.setHotelCountry(item.getHotelCountry());
                hotels.add(hotel);
            }

            for (Hotel i: hotels){
                hotelRepository.save(i);
            }

            return ResponseEntity.status(HttpStatus.OK).body("Zapisane: " + hotels.toString());
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input is empty");
        }
    }

    @RequestMapping(path = "hotels/getHotels", method = RequestMethod.GET)
    public ResponseEntity<List<Hotel>> getHotels(){
        List<Hotel> hotels = (List<Hotel>)hotelRepository.findAll();
        return ResponseEntity.ok(hotels);
    }

    @RequestMapping(path = "hotels/getHotel/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getHotel(@PathVariable String id){
        Optional<Hotel> hotel = hotelRepository.findById(Long.valueOf(id));
        if(hotel.isPresent()){
            return ResponseEntity.ok(hotel.get().toString());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found hotel " + id);
        }
    }

    @RequestMapping(path = "hotels/deleteHotel", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteHotel(Long id){
        try{
            hotelRepository.deleteById(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok("deleted hotel with id " + id);
    }
}