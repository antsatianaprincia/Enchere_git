package com.example.encherews.service;

import com.example.encherews.model.Offer;
import com.example.encherews.repository.OfferRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    OfferRep offerRep;

    public List<Offer> getAllOffre(){
        List<Offer> list = offerRep.findAll();
        return list;
    }

    public Offer save(Offer offer) {
        return  offerRep.save(offer);
    }


    public List<Offer> getOfferByIdAuction(int idAuction){
        return offerRep.getOfferByIdAuction(idAuction);
    }
}
