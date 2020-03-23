package com.gotszalk.travelservice.hotelPackage.repository;

import com.gotszalk.travelservice.hotelPackage.models.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {
}