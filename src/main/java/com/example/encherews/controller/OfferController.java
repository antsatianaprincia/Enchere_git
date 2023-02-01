package com.example.encherews.controller;

import com.example.encherews.model.Offer;
import com.example.encherews.model.User;
import com.example.encherews.service.OfferService;
import com.example.encherews.utile.MyJson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/offers")
public class OfferController {
    OfferService offerService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Offer> list=null;
        //MyJson mj = new MyJson();
        try {

            list = offerService.getAllOffre();
           // mj.setData(list);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          //  mj.setError(e);
        }
        //return ResponseEntity.ok(mj);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Offer offer){
        Offer offer1 = null;
        try {
            offer1= offerService.save(offer);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(offer1);
    }
}
