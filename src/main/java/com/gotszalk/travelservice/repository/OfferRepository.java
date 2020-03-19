package com.gotszalk.travelservice.repository;

import com.gotszalk.travelservice.models.offer.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {
}
