package com.gotszalk.travelservice.tripPackage.utils;

import com.gotszalk.travelservice.tripPackage.models.Trip;
import com.gotszalk.travelservice.tripPackage.models.Trip_DTO;

public class TripMapper {

    public static Trip_DTO mapTripToTrip_DTO(Trip trip){
        return new Trip_DTO.Builder()
                .tripId(trip.getTripId())
                .totalCost(trip.getTotalCost())
                .status(trip.getStatus())
                .salesman(trip.getSalesman())
                .build();
    }
}
