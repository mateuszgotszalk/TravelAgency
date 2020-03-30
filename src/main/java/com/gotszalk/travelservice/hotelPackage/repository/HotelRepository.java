package com.gotszalk.travelservice.hotelPackage.repository;

import com.gotszalk.travelservice.hotelPackage.models.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {

    Optional<Hotel> findByHotelNameAndHotelCityAndHotelCountry(String hotelName, String hotelCity, String hotelCountry);
}