package com.example.encherews.controller;

import com.example.encherews.model.BankAccount;
import com.example.encherews.service.BankAccountService;
import com.example.encherews.utile.MyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/bankaccounts")
public class BankAccountCnt {

    @Autowired
    BankAccountService bankAccountService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<BankAccount> list=null;
//        MyJson mj = new MyJson();
        try {
            list=bankAccountService.getAll();
           // mj.setData(list);
        }
        catch (Exception e){
           // mj.setError(e);
        }
        //return ResponseEntity.ok(mj);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<BankAccount> rechargerCompte(@RequestBody BankAccount bankAccount){
        try {
            BankAccount bankAccount1 = bankAccountService.save(bankAccount);
            return ResponseEntity.ok(bankAccount1);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
