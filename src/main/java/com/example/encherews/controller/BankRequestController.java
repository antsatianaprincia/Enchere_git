package com.example.encherews.controller;

import com.example.encherews.model.BankRequest;
import com.example.encherews.service.BankRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
@CrossOrigin
@RequestMapping("/bankrequests")
public class BankRequestController {

    @Autowired
    BankRequestService bankRequestService;

    @PostMapping
    public ResponseEntity<BankRequest> envoyeDemande(@RequestBody BankRequest bankRequest){
        try {
            LocalDateTime dateNow = LocalDateTime.now();
            Timestamp time = Timestamp.valueOf(dateNow);
            bankRequest.setRequestDate(time);

            BankRequest br = bankRequestService.save(bankRequest);
            return ResponseEntity.ok(br);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
