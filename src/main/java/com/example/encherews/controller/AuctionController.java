package com.example.encherews.controller;

import com.example.encherews.model.*;
import com.example.encherews.service.AuctionService;
import com.example.encherews.utile.MyJson;
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

            @GetMapping
            public ResponseEntity<?>getAll(){
                List<Auction> list=null;
                MyJson mj = new MyJson();
                try {
                    list=auctionService.getAll();
                    mj.setData(list);
                }
                catch (Exception e){
                        mj.setError(e);
                }
                return ResponseEntity.ok(mj);
            }

            @PostMapping
            public ResponseEntity<Auction> newAuction(@RequestBody Auction auction){
                Auction auction1=null;
                try{
                    LocalDateTime dateNow = LocalDateTime.now();
                    Timestamp time = Timestamp.valueOf(dateNow);
                    auction.setPubDate(time);
                    auction1 = auctionService.save(auction);
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

                    return ResponseEntity.ok(auction);
                }
                catch (Exception e){
                    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
    }



}
