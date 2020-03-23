package com.gotszalk.travelservice.offerPackage.repository;

import com.gotszalk.travelservice.offerPackage.models.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {
}
