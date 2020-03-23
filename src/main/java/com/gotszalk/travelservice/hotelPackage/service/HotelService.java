package com.gotszalk.travelservice.hotelPackage.service;

import com.gotszalk.travelservice.hotelPackage.models.Hotel;
import com.gotszalk.travelservice.hotelPackage.models.HotelInputForm;
import com.gotszalk.travelservice.hotelPackage.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class HotelService {

    private HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel createHotel(HotelInputForm hotelInput) throws IllegalArgumentException{

        Hotel hotel = null;

        if(hotelInput == null){
            throw new IllegalArgumentException("Input is empty");
        }
        else {
                hotel = saveHotel(hotelInput);
                return hotel;
        }
    }

    private Hotel saveHotel(HotelInputForm inputForm){

        Hotel hotel = new Hotel();
        hotel.setHotelName(inputForm.getHotelName());
        hotel.setHotelCity(inputForm.getHotelCity());
        hotel.setHotelCountry(inputForm.getHotelCountry());
        hotelRepository.save(hotel);
        return hotel;
    }

    public List<Hotel> getHotels(){
        return (List<Hotel>)hotelRepository.findAll();
    }

    public Hotel getHotel(String id) throws IllegalArgumentException{
        Optional<Hotel> hotel = hotelRepository.findById(Long.valueOf(id));
        if(hotel.isPresent()){
            return hotel.get();
        } else {
            throw new IllegalArgumentException("Not Found hotel " + id);
        }
    }

    public void deleteHotel(String id){
        hotelRepository.deleteById(Long.valueOf(id));
    }
}
