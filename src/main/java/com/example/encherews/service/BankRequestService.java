package com.example.encherews.service;

import com.example.encherews.model.BankRequest;
import com.example.encherews.repository.BankRequestRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankRequestService {

    @Autowired
    BankRequestRep bankRequestRep;

    public BankRequest save(BankRequest bankRequest){
        return bankRequestRep.save(bankRequest);
    }
}
