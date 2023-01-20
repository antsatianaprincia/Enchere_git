package com.example.encherews.service;

import com.example.encherews.model.BankAccount;
import com.example.encherews.repository.BankAccountRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService  {

    @Autowired
    BankAccountRep bankAccountRep;


    public List<BankAccount> getAll(){
        return bankAccountRep.findAll();
}


    public BankAccount save(BankAccount bankAccount){
        return bankAccountRep.save(bankAccount);
    }
}
