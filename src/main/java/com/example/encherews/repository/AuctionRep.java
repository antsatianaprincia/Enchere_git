package com.example.encherews.repository;


import com.example.encherews.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface AuctionRep extends JpaRepository<Auction,Integer> {

//    @Query(value = "Select * from  Auction where descriptions LIKE %?1% or pubdate::text LIKE %?2% or price::text LIKE %?3% or isClosed::text LIKE %?4%)",nativeQuery = true)
//    public List<Auction> findByDescriptionsOrPubDateOrPriceOrIsClosed(String descriptions, Timestamp pubDate, double price, int idClosed);


     public List<Auction> findByDescriptionsOrPubDateOrPriceOrIsClosed(String descriptions, Timestamp pubDate, double price, int idClosed);




}
