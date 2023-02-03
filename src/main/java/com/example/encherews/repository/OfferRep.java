package com.example.encherews.repository;

import com.example.encherews.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OfferRep extends JpaRepository<Offer,Integer> {

    @Query(value = "select * from offer where idauction=:id",nativeQuery = true)
    public List<Offer> getOfferByIdAuction(@Param("id") int id);

}
