package com.gotszalk.travelservice.offerPackage.service;

import com.gotszalk.travelservice.flightPackage.models.Flight;
import com.gotszalk.travelservice.flightPackage.models.FlightInputForm;
import com.gotszalk.travelservice.flightPackage.service.FlightService;
import com.gotszalk.travelservice.hotelPackage.models.Hotel;
import com.gotszalk.travelservice.hotelPackage.models.HotelInputForm;
import com.gotszalk.travelservice.hotelPackage.service.HotelService;
import com.gotszalk.travelservice.offerPackage.models.Offer;
import com.gotszalk.travelservice.offerPackage.models.OfferInputForm;
import com.gotszalk.travelservice.offerPackage.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    private OfferRepository offerRepository;
    private HotelService hotelService;
    private FlightService flightService;

    @Autowired
    public OfferService(OfferRepository offerRepository, HotelService hotelService, FlightService flightService) {
        this.offerRepository = offerRepository;
        this.hotelService = hotelService;
        this.flightService = flightService;
    }


    public Offer createOffer(OfferInputForm input) throws IllegalArgumentException{

        Offer offer = null;

        if(input == null){
            throw new IllegalArgumentException("Input is empty");
        }
        else {
            offer = saveOffer(input);
            return offer;
        }
    }

    private Offer saveOffer(OfferInputForm inputForm){

        HotelInputForm hotelForm = new HotelInputForm.Builder()
                .hotelName(inputForm.getHotelName())
                .hotelCity(inputForm.getHotelCity())
                .hotelCountry(inputForm.getHotelCountry())
                .build();
        Hotel hotel = hotelService.createHotel(hotelForm);

        FlightInputForm flightForm = new FlightInputForm.Builder()
                .flightCost(inputForm.getFlightCost())
                .departureAirport(inputForm.getDepartureAirport())
                .departureCountry(inputForm.getDepartureCountry())
                .DepartureDate(inputForm.getDepartureDate())
                .arrivalAirport(inputForm.getArrivalAirport())
                .arrivalCountry(inputForm.getArrivalCountry())
                .arrivalDate(inputForm.getArrivalDate())
                .build();

        Flight flight = flightService.createFlight(flightForm);

        Offer offer = new Offer();
        offer.setStandard(inputForm.getStandard());
        offer.setPrice(inputForm.getPrice());
        offer.setKindOfApartment(inputForm.getKindOfApartment());
        offer.setHotel(hotel);
        offer.setFlight(flight);
        offerRepository.save(offer);
        return offer;
    }

    public List<Offer> getOffers(){
        return (List<Offer>)offerRepository.findAll();
    }

    public Offer getOffer(String id) throws IllegalArgumentException{
        Optional<Offer> offer = offerRepository.findById(Long.valueOf(id));
        if(offer.isPresent()){
            return offer.get();
        } else {
            throw new IllegalArgumentException("Not found offer " + id);
        }
    }

    public void deleteOffer(String id){
        offerRepository.deleteById(Long.valueOf(id));
    }
}
