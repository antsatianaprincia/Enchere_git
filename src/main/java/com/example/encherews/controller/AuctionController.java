package com.example.encherews.controller;

import com.example.encherews.model.*;
import com.example.encherews.service.AuctionService;
import com.example.encherews.service.ImageService;
import com.example.encherews.service.RechercheService;
import com.example.encherews.utile.MyJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/auctions")
public class AuctionController {


    @Autowired
    AuctionService auctionService;

    @Autowired
    RechercheService rechercheService;

    @Autowired
    ImageService imageService;

            @GetMapping("/get")
            public ResponseEntity<?>getAll(){
                List<Auction> list=null;
                Image img = new Image();
                MyJson mj = new MyJson();
                try {
                    list=auctionService.getAll();
                    for (int i = 0; i < list.size(); i++) {
                        img=imageService.findByIdAuction(list.get(i).getId());
                        list.get(i).setImage(img);
                    }
                    mj.setData(list);
                }
                catch (Exception e){
                        mj.setError(e);
                }
                return ResponseEntity.ok(mj);
            }

            @GetMapping("/img/{id}")
            public ResponseEntity<Image> getImg(@PathVariable ("id") int id){
                Image i = imageService.findByIdAuction(id);
                return ResponseEntity.ok(i);
            }

            @PostMapping("/save")
            public ResponseEntity<Image> save(@RequestBody Image image){
                Image i = imageService.save(image);

                return ResponseEntity.ok(i);
            }

            @PostMapping("/post")
            public ResponseEntity<Auction> newAuction(@RequestBody Auction auction, Image image){
                Auction auction1=null;
                try{
                    LocalDateTime dateNow = LocalDateTime.now();
                    Timestamp time = Timestamp.valueOf(dateNow);
                    auction.setPubDate(time);
                    auction1 = auctionService.save(auction);
                    Image img = imageService.save(image);
                    auction1.setImage(img);
                    //auctionService.save(auction.getDescriptions(),auction.getPrice(),auction.getMinPrice(),auction.getSoldPrice(),auction.getProducts().getId(),auction.getDuration().getId());
                }
                catch (Exception e){
                    new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                return ResponseEntity.ok(auction1);
            }


    @GetMapping("{id}")
    public ResponseEntity<Auction> getById(@PathVariable ("id") int idAuction){
                try {
                    Auction auction = auctionService.findById(idAuction);
                    Image img = imageService.findByIdAuction(idAuction);
                    auction.setImage(img);

                    return ResponseEntity.ok(auction);
                }
                catch (Exception e){
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
    }


    @PostMapping("/recherche")
    public ResponseEntity<List<Auction>> rechercheAvance(@RequestBody RequeteRecherche recherche){
        Image img = new Image();
        try {
            List<Auction> auctions = rechercheService.rechercheAvance(recherche);
            for (int i = 0; i < auctions.size(); i++) {
                img=imageService.findByIdAuction(auctions.get(i).getId());
                auctions.get(i).setImage(img);
            }

            return ResponseEntity.ok(auctions);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/user/{idUser}")
    public ResponseEntity<?>getAuctionUser(@PathVariable ("idUser")int idUser){
        Image img = new Image();
        List<Auction> list=null;
        try {
            list = auctionService.getAuctionUser(idUser);

            for (int i = 0; i < list.size(); i++) {
                img=imageService.findByIdAuction(list.get(i).getId());
                list.get(i).setImage(img);
            }

        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(list);
    }




}
