package com.example.encherews.service;


import com.example.encherews.model.Auction;
import com.example.encherews.repository.AuctionRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AuctionService {

    @Autowired
    AuctionRep auctionRep;


    public List<Auction> getAll(){
                return auctionRep.findAll();
    }

    public Auction findById(int idAuction){
                return auctionRep.findById(idAuction).get();
    }

    public Auction save(Auction auction){
        return auctionRep.save(auction);
    }

    public List<Auction> findByDescriptionsOrPubDateOrPriceOrIsClosed(String descriptions, Timestamp pubDate, double price, int isClosed){
        return auctionRep.findByDescriptionsOrPubDateOrPriceOrIsClosed(descriptions,pubDate,price,isClosed);
    }


}
