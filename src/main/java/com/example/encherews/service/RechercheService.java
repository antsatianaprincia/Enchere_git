package com.example.encherews.service;

import com.example.encherews.model.Auction;
import com.example.encherews.model.RequeteRecherche;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechercheService {

    @PersistenceContext
    EntityManager entity;

    public List<Auction> rechercheAvance(RequeteRecherche recherche){
        List<Auction> list = null;

        try{
            Query query = entity.createNativeQuery(recherche.reqFinale(), Auction.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


}
