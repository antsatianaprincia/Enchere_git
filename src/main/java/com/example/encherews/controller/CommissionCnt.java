package com.example.encherews.controller;

import com.example.encherews.model.Commission;
import com.example.encherews.service.CommissionService;
import com.example.encherews.utile.MyJson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/commisions")
public class CommissionCnt {
    CommissionService commissionService;

    public ResponseEntity<?> getAll(){
        List<Commission> list=null;
        MyJson mj = new MyJson();
        try {
            list=commissionService.getAll();
            mj.setData(list);
        }
        catch (Exception e){
            mj.setError(e);
        }
        return ResponseEntity.ok(mj);
    }
}
