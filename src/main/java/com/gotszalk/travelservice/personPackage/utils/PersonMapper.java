package com.gotszalk.travelservice.personPackage.utils;

import com.gotszalk.travelservice.personPackage.models.Person;
import com.gotszalk.travelservice.personPackage.models.Person_DTO;
import com.gotszalk.travelservice.tripPackage.utils.TripMapper;

import java.util.stream.Collectors;

public class PersonMapper {

    public static Person_DTO mapPersonToPersonDTO(Person person){
        return new Person_DTO.Builder()
                .name(person.getName())
                .surrName(person.getSurrName())
                .dateOfBirth(person.getDateOfBirth())
                .role(person.getRole())
                .trips_DTO(
                        person.getTrips()
                        .stream()
                        .map(TripMapper::mapTripToTrip_DTO)
                                .collect(Collectors.toList()))
                .build();
    }
}
