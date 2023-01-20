package com.example.encherews.controller;

import com.example.encherews.model.Duration;
import com.example.encherews.model.Offer;
import com.example.encherews.service.DurationService;
import com.example.encherews.service.OfferService;
import com.example.encherews.utile.MyJson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/offers")
public class OfferCnt {
    OfferService offerService;

    public ResponseEntity<?> getAll(){
        List<Offer> list=null;
        MyJson mj = new MyJson();
        try {

            list=offerService.getAll();
            mj.setData(list);
        }
        catch (Exception e){
            mj.setError(e);
        }
        return ResponseEntity.ok(mj);
    }
}
